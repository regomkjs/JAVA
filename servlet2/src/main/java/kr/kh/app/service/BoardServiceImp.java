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
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService {
	private BoardDAO boardDao;
	private InputStream inputStream;
	private SqlSession session;
	private String uploadPath = "C:\\uploads";
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	}

	
	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		ArrayList<CommunityVO> list = boardDao.selectCommunityList();
		return list;
	}

	@Override
	public boolean insertBoard(BoardVO board, ArrayList<Part> partList) {
		if(board == null || 
				!checkString(board.getBo_content()) || 
				!checkString(board.getBo_title()) ) {
			return false;
		}
		if(partList == null || partList.size() == 0) {
			return false;
		}
		
		boolean res = boardDao.insertBoard(board);
		if(!res) {
			return false;
		}
		if(partList == null || partList.size() == 0) {
			return true;
		}
		for(Part part : partList) {
			uploadFile(part, board.getBo_num());
		}
		return true;
	}
	
	


	

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		ArrayList<BoardVO> list = boardDao.selectBoardList(cri);
		if(list == null) {
			return null;
		}
		return list;
	}

	
	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		
		return boardDao.selectTotalCount(cri);
	}


	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}


	@Override
	public boolean updateView(int num) {
		return boardDao.updateView(num);
	}


	@Override
	public boolean deleteBoard(MemberVO user, int num) {
		if(user == null) {
			return false;
		}
		//다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardDao.selectBoard(num);
		//게시글이 없거나 게시글 작성자와 회원 아이디가 다르면 false 반환
		if(board == null) {
			return false;
		}
		//같거나 관리자면 게시글 삭제 후 삭제 여부를 반환
		if(board.getBo_me_id().equals(user.getMe_id()) ||
				user.getMe_authority().equals("admin")) {
			//파일 삭제
			ArrayList<FileVO> fileList = boardDao.selectFileByBo_num(num);
			if(fileList.size() != 0 && fileList != null) {
				for(FileVO fileVO : fileList) {
					deleteFile(fileVO);
				}
			}
			return boardDao.deleteBoard(num);
		}
		return false;
	}


	@Override
	public boolean updateBoard(BoardVO board, int num, String[] fi_nums, ArrayList<Part> partList) {
		if(board == null ||
				!checkString(board.getBo_me_id()) ||
				!checkString(board.getBo_title())||
				!checkString(board.getBo_content())) {
			return false;
		}
		BoardVO tmp = boardDao.selectBoard(num);
		if(tmp == null || !tmp.getBo_me_id().equals(board.getBo_me_id())) {
			return false;
		}
		for(String fi_num : fi_nums) {
			try {
				int fiNum = Integer.parseInt(fi_num);
				boardDao.deleteFile(fiNum);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		for(Part part : partList) {
			uploadFile(part, num);
		}
		
		return boardDao.updateBoard(board, num);
	}
	
	@Override
	public ArrayList<FileVO> getFileListByBo_num(int bo_num) {
		return boardDao.selectFileByBo_num(bo_num);
	}

	@Override
	public int recommend(int boNum, int state, String me_id) {
		switch(state) {
		case -1, 1: break;
		default:
			throw new RuntimeException();
		}
		//회원이 게시글에 추천한 내역이 있는지 확인 => 없으면 추가 있으면 수정
		//회원이 게시글에 추천한 정보를 가져옴
		RecommendVO recommend = boardDao.selectRecommend(boNum,me_id);
		if(recommend == null) {
			//내역이 없으면 추가
			recommend = new RecommendVO(me_id, boNum, state);
			boardDao.insertRecommend(recommend);
			return state;
		}
		//있으면 수정
		if(recommend.getRe_state() == state) {
			//추천 or 비추천을 취소로 수정
			recommend.setRe_state(0);
		}
		else {
			//추천 or 비추천으로 수정
			recommend.setRe_state(state);
		}
		boardDao.updateRecommend(recommend);
		return recommend.getRe_state();
	
	}
	
	
	@Override
	public RecommendVO getRecommend(int num, MemberVO user) {
		if(user == null || num <=0) {
			return null;
		}
		return boardDao.selectRecommend(num, user.getMe_id());
	}
	
	
	
	private boolean checkString(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		return true;
	}

	private void uploadFile(Part part, int bo_num) {
		if(part == null || bo_num == 0) {
			return;
		}
		String fileOriName = FileUploadUtils.getFileName(part);
		if(!checkString(fileOriName)) {
			return;
		}
		//서버에 업로드
		String fileName = FileUploadUtils.upload(uploadPath, part);
		FileVO fileVo = new FileVO(bo_num, fileName, fileOriName);
		//DB에 추가
		boardDao.insertFile(fileVo);
	}
	
	private void deleteFile(FileVO fileVO) {
		String uploadPath = "C:\\uploads";
		// 실제 파일을 삭제 강사님 코드;  주석은 복습
		if(fileVO == null){
			return;
		}
		String fileName = uploadPath + fileVO.getFi_name().replace('/', File.separatorChar);
		FileUploadUtils.deleteFile(fileName);
		/*
		File file = new File(uploadPath + fileVO.getFi_name().replace('/', File.separatorChar));
		if(file.exists()) {
			file.delete();
		}
		*/
		// 데이터 베이스 기록 삭제
		boardDao.deleteFile(fileVO.getFi_num());
	}


	


	
}
