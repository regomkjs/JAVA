package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 전송한 게시글 번호를 가져옴
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}
		catch (Exception e) {
			num = 0;
		}
		//서비스에게 게시글 번호를 주면서 게시글과 첨부파일을 가져오라고 시킴 
		BoardVO board = boardService.getBoard(num);
		ArrayList<FileVO> fileList = boardService.getFileListByBo_num(num);
		//가져온 게시글과 첨부파일을 화면에 전송
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		//작성자가 맞는지 확인
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			// 다르면 작성자가 아니라는 메세지와 상세로
			request.setAttribute("msg", "작성자가 아닙니다.");
			request.setAttribute("url", "board/detail?num="+num);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		//게시판을 가져와서 화면에 전달
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		request.setAttribute("communityList", list);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인한 회원 정보를 가져옴 
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//화면에 전송한 게시판, 제목, 내용, 번호를 가져옴
		int num;
		int community;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			community = Integer.parseInt(request.getParameter("community"));
		}
		catch (Exception e) {
			num = 0;
			community = 0;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//게시글 객체로 생성
		BoardVO board = new BoardVO(title,content,community,user.getMe_id());
		//서비스에게 게시글과 회원정보를 주면서 수정 요청
		boolean res = boardService.updateBoard(board, num);
		
		//성공 실패를 알리고 게시글 상세로 이동
		if(res) {
			request.setAttribute("msg", "게시글을 수정했습니다.");
		}
		else {
			request.setAttribute("msg", "게시글 수정에 실패했습니다.");
		}
		request.setAttribute("url", "board/detail?num="+num);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
