package com.kitchen.service;

import java.util.List;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;

public interface KitchenService {
	
	//주방 목록 가져오기
	public List<KitchenVO> List() throws Exception;
	
	// 특정 글 가져오기( 글 본문보기 )
		public KitchenVO read(int idx) throws Exception;

//		// 주방 등록
//		public void regist(KitchenVO vo) throws Exception;
//		
//		// 주방 옵션 등록
//		public void optionRegist(KitchenOptionVO vo) throws Exception;
//		
//		// 주방 삭제
//		public void removeKitchen(String kitchen_name) throws Exception;




}
