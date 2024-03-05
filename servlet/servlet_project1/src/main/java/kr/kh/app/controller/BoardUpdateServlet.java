package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/update")
@MultipartConfig(
	maxFileSize = 1024 * 1024 * 10, // 10Mb
	maxRequestSize =  1024 * 1024 * 10 * 3, // 10Mb 최대 3개
	fileSizeThreshold = 1024 * 1024 // 1Mb : 파일 업로드 시 메모리에 저장되는 임시 파일의 크기
)
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}
		catch (Exception e) {
			num = 0;
		}
		//게시글의 첨부파일을 가져와서 화면에 전송
		ArrayList<FileVO> fileList = boardService.getFile(num);
		request.setAttribute("fileList", fileList);
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		BoardVO board = boardService.getBoard(num);
		request.setAttribute("community", list);
		request.setAttribute("board", board);
		if(board.getBo_me_id().equals(user.getMe_id()) || user.getMe_authority().equals("admin")) {
			request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", "수정할 권한이 없습니다.");
			request.setAttribute("url", "board/detail?num="+num);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 번호, 내용, 제목을 가져옴
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}
		catch (Exception e) {
			num = 0;
		}
		int communityNum;
		try {
			communityNum = Integer.parseInt(request.getParameter("community"));
		}
		catch (Exception e) {
			communityNum = 0;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 게시글 번호, 내용 제목을 이용해 게시글 객체를 생성
		BoardVO tmp = new BoardVO(num, communityNum, title, content);
		// 회원
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		//새로 추가된 첨부파일 정보 가져옴
		ArrayList<Part> fileList = (ArrayList<Part>)request.getParts();
		//삭제할 첨부파일 정보 가져옴
		String numsStr [] = request.getParameterValues("fi_num");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		if(numsStr != null) {
			for(String numStr : numsStr) {
				try {
					int fi_num = Integer.parseInt(numStr);
					nums.add(fi_num);
				}
				catch (Exception e) {
					
				}
			}
		}
		
		// 서비스에게 회원정보와 게시글을 주면서 수정 요청
		boolean res = boardService.updateBoard(tmp, user, nums, fileList);
		// 수정 되었으면 수정했습니다
		if(res) {
			request.setAttribute("msg", "게시글이 수정 되었습니다.");
		}
		// 실패했으면 실패 알림
		else {
			request.setAttribute("msg", "게시글 수정에 실패했습니다.");
		}
		// 게시글 상세로 이동
		request.setAttribute("url", "board/detail?num=" + num);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
