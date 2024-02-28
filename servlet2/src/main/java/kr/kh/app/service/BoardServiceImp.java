package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;

public class BoardServiceImp implements BoardService {
	private BoardDAO boardDao;
	private InputStream inputStream;
	private SqlSession session;
	
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
	}

	
	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		ArrayList<CommunityVO> list = boardDao.selectCommunityList();
		return list;
	}

	@Override
	public boolean insertBoard(BoardVO board) {
		if(board == null || 
				!checkString(board.getBo_content()) || 
				!checkString(board.getBo_title()) ) {
			return false;
		}
		boardDao.insertBoard(board);
		return true;
	}
	
	public boolean checkString(String str) {
		if(str == null || str.length() == 0) {
			return false;
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
			return boardDao.deleteBoard(num);
		}
		return false;
	}


	@Override
	public boolean updateBoard(BoardVO board, int num) {
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
		return boardDao.updateBoard(board, num);
	}
}
