package com.kitchen.service;

import com.kitchen.domain.UserVO;
import com.kitchen.domain.Myinfo;

public interface UserService {

	// 회원가입
	public void register(UserVO vo) throws Exception;
	
	// 로그인
	public UserVO login(UserVO vo) throws Exception;
	
	//회원 정보 가져오기
		//public UserVO getInfo(Integer idx) throws Exception;
		
		//회원 정보 가져오기
		public UserVO getInfo(Myinfo minfo) throws Exception;
		
		public void deleteUser(Integer idx) throws Exception;
		
		public void modifyUser(UserVO uvo) throws Exception;
		
		public void pwmodi(Myinfo minfo) throws Exception;
}
