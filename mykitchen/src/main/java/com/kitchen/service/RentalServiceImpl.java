package com.kitchen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kitchen.domain.RentalVO;
import com.kitchen.persistence.RentalDAO;

@Service
public class RentalServiceImpl implements RentalService {

	// DAO 객체 (의존 주입)
	@Inject
	private RentalDAO rdao;
	
	@Override
	public void regist(RentalVO vo) throws Exception {
		// 컨트롤러에 요청 받아서 DAO로 전달
		System.out.println("@@@@@ Service 계층  글작성 동작 실행->DAO 메서드 호출");
		rdao.create(vo);
		System.out.println("@@@@@ DAO 에서 글쓰기 처리 완료!");
	}

//	@Override
//	public List<BoardVO> listAll() throws Exception {
//        System.out.println("@@@@@@  Service 계층 실행 (글 전체 목록 가져오기) ");
//        List<BoardVO> boardList = bdao.listAll();
//		System.out.println("@@@@@ DAO 처리 완료. 결과를 컨트롤러 전달");
//        
//		return boardList;
//	}
//
//	@Override
//	public BoardVO read(int bno) throws Exception {
//		System.out.println("@@@@@ 컨트롤러 호출을 통해서 실행됨");
//		System.out.println("@@@@@ DAO 객체를 통해서 쿼리를 실행해야함.");
//		
//		BoardVO boardVO = bdao.read(bno);
//		
//		System.out.println("@@@@@ DAO 정보를 받아서 컨트롤러로 이동");
//		
//		return boardVO;
//	}
//
//	@Override
//	public void removeBoard(int bno) throws Exception {
//
//		System.out.println("@@@@@ 컨트롤러에서 호출(/delete-post방식)");
//		System.out.println("@@@@@ DAO를 호출해서 전달받은 글번호 전달");
//		// DAO 호출(삭제 작업)
//		bdao.deleteBoard(bno);
//		System.out.println("@@@@@ DAO 처리 완료(삭제)");
//		System.out.println("@@@@@ 컨트롤러 페이지로 이동");		
//		
//	}
//
//	@Override
//	public void updateBoard(BoardVO vo) throws Exception {
//
//		// 컨트롤러에서 호출됨 (/modify (post) 방식)
//		// DAO 정보를 전달
//		bdao.modify(vo);
//		// 결과 처리후 컨트롤러로 이동
//	}
	
	
	
	
	
	
	
	
	

}
