package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	ArrayList<CommunityVO> getCommunityList();

	boolean insertBoard(BoardVO board);

	int getTotalCount(Criteria cri);

	BoardVO getBoard(int num);

	boolean updateView(int num);

	boolean deleteBoard(MemberVO user, int num);

	boolean updateBoard(BoardVO board, int num);

}
