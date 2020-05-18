package com.kitchen.service;

import java.util.List;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;

public interface KitchenBService {
	
	// 주방 등록
	public void regist(KitchenVO vo) throws Exception;
	
	// 주방 옵션 등록
	public void optionRegist(KitchenOptionVO vo) throws Exception;
	
	// 지점별 주방 목록 가져오기
	public List<KitchenVO> list(String user_email) throws Exception;
	
	// 주방 디테일 가져오기
	public KitchenVO detail(String kitchen_name) throws Exception;
	
	// 주방 삭제
	public void removeKitchen(String kitchen_name) throws Exception;

}
