package com.kitchen.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kitchen.domain.UserVO;
import com.kitchen.domain.Myinfo;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	SqlSession sqlSession;

	private static final String namespace = "com.kitchen.mapper.userMapper";

	@Override
	public void register(UserVO vo) throws Exception {
		sqlSession.insert(namespace + ".register", vo);

	}

	@Override
	public UserVO login(UserVO vo) throws Exception {

		return sqlSession.selectOne(namespace + ".login", vo);
	}
	
	@Override
	public UserVO getInfo(Myinfo minfo) throws Exception {
		
		System.out.println("회원 번호, 비밀번호 가지고 가서 회원 정보 가지고 오기@@@");
		
		UserVO uvo 
			= sqlSession.selectOne(namespace+".userInfo", minfo);
		
		return uvo;
	}

	@Override
	public void deleteUser(Integer idx) throws Exception {
		
		System.out.println("@@@@ 서비스에서 호출 -> DB처리");
		
		sqlSession.delete(namespace+".delete",idx);
		
		System.out.println("@@@@ 회원 Y 변경 완료 후 서비스로");
		
	}

	@Override
	public void modifyUser(UserVO uvo) throws Exception {
		sqlSession.update(namespace+".modify", uvo);
		
	}

	@Override
	public void pwmodi(Myinfo minfo) throws Exception {
		System.out.println("dao->mapper");
		
		sqlSession.update(namespace+".pwmodi", minfo);
		
		System.out.println("dao -> ser");
		
	}
	
	
	
	/*
	 * @Override public UserVO getInfo(Integer idx) throws Exception{
	 * 
	 * //회원 정보 가져오기 System.out.println("@@@@ UserDAO 객체 생성@@@@");
	 * System.out.println("@@@@ Mapper 통해 쿼리 실행@@@@");
	 * System.out.println("@@@@ SqlSession 객체를 통해 호출@@@@");
	 * 
	 * //안넘어가짐 UserVO userVO = sqlSession.selectOne(namespace+".userInfo", idx );
	 * 
	 * System.out.println("@@@@ 쿼리 처리 완료 서비스로 @@@@");
	 * 
	 * return userVO; }
	 */
	
}
