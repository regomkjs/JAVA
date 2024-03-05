package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
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
		if(boardService.updateView(num)) {
			BoardVO board = boardService.getBoard(num);
			request.setAttribute("board", board);
			//서비스에게 게시글 번호를 주면서 첨부파일을 가져오라고 시킴
			ArrayList<FileVO> fileList = boardService.getFile(num);
			//첨부파일을 화면에 전송
			request.setAttribute("fileList", fileList);
			
			
			request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
