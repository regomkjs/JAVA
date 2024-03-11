package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.Criteria;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO board);

	ArrayList<CommunityVO> selectCommunityList();

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int totalCount(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("num")int num);

	boolean updateView(@Param("num")int num);

	boolean deleteBoard(@Param("board")BoardVO board);

	boolean updateBoard(@Param("board")BoardVO tmp);

	void insertFile(@Param("file")FileVO file);

	ArrayList<FileVO> selectFileByBo_num(@Param("bo_num")int num);

	void deleteFile(@Param("fi_num")int fi_num);

	FileVO selectFile(@Param("fi_num")int fi_num);

	RecommendVO selectRecommend(@Param("me_id")String me_id, @Param("bo_num")int bo_num);

	void insertRecommend(@Param("recommend")RecommendVO recommend);

	void updateRecommend(@Param("recommend")RecommendVO recommend);

	int selectRecommendCount(@Param("bo_num")int bo_num);

	boolean insertComment(@Param("comment")CommentVO comment);

	ArrayList<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	int selectTotalCountComment(@Param("cri")CommentCriteria cri);

	CommentVO selectComment(@Param("cm_num")int num);

	boolean deleteComment(@Param("cm_num")int num);

	boolean updateComment(@Param("comment")CommentVO comment);


}
