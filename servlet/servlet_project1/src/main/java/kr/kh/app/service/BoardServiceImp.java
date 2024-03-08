package kr.kh.app.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService {
	
	private BoardDAO boardDAO;
	private String uploadPath = "C:\\uploads";
	private SqlSession session;
	private InputStream inputStream;
	public BoardServiceImp(){
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boardDAO = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean insertBoard(BoardVO board, ArrayList<Part> partList) {
		if(board == null || 
				board.getBo_title() == null ||
				board.getBo_title().length() == 0) {
			return false;
		}
		if(board.getBo_me_id() == null) {
			return false;
		}
		if(board.getBo_content() == null) {
			return false;
		}
		boolean res = boardDAO.insertBoard(board);
		if(!res) {
			return false;
		}
		//첨부파일 업로드
		for(Part filePart : partList) {
			uploadFile(filePart,board.getBo_num());
		}
		return res;
	}
	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDAO.selectCommunityList();
	}
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		return boardDAO.selectBoardList(cri);
	}
	
	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDAO.totalCount(cri);
	}
	@Override
	public BoardVO getBoard(int num) {
		return boardDAO.selectBoard(num);
	}
	@Override
	public boolean updateView(int num) {
		boolean res = boardDAO.updateView(num);
		if(res) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteBoard(BoardVO board, MemberVO user) {
		if(user == null ) {
			return false;
		}
		if(board.getBo_me_id().equals(user.getMe_id()) || user.getMe_authority().equals("admin")) {
			//게시글의 첨부파일을 서버 폴더에서 삭제(실제 파일)
			//게시글에 있는 첨부파일리스트 정보를 가져옴
			ArrayList<FileVO> fileList = boardDAO.selectFileByBo_num(board.getBo_num());
			for(FileVO file : fileList) {
				//게시글의 첨부파일을 DB에서 삭제(기록 삭제)
				deleteFile(file);
			}
			return boardDAO.deleteBoard(board);
		}
		return false;
	}
	
	@Override
	public boolean updateBoard(BoardVO tmp, MemberVO user, ArrayList<Integer> nums, ArrayList<Part> fileList) {
		if(user == null ) {
			return false;
		}
		BoardVO board = boardDAO.selectBoard(tmp.getBo_num());
		if(board.getBo_me_id().equals(user.getMe_id())) {
			//추가된 첨부파일 추가
			for(Part file : fileList) {
				uploadFile(file, tmp.getBo_num());
			}
			//기존 첨부파일 삭제
			for(int fi_num : nums) {
				FileVO fileVO = boardDAO.selectFile(fi_num);
				deleteFile(fileVO);
			}
			return boardDAO.updateBoard(tmp);
		}
		return false;
	}
	
	@Override
	public ArrayList<FileVO> getFile(int num) {
		return boardDAO.selectFileByBo_num(num);
	}
	
	@Override
	public int recommend(int bo_num, int state, MemberVO user) {
		if(user == null) {
			throw new RuntimeException();
		}
		//게시글 번호와 아이디를 주면서 추천 정보를 가져오라고 함
		RecommendVO recommend = boardDAO.selectRecommend(user.getMe_id(), bo_num);
		//없으면 추가
		if(recommend == null) {
			recommend = new RecommendVO(user.getMe_id(), bo_num, state);
			boardDAO.insertRecommend(recommend);
			return state;
		}
		//있으면 수정
		else {
			//기존 추천 상태와 state가 같으면 취소(0으로 변경)
			if(state == recommend.getRe_state()) {
				recommend.setRe_state(0);
			}
			//다르면 state로 변경
			else {
				recommend.setRe_state(state);
			}
			boardDAO.updateRecommend(recommend);
			return recommend.getRe_state();
		}
		
	}
	
	@Override
	public int getTotalRecommendCount(int bo_num) {
		return boardDAO.selectRecommendCount(bo_num);
	}
	
	@Override
	public RecommendVO getRecommend(MemberVO user, int bo_num) {
		if(user == null) {
			return null;
		}
		return boardDAO.selectRecommend(user.getMe_id(), bo_num);
	}
	
	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null ||
				comment.getCm_content() == null ||
				comment.getCm_content().length() == 0) {
			return false;
		}
		return boardDAO.insertComment(comment);
	}
	
	@Override
	public ArrayList<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria(1,2);
		}
		return boardDAO.selectCommentList(cri);
	}
	
	@Override
	public int getTotalCountComment(CommentCriteria cri) {
		if(cri == null) {
			return 0;
		}
		return boardDAO.selectTotalCountComment(cri);
	}
	
	
	private void uploadFile(Part filePart, int bo_num) {
		// 업로드할 첨부 파일이 없으면
		if(filePart == null) {
			return;
		}
		String fileOriName = FileUploadUtils.getFileName(filePart);
		if(fileOriName == null || fileOriName.length() == 0) {
			return;
		}
		String fileName = FileUploadUtils.upload(uploadPath, filePart);
		FileVO file = new FileVO(bo_num, fileName, fileOriName);
		boardDAO.insertFile(file);
	}
	
	private void deleteFile(FileVO fileVO) {
		if(fileVO== null) {
			return;
		}
		File file = new File(uploadPath + fileVO.getFi_name().replace('/', File.separatorChar));
		if(file.exists()) {
			file.delete();
		}
		boardDAO.deleteFile(fileVO.getFi_num());
		
	}
	
	
	
	
	
	
}
