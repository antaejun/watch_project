package com.kitchen.persistence;

import java.util.List;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;

public interface KitchenBDAO {
	
	// 사업자 주방 추가 (Insert)
	public void create(KitchenVO vo) throws Exception;
	
	public void insert(KitchenOptionVO vo) throws Exception;
	
	public List<KitchenVO> list(String user_email) throws Exception;
	
	public KitchenVO detail(String kitchen_name) throws Exception;
	
	public void deleteKitchen(String kitchen_name) throws Exception;

}
