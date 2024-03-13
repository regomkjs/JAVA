package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	//����ó�������� ��Ʈ�ѷ��� ���� �� �۾��� ���� : ��Ʈ�ѷ� ���� �� ����
	//�������, �Խ�Ʈ ���͸� ������ �� �ִ�
	/*
	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler)
	    throws Exception {
		return true;
	}
	*/
	
	//��Ʈ�ѷ����� ����ó�������� ������ �۾��� ���� : ��Ʈ�ѷ� ���� �� ����
	//�α���
	@Override
	public void postHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler, 
		ModelAndView modelAndView)
		throws Exception {
		//ModelAndView ��ü���� model ��ü�� �־��� user�� �������� �ڵ�
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		if(user != null) {
			request.getSession().setAttribute("user", user);
		}
	}
	
}
