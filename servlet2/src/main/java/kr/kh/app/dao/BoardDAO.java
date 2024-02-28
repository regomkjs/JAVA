package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.pagination.Criteria;

public interface BoardDAO {

	ArrayList<CommunityVO> selectCommunityList();

	void insertBoard(@Param("board")BoardVO board);

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectTotalCount(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("num")int num);

	boolean updateView(@Param("num")int num);

}
