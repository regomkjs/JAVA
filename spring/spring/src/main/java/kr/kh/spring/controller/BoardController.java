package kr.kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.RecommendVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	//@RequestMapping(value="/board/list", method=RequestMethod.GET)
	@GetMapping("/board/list")
	public String boardList(Model model, Criteria cri) {
		cri.setPerPageNum(5);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getBoardTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/board/list";
	}
	@GetMapping("/board/insert")
	public String boardInsert(Model model) {
		//Ŀ�´�Ƽ ����Ʈ�� �����ͼ� ȭ�鿡 ����
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		model.addAttribute("list", list);
		return "/board/insert";
	}
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board, 
			HttpServletRequest request, MultipartFile[] file) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(boardService.insertBoard(board,user, file)) {
			model.addAttribute("msg", "�Խñ��� ����߽��ϴ�.");
			model.addAttribute("url", "/board/list");
		}else {
			model.addAttribute("msg", "�Խñ��� ������� ���߽��ϴ�.");
			model.addAttribute("url", "/board/insert");
		}
		return "message";
	}
	
	@GetMapping("/board/detail")
	public String boardDetail(Model model, int boNum, Criteria cri) {
		//��ȸ�� ����
		boardService.updateView(boNum);
		//�Խñ��� ������
		BoardVO board = boardService.getBoard(boNum);
		//÷�������� ������
		ArrayList<FileVO> fileList = boardService.getFileList(boNum);
		//ȭ�鿡 �Խñ�, ÷������, �˻� ������ ����
		model.addAttribute("board", board);
		model.addAttribute("fileList", fileList);
		model.addAttribute("cri", cri);
		
		return "/board/detail";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Model model, int boNum, HttpSession session) {
		//ȸ�� ������ ������
		MemberVO user = (MemberVO) session.getAttribute("user");
		
		//���񽺿��� �Խñ� ��ȣ�� ȸ�� ������ �ָ鼭 �����϶�� ��û
		boolean res = boardService.deleteBoard(boNum, user);
		//���� ������ ���� ó��
		if(res) {
			model.addAttribute("url", "/board/list");
			model.addAttribute("msg", "�Խñ��� �����߽��ϴ�.");
		}
		//���� ���н� ���� ó��
		else {
			model.addAttribute("url", "/board/detail?boNum=" + boNum);
			model.addAttribute("msg", "�Խñ��� �������� ���߽��ϴ�.");
		}
		
		return "message";
	}
	
	@GetMapping("/board/update")
	public String boardUpdate(Model model, int boNum) {
		//Ŀ�´�Ƽ ����Ʈ�� �����ͼ� ȭ�鿡 ����
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		//�Խñ��� ������
		BoardVO board = boardService.getBoard(boNum);
		//÷�������� ������
		ArrayList<FileVO> fileList = boardService.getFileList(boNum);
		
		model.addAttribute("fileList", fileList);
		model.addAttribute("board", board);
		model.addAttribute("list", list);
		return "/board/update";
	}
	@PostMapping("/board/update")
	public String boardUpdatePost(Model model, BoardVO board, MultipartFile []file,
			int [] delNums, HttpSession session) {
		//ȸ�� ������ ������. ��? �ۼ��ڸ� �����ؾ��ϱ� ������
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = boardService.updateBoard(board, user, file, delNums);
		if(res) {
			model.addAttribute("url", "/board/detail?boNum="+board.getBo_num());
			model.addAttribute("msg", "�Խñ��� �����߽��ϴ�.");
		}else {
			model.addAttribute("url", "/board/detail?boNum="+board.getBo_num());
			model.addAttribute("msg", "�Խñ��� �������� ���߽��ϴ�.");
		}
		
		return "message";
	}
	
	
	@ResponseBody
	@PostMapping("/recommend/check")
	public Map<String, Object> RecommendCheck(@RequestBody RecommendVO recommend, HttpSession session){
		Map<String, Object> map = new HashMap <String, Object>();
		System.out.println(recommend);
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = boardService.recommend(recommend, user);
		map.put("result", res);
		
		return map;
	}
}