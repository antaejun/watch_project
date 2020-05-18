package com.kitchen.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kitchen.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

 @Inject
 private SqlSession sql;
 
 private static String namespace = "com.kitchen.mapper.boardMapper";

 // 게시물 목록
 @Override
 public List list() throws Exception { 
  
  return sql.selectList(namespace + ".list");
 }
// 게시물 작성
@Override
public void write(BoardVO vo) throws Exception {
	sql.insert(namespace + ".write", vo);
}
//게시물 조회
@Override
public BoardVO view(int num) throws Exception {

	return sql.selectOne(namespace + ".view", num);
	
}
//게시물 수정
@Override
public void modify(BoardVO vo) throws Exception {
	sql.update(namespace + ".modify", vo);
	
}
//게시물 삭제
@Override
public void delete(BoardVO vo) throws Exception {
	sql.update(namespace + ".delete", vo);
	
}
//개시물 총 갯수
@Override
public int count() throws Exception {
	return sql.selectOne(namespace + ".count");
}
//게시물 목록 + 페이징
@Override
public List listPage(int displayPost, int postNum) throws Exception {

HashMap data = new HashMap();

data.put("displayPost", displayPost);
data.put("postNum", postNum);

return sql.selectList(namespace + ".listPage", data);
}
}