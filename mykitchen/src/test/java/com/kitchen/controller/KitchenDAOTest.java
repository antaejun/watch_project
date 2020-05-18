package com.kitchen.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.kitchen.domain.KitchenVO;
import com.kitchen.persistence.KitchenDAO;
import com.kitchen.service.KitchenService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class KitchenDAOTest {

	@Inject
	private KitchenDAO kdao;
	
	@Inject
	private KitchenService service;
	
	// * 테스트 동작 하기위해서 메서드로 구현
	@Test
	public void testInsert() throws Exception{
		
		// 객체 정보 생성
		KitchenVO vo = new KitchenVO();
		vo.setKitchen_name("주방이름완료");
		vo.setUser_email(" 유저이메일");
		
		
		System.out.println("@@@@@ 글 정보 입력완료 -> DAO 객체로 정보 전달");
		
		// 객체의 메서드 호출(글쓰기)
		//kdao.create(vo);
	    System.out.println("@@@@@ 글 작성 완료 !!");
	}
	
	/*
	 * @Test public void testRegist() throws Exception{ // 객체 정보 생성 KitchenVO vo =
	 * new KitchenVO(); vo.setTitle("새글 작성하기(서비스)");
	 * vo.setContent(" 글 작성하기 완료!!! "); vo.setWriter("사용자 6");
	 * 
	 * System.out.println("@@@@@@ 실행시 서비스 계층 호출(글쓰기)"); service.regist(vo);
	 * 
	 * System.out.println("@@@@@ 글저장 완료 서비스 계층 처리 끝");
	 * 
	 * }
	 */
	
	/*
	 * // 페이징 처리를 하는 동작 테스트
	 * 
	 * @Test public void testListPage() throws Exception {
	 * System.out.println("@@ 페이징 처리 테스트");
	 * 
	 * //페이지 번호 int page = 1;
	 * 
	 * // List<KitchenVO> kitchenList = kdao.listPage(page); // // for(KitchenVO vo
	 * :kitchenList) { // System.out.println(vo.getidx()+" -> "+vo.getTitle()); // }
	 * }
	 */
	
	/*
	 * // 2페이지의 정보를 20개씩 출력
	 * 
	 * @Test public void testListCri() throws Exception {
	 * System.out.println("@@@ 2페이지정보를 20개씩 출력");
	 * 
	 * Criteria cri = new Criteria(); cri.setPage(2); cri.setPageSize(40);
	 * 
	 * // dao 호출 List<KitchenVO> kitchenList = kdao.listPage(cri);
	 * 
	 * for(KitchenVO vo :kitchenList) {
	 * System.out.println(vo.getIdx()+"->"+vo.getTitle()); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	
	
	
	
}
