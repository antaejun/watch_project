package com.kitchen.persistence;

import java.util.List;

import com.kitchen.domain.RentalVO;


public interface RentalDAO {
	// 게시판 처리 동작을 선언 (추상메서드를 사용해서 선언)

	// 게시판 글 작성(Create)
	public void create(RentalVO vo) throws Exception;
	
//	// 게시판 글 본문보기 (read)
//	public BoardVO read(Integer bno) throws Exception;
//	
//	// 게시판 글 삭제처리 (delete)
//	public void deleteBoard(int bno) throws Exception;
//	
//	// 게시판 글 수정하기(update)
//	public void modify(BoardVO vo) throws Exception;
//	
//	// 게시판 글 전체 가져오기 (Select)
//	public List<BoardVO> listAll() throws Exception;
//	
//	// 게시판 글 전체 가져오기 (페이징 처리 - 10개씩)
//	public List<BoardVO> listPage(int page) throws Exception;
//
//	// 게시판 글 가져오기 (페이징 처리 원하는 개수만큼씩 처리)
//	public List<BoardVO> listPage(Criteria cri) throws Exception;
}

