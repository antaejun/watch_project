package net.review.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.review.db.ReviewDTO;

public interface Action {
	
	public List<ReviewDTO> exeute(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}