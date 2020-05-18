package com.kitchen.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;

@Repository
public class KitchenBDAOImpl implements KitchenBDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace=
			"com.kitchen.mapper.kitchenBMapper";
	
	@Override
	public void create(KitchenVO vo) throws Exception {
		// 사업자 주방 등록
		System.out.println("@@@ KitchenDAOImpl 객체 호출 -> Mapper이동 SQL 실행");
		sqlSession.insert(namespace + ".create", vo);
		System.out.println("@@@ Mapper에서 Mysql 이동 후 처리 완료 -> 호출된 곳으로 이동");
	}
	
	@Override
	public void insert(KitchenOptionVO vo) throws Exception {
		// 사업자 주방 등록
		System.out.println("@@@ KitchenDAOImpl 객체 호출 -> Mapper이동 SQL 실행");
		sqlSession.insert(namespace + ".insert", vo);
		System.out.println("@@@ Mapper에서 Mysql 이동 후 처리 완료 -> 호출된 곳으로 이동");
	}
	
	@Override
	public List<KitchenVO> list(String user_email) throws Exception {
		System.out.println("@@@ DAO 호출 -> 해당 Mapper 호출");
		System.out.println("@@@ Mapper 통해서 쿼리 실행");
		System.out.println("@@@@@ SqlSession 객체를 통해서 호출");
		
		return sqlSession.selectList(namespace + ".list", user_email);
	}
	
	public List<KitchenOptionVO> list() throws Exception {
		System.out.println("@@@ DAO 호출 -> 해당 Mapper 호출");
		System.out.println("@@@ Mapper 통해서 쿼리 실행");
		System.out.println("@@@@@ SqlSession 객체를 통해서 호출");
		
		return sqlSession.selectList(namespace + ".list");
	}
	
	@Override
	public KitchenVO detail(String kitchen_name) throws Exception {
		
		System.out.println("@@@@@ KitchenDAO객체 생성");
		System.out.println("@@@@@ Mapper 통해서 쿼리 실행");
		System.out.println("@@@@@ SqlSession 객체를 통해서 호출");
		
		KitchenVO kitchenVO
		= sqlSession.selectOne(namespace+".detail", kitchen_name);
		
		return kitchenVO;
	}
	
	@Override
	public void deleteKitchen(String kitchen_name) throws Exception {
		// 글 삭제 동작 처리 
		System.out.println("@@@@@  서비스_removeKitchen()에서 호출");
		System.out.println("@@@@@  DB처리동작(MyBatis) ");
		
		sqlSession.delete(namespace+".delete",kitchen_name);
		
		System.out.println("@@@@@ 주방 삭제 완료");
		System.out.println("@@@@@ 삭제 처리 후 서비스 계층으로 이동");
	}

}
