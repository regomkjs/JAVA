package kr.kh.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.grade.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/regist")
	public String regist() {
		return "/student/regist";
	}
	
	@RequestMapping("/list")
	public String list() {
		return "/student/list";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "/student/update";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "/student/delete";
	}
	
	
}
