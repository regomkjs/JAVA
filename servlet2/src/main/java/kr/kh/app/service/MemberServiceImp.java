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
		
		// 아래 예외 처리는 아이디 중복 체크 검사를 안했기 때문에 발생하는 예외를 임시처리하는 방법
		try {
			boolean res = memberDao.insertMember(tmp);
			if(res) {
				session.commit();
				return res;
			}
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO loginUser(LoginDTO tmp) {
		if(tmp == null) {
			return null;
		}
		try {
			MemberVO user = memberDao.selectLoginUser(tmp);
			// 비밀번호는 회원가입시 암호화가 되어 관리되기 때문에 DB에서 직접 비교할 수 없다.
			// 따라서 비밀번호 확인은 서버단에서 해야 함
			if(user.getMe_pw().equals(tmp.getPw())) {
				return user;
			}
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	
}
