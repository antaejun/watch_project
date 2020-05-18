package com.kitchen.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;



@Repository
public class KitchenDAOImpl implements KitchenDAO {

	// 디비 접속
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace=
			"com.kitchen.mapper.KitchenMapper";
	
	/*
	 * @Override public void create(KitchenVO vo) throws Exception { // 게시판 글 등록
	 * System.out.println("@@@@@ KitchenDAOImpl 객체 호출 -> Mapper이동 SQL 실행 ");
	 * sqlSession.insert(namespace+".create",vo);
	 * System.out.println("@@@@@ Mapper에서 Mysql 이동후 처리 완료 -> 호출된 곳으로 이동"); }
	 */

	@Override
	public List<com.kitchen.domain.KitchenVO> List() throws Exception {
		// 게시판 글 전체 가져오기
		System.out.println("@@@@@ DAO 호출 -> 해당 Mapper 호출");
		
		System.out.println("@@@@@ Mapper 처리완료 -> 서비스로 이동");
		return sqlSession.selectList(namespace+".List");
	}

	
	 @Override public KitchenVO read(Integer idx) throws Exception {
	 System.out.println("@@@@@ KitchenDAO객체 생성");
	  System.out.println("@@@@@ Mapper 통해서 쿼리 실행");
	  System.out.println("@@@@@ SqlSession 객체를 통해서 호출");
	  
	  KitchenVO kitchenVO = sqlSession.selectOne(namespace+".read", idx);
	  
	  System.out.println("@@@@@ 쿼리 처리 완료 서비스 단으로 이동");
	  
	  return kitchenVO; }
	  
//	 * @Override public void deleteKitchen(int bno) throws Exception { // 글 삭제 동작 처리
//	 * System.out.println("@@@@@  서비스_removeKitchen()에서 호출");
//	 * System.out.println("@@@@@  DB처리동작(MyBatis) ");
//	 * 
//	 * sqlSession.delete(namespace+".delete",bno);
//	 * 
//	 * System.out.println("@@@@@ 게시판 글 삭제 완료");
//	 * System.out.println("@@@@@ 삭제 처리 후 서비스 계층으로 이동"); }
//	 * 
//	 * @Override public void modify(KitchenVO vo) throws Exception { // 서비스 계층에서 호출
//	 * // MyBatis(Mapper)를 통해서 디비 접근 sqlSession.update(namespace+".update", vo); //
//	 * 정보 수정완료 -> 서비스 계층호출 }
//	 * 
//	 * @Override public List<KitchenVO> listPage(int page) throws Exception {
//	 * 
//	 * if(page <= 0) { page = 1; }
//	 * 
//	 * // Mapper에서 데이터를 limit 위치,개수 // 0(1페이지),10(2페이지),20(3페이지),..... => #{page}
//	 * page = (page - 1) * 10;
//	 * 
//	 * return sqlSession.selectList(namespace+".listPage", page); }
//	 * 
//	 * @Override public List<KitchenVO> listPage(Criteria cri) throws Exception {
//	 * System.out.println("@@@ 페이징 처리 ( 원하는 개수 만큼 처리) "); return
//	 * sqlSession.selectList(namespace+".listCri",cri); }
//	 * 
//	 * @Override public int countPage(Criteria cri) throws Exception {
//	 * System.out.println("@@@@@ countPage() 호출 ");
//	 * 
//	 * return sqlSession.selectOne(namespace+".countPage",cri); }
//	 */
	
//	 @Override
//		public void create(KitchenVO vo) throws Exception {
//			// 사업자 주방 등록
//			System.out.println("@@@ KitchenDAOImpl 객체 호출 -> Mapper이동 SQL 실행");
//			sqlSession.insert(namespace + ".create", vo);
//			System.out.println("@@@ Mapper에서 Mysql 이동 후 처리 완료 -> 호출된 곳으로 이동");
//		}
//		
//		@Override
//		public void insert(KitchenOptionVO vo) throws Exception {
//			// 사업자 주방 등록
//			System.out.println("@@@ KitchenDAOImpl 객체 호출 -> Mapper이동 SQL 실행");
//			sqlSession.insert(namespace + ".insert", vo);
//			System.out.println("@@@ Mapper에서 Mysql 이동 후 처리 완료 -> 호출된 곳으로 이동");
//		}
//		
//		@Override
//		public void deleteKitchen(String kitchen_name) throws Exception {
//			// 글 삭제 동작 처리 
//			System.out.println("@@@@@  서비스_removeKitchen()에서 호출");
//			System.out.println("@@@@@  DB처리동작(MyBatis) ");
//			
//			sqlSession.delete(namespace+".delete",kitchen_name);
//			
//			System.out.println("@@@@@ 주방 삭제 완료");
//			System.out.println("@@@@@ 삭제 처리 후 서비스 계층으로 이동");
//		}

	
	
	
	

	
	
}
