package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {
	
	private MemberDAO memberDAO;
	private SqlSession session;
	private InputStream inputStream;
	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDAO = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean signup(MemberVO memberVO) {
		if(memberVO == null ||
				memberVO.getMe_id()==null || 
				memberVO.getMe_pw() ==null || 
				memberVO.getMe_email() ==null) {
			return false;
		}
		try {
			boolean res = memberDAO.insertMember(memberVO);
			if(res) {
				session.commit();
			}
			return res;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false; 
		}
		
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		if(loginDTO == null) {
			return null;
		}
		MemberVO user = memberDAO.selectMember(loginDTO.getId());
		if(user == null) {
			return null;
		}
		if(user.getMe_pw().equals(loginDTO.getPw())) {
			return user;
		}
		return null;
	}


	
	
	
	
}
