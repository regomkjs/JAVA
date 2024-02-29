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
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		멤버필터 추가로 불필요
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user == null) {
			request.setAttribute("msg", "게시글을 작성하기 위해선 로그인 해야합니다.");
			request.setAttribute("url", "login");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		*/
		ArrayList<CommunityVO> communityList = boardService.getCommunityList();
		request.getSession().setAttribute("communityList", communityList);
		request.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int co_num = Integer.parseInt(request.getParameter("community"));
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		/*
		멤버필터 추가로 불필요
		if(user == null) {
			request.setAttribute("msg", "게시글 등록에 실패했습니다.");
			request.setAttribute("url", "board/list");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		*/
		String id = user.getMe_id();
		BoardVO board = new BoardVO(title,content,co_num,id);
		boolean res = boardService.insertBoard(board);
		if(res) {
			request.setAttribute("msg", "게시글이 등록됐습니다.");
		}
		else {
			request.setAttribute("msg", "게시글 등록에 실패했습니다.");
		}
		request.setAttribute("url", "board/list");
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
