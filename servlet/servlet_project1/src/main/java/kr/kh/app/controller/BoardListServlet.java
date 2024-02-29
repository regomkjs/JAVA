package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//화면에서 보낸 type과 search를 가져옴
		String type = request.getParameter("type");
		String search = request.getParameter("search");
		// Criteria객체 생성
		Criteria cri = new Criteria(1, 2, type, search);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		
	}

}
