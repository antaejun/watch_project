package com.kitchen.persistence;

import java.util.List;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;

public interface KitchenDAO {
	// 주방 처리 동작을 선언 (추상메서드를 사용해서 선언)

	

	// 게시판 글 전체 가져오기 (Select)
	public List<KitchenVO> List() throws Exception;
	
	// 게시판 글 본문보기 (read)
	public KitchenVO read(Integer idx) throws Exception;
	
	

}
