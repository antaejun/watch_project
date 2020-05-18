package com.kitchen.service;

import java.util.List;

import com.kitchen.domain.BoardVO;

public interface BoardService {
	//게시물 목록
	public List list() throws Exception; 
	
	//게시물 작성
	public void write(BoardVO vo) throws Exception;
	
	// 게시물 조회
	public BoardVO view(int num) throws Exception;
	
	//게시물 수정
		public void modify(BoardVO vo) throws Exception;
	
	//게시물 삭제
	public void delete(BoardVO vo) throws Exception;
	
	//게시물 총 갯수                            
	public int count() throws Exception;
	
	// 게시물 목록 + 페이징
	public List listPage(int displayPost, int postNum) throws Exception;
	
	
	
	
}

