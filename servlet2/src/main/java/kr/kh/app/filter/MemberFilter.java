package kr.kh.app.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import kr.kh.app.model.vo.MemberVO;

@WebFilter({"/board/write","/board/update","/board/delete"})
public class MemberFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		MemberVO user = (MemberVO) httpServletRequest.getSession().getAttribute("user");
		if(user == null) {
			request.setAttribute("msg", "로그인 해야합니다.");
			request.setAttribute("url", "login");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(httpServletRequest, response);
			return;
		}
		chain.doFilter(request, response);
	}

}
