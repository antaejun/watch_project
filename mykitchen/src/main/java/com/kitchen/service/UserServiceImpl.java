package com.kitchen.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kitchen.domain.UserVO;
import com.kitchen.persistence.UserDAO;
import com.kitchen.domain.Myinfo;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO udao;

	@Override
	public void register(UserVO vo) throws Exception {

		udao.register(vo);
	}

	@Override
	public UserVO login(UserVO vo) throws Exception {

		return udao.login(vo);
	}

	

	@Override
	public UserVO getInfo(Myinfo minfo) throws Exception {
		
		System.out.println("@@@@ 컨트롤러 호출을 통해 실행됨@@@@");
		
		UserVO uvo = udao.getInfo(minfo);
		
		System.out.println("@@@@ DAO 정보를 받아 컨트롤러로");
		
		return uvo;
	}

	@Override
	public void deleteUser(Integer idx) throws Exception {
		
		System.out.println("@@@ 컨트롤러 호출을 통해 실행됨@@@@");
		
		udao.deleteUser(idx);
		
		System.out.println("@@@DAO 정보를 받아 컨트롤러로");
		
	}

	@Override
	public void modifyUser(UserVO uvo) throws Exception {
		udao.modifyUser(uvo);
		
	}

	@Override
	public void pwmodi(Myinfo minfo) throws Exception {
		System.out.println("con -> ser");
		udao.pwmodi(minfo);
		System.out.println("ser -> dao");
		
	}
	
}
