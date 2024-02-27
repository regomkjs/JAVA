package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

	ArrayList<CommunityVO> selectCommunityList();

	void insertBoard(@Param("board")BoardVO board);

}
