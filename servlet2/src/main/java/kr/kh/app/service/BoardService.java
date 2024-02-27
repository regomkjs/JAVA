package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	ArrayList<CommunityVO> getCommunityList();

	boolean insertBoard(BoardVO board);

}
