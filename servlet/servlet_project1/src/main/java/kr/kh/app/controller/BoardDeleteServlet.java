package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
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
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		BoardVO board = boardService.getBoard(num);
		if(boardService.deleteBoard(board,user)) {
			request.setAttribute("msg", "게시글 삭제에 성공했습니다");
			request.setAttribute("url", "board/list");
		}
		else {
			request.setAttribute("msg", "게시글 삭제에 실패했습니다");
			request.setAttribute("url", "board/detail?num="+num);
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
