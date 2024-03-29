package kr.kh.app.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;
import kr.kh.app.utils.FileUploadUtils;

@WebServlet("/board/insert")
@MultipartConfig(
	maxFileSize = 1024 * 1024 * 10, // 10Mb
	maxRequestSize =  1024 * 1024 * 10 * 3, // 10Mb 최대 3개
	fileSizeThreshold = 1024 * 1024 // 1Mb : 파일 업로드 시 메모리에 저장되는 임시 파일의 크기
)
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService boardService = new BoardServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시판 전체를 가져옴 
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		if(list == null || list.size() == 0) {
			response.sendRedirect(request.getContextPath()+"/");
			return;
		}
		request.setAttribute("list",list);
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 작성중 세션이 만료됐을 때를 대비
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = user.getMe_id();
		int co_num = Integer.parseInt(request.getParameter("community"));
		BoardVO board = new BoardVO(co_num, title, content, writer);
		//첨부파일을 가져옴
		ArrayList<Part> partList = (ArrayList<Part>) request.getParts();
		
		
		//서비스에게 게시글을 주면서 등록하라고 시킴
		if(boardService.insertBoard(board, partList)) {
			response.sendRedirect(request.getContextPath()+"/board/list");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/board/insert");
		}
	}
	
	
}
