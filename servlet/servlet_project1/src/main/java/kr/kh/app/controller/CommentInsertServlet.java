package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/comment/insert")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		int bo_num = 0;
		try {
			bo_num = Integer.parseInt(request.getParameter("boNum"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		
		CommentVO comment = new CommentVO(bo_num, user.getMe_id(), content);
		
		boolean res = boardService.insertComment(comment);
		
		response.getWriter().write(""+res);
	}

}
