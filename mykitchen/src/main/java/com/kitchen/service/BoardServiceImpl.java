package com.kitchen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kitchen.persistence.BoardDAO;
import com.kitchen.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

 @Inject
 private BoardDAO dao;
 
 @Override
 public List list() throws Exception {

  return dao.list();
 }

@Override
public void write(BoardVO vo) throws Exception {
	dao.write(vo);
}

@Override
public BoardVO view(int num) throws Exception {

	return dao.view(num);
}

@Override
public void modify(BoardVO vo) throws Exception {

	dao.modify(vo);
	
}
//게시물 삭제 
@Override
public void delete(BoardVO vo) throws Exception {
	
	dao.delete(vo);
	
}

@Override
public int count() throws Exception {

	return dao.count();
}// 게시물 목록 + 페이징
@Override
public List listPage(int displayPost, int postNum) throws Exception {
 return dao.listPage(displayPost, postNum);
}

}