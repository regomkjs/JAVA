package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

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
	
	@Autowired
	MemberService memberService;
	
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
			//자동로그인을 체크했으면
			if(user.isAutoLogin()) {
				//쿠키를 생성
				String value = request.getSession().getId();
				Cookie cookie = new Cookie("loginCookie", value);
				cookie.setPath("/");
				//1주일
				int time = 7 * 24 * 60 * 60;
				cookie.setMaxAge(time);
				//화면에 전송
				response.addCookie(cookie);
				//DB에 관련 정보를 추가
				//세션 아이디와 만료시간
				user.setMe_cookie(value);
				Date date = new Date(System.currentTimeMillis()+ time*1000);
				user.setMe_cookie_limit(date);
				memberService.updateMemberCookie(user);
			}
			//되돌아갈 url이 있으면 해당 url로 돌아감
			String url = (String)request.getSession().getAttribute("prevUrl");
			if(url != null) {
				response.sendRedirect(url);
				request.getSession().removeAttribute("prevUrl");
			}
		}
	}
	
}
