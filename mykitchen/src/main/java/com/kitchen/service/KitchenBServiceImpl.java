package com.kitchen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;
import com.kitchen.persistence.KitchenBDAO;

@Service
public class KitchenBServiceImpl implements KitchenBService {
	
	@Inject
	private KitchenBDAO kdao;
	
	@Override
	public void regist(KitchenVO vo) throws Exception {
		System.out.println("@@@ Service 계층 글작성 동작 실행 -> DAO 메서드 호출");
		kdao.create(vo);
		System.out.println("@@@ DAO 에서 주방추가 처리 완료!");
	}
	
	@Override
	public void optionRegist(KitchenOptionVO vo) throws Exception {
		System.out.println("@@@ Service 계층 글작성 동작 실행 -> DAO 메서드 호출");
		kdao.insert(vo);
		System.out.println("@@@ DAO 에서 주방옵션추가 처리 완료!");
	}
	
	@Override
	public List<KitchenVO> list(String user_email) throws Exception {
		System.out.println("@@@ Service 계층 실행 (지점별 주방 목록 가져오기)");
		System.out.println("@@@ DAO 객체를 통해서 쿼리를 실행해야함.");
		
		List<KitchenVO> kitchenList = kdao.list(user_email);
		
		return kitchenList;
	}
	
	@Override
	public KitchenVO detail(String kitchen_name) throws Exception {
		System.out.println("@@@@@ 컨트롤러 호출을 통해서 실행됨");
		System.out.println("@@@@@ DAO 객체를 통해서 쿼리를 실행해야함.");
		
		KitchenVO kitchenVO = kdao.detail(kitchen_name);
		
		System.out.println("@@@@@ DAO 정보를 받아서 컨트롤러로 이동");
		
		return kitchenVO;
	}
	
	@Override
	public void removeKitchen(String kitchen_name) throws Exception {
		
		System.out.println("@@@@@ 컨트롤러에서 호출(/delete-post방식)");
		System.out.println("@@@@@ DAO를 호출해서 전달받은 글번호 전달");
		// DAO 호출(삭제 작업)
		kdao.deleteKitchen(kitchen_name);
		System.out.println("@@@@@ DAO 처리 완료(삭제)");
		System.out.println("@@@@@ 컨트롤러 페이지로 이동");
	}

}
