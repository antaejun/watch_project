package com.kitchen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;
import com.kitchen.persistence.KitchenDAO;

@Service
public class KitchenServiceImpl implements KitchenService {

	// DAO 객체 (의존 주입)
	@Inject
	private KitchenDAO kdao;
	
	/*
	 * @Override public void regist(KitchenVO vo) throws Exception { // 컨트롤러에 요청 받아서
	 * DAO로 전달 System.out.println("@@@@@ Service 계층  글작성 동작 실행->DAO 메서드 호출");
	 * kdao.create(vo); System.out.println("@@@@@ DAO 에서 글쓰기 처리 완료!"); }
	 */

	@Override
	public List<KitchenVO> List() throws Exception {
        System.out.println("@@@@@@  Service 계층 실행 (글 전체 목록 가져오기) ");
        List<KitchenVO> kitchenList = kdao.List();
		System.out.println("@@@@@ DAO 처리 완료. 결과를 컨트롤러 전달");
        
		return kitchenList;
	}

	
	 @Override public KitchenVO read(int idx) throws Exception {
	 System.out.println("@@@@@ 컨트롤러 호출을 통해서 실행됨");
	  System.out.println("@@@@@ DAO 객체를 통해서 쿼리를 실행해야함.");
	  
	 com.kitchen.domain.KitchenVO kitchenVO = kdao.read(idx);
	  
	  System.out.println("@@@@@ DAO 정보를 받아서 컨트롤러로 이동");
	  
	  return kitchenVO; }
	  
//	  @Override public void removeKitchen(int bno) throws Exception {
//	  
//	  System.out.println("@@@@@ 컨트롤러에서 호출(/delete-post방식)");
//	  System.out.println("@@@@@ DAO를 호출해서 전달받은 글번호 전달"); // DAO 호출(삭제 작업)
//	  kdao.deleteKitchen(bno); System.out.println("@@@@@ DAO 처리 완료(삭제)");
//	  System.out.println("@@@@@ 컨트롤러 페이지로 이동");
//	  
//	  }
//	  
//	  @Override public void updateKitchen(KitchenVO vo) throws Exception {
//	  
//	  // 컨트롤러에서 호출됨 (/modify (post) 방식) // DAO 정보를 전달 kdao.modify(vo); // 결과 처리후
//	  컨트롤러로 이동 }
//	  
//	  @Override public List<KitchenVO> listCriteria(Criteria cri) throws Exception
//	  {
//	  
//	  System.out.println("@@@@ 서비스 : 리스트 출력 메서드 호출(페이징처리) ");
//	  
//	 return kdao.listPage(cri); }
//	  
//	  @Override public int listPageCount(Criteria cri) throws Exception {
//	  
//	  System.out.println("@@@@@서비스@@@  listPageCount() 호출");
//	  
//	  return kdao.countPage(cri); }
	 
	
//	 @Override
//		public void regist(KitchenVO vo) throws Exception {
//			System.out.println("@@@ Service 계층 글작성 동작 실행 -> DAO 메서드 호출");
//			kdao.create(vo);
//			System.out.println("@@@ DAO 에서 주방추가 처리 완료!");
//		}
//		
//		@Override
//		public void optionRegist(KitchenOptionVO vo) throws Exception {
//			System.out.println("@@@ Service 계층 글작성 동작 실행 -> DAO 메서드 호출");
//			kdao.insert(vo);
//			System.out.println("@@@ DAO 에서 주방옵션추가 처리 완료!");
//		}
//	
//	
//		@Override
//		public void removeKitchen(String kitchen_name) throws Exception {
//			
//			System.out.println("@@@@@ 컨트롤러에서 호출(/delete-post방식)");
//			System.out.println("@@@@@ DAO를 호출해서 전달받은 글번호 전달");
//			// DAO 호출(삭제 작업)
//			kdao.deleteKitchen(kitchen_name);
//			System.out.println("@@@@@ DAO 처리 완료(삭제)");
//			System.out.println("@@@@@ 컨트롤러 페이지로 이동");
//		}
	
	
	

}
