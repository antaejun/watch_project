package com.kitchen.persistence;

import com.kitchen.domain.UserVO;
import com.kitchen.domain.Myinfo;

public interface UserDAO {

	// 회원가입
	public void register(UserVO vo) throws Exception;
	
	// 로그인
	public UserVO login(UserVO vo) throws Exception;
	
	//public UserVO getInfo(Integer idx) throws Exception;
	
		public UserVO getInfo(Myinfo minfo) throws Exception;
		
		public void deleteUser(Integer idx) throws Exception;
		
		public void modifyUser(UserVO uvo) throws Exception;
		
		public void pwmodi(Myinfo minfo) throws Exception;
}
