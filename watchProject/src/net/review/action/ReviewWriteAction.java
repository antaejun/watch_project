package net.review.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.review.db.ReviewDAO;
import net.review.db.ReviewDTO;

public class ReviewWriteAction implements Action{

	@Override
	public List<ReviewDTO> exeute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("ReviewWriteAction_execute() 호출!");
		
		request.setCharacterEncoding("UTF-8");
		
		ReviewDTO rdto = new ReviewDTO();
		JSONObject jsonObj = (JSONObject)request.getAttribute("jsonObj");
		
		rdto.setContent((String)jsonObj.get("content"));
		rdto.setItem_code((String)jsonObj.get("code"));
		rdto.setUser_email((String)jsonObj.get("user_id"));
		
		ReviewDAO rdao = new ReviewDAO();
		
		int result = rdao.insertReview(rdto);
		List<ReviewDTO> rvo = rdao.selectReview(rdto);
		
		System.out.println("rvossss : " + rvo);
		return rvo;
	}
	
	

}
