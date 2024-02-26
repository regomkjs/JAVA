package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {
	MemberDAO memberDao;
	InputStream inputStream;
	SqlSession session;
	
	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(MemberVO tmp) {
		
		if(tmp == null) {
			return false;
		}
		// 필수 항목 체크
		if(tmp.getMe_id() == null || tmp.getMe_pw() == null || tmp.getMe_email() == null) {
			return false;
		}
		// 아이디 중복 체크
		// 각 항목 유효성 검사
		
		boolean res = memberDao.insertMember(tmp);
		if(res) {
			session.commit();
			return res;
		}
		return false;
	}
	
	
	
	
}
