package kr.kh.app.service;

import java.util.ArrayList;

import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	ArrayList<CommunityVO> getCommunityList();

	boolean insertBoard(BoardVO board, ArrayList<Part> fileList);

	int getTotalCount(Criteria cri);

	BoardVO getBoard(int num);

	boolean updateView(int num);

	boolean deleteBoard(MemberVO user, int num);

	boolean updateBoard(BoardVO board, int num, String[] fi_nums, ArrayList<Part> partList);

	ArrayList<FileVO> getFileListByBo_num(int bo_num);

}
