package kr.kh.app.service;

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
	public boolean insertBoard(BoardVO board,  Part filePart) {
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
		uploadFile(filePart,board.getBo_num());
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
			return boardDAO.deleteBoard(board);
		}
		return false;
	}
	@Override
	public boolean updateBoard(BoardVO tmp, MemberVO user) {
		if(user == null ) {
			return false;
		}
		BoardVO board = boardDAO.selectBoard(tmp.getBo_num());
		if(board.getBo_me_id().equals(user.getMe_id())) {
			return boardDAO.updateBoard(tmp);
		}
		return false;
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
	@Override
	public FileVO getFile(int num) {
		return boardDAO.selectFileByBo_num(num);
	}
}
