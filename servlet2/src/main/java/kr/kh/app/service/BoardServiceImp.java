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
}
