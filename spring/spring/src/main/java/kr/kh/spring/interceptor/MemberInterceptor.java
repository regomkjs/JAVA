package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

public class MemberInterceptor extends HandlerInterceptorAdapter {
	/* preHandle���� return���� true�̸� ������ ��Ʈ�ѷ��� ���� �۾��� ����
	 * return���� false�̸� ������ ��Ʈ�ѷ��� ���� ������. �����̷�Ʈ�� ��ΰ� ������ �ش� ��η� �̵�
	 * */
	
	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler)
	    throws Exception {
		MemberVO user= (MemberVO) request.getSession().getAttribute("user");
		//�α��� ��������
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;
	}
	
	
	
}
