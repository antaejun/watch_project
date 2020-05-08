package net.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.items.db.ItemDTO;
import net.items.db.ItemsDAO;
import net.review.db.ReviewDAO;
import net.review.db.ReviewDTO;

public class ItemsDetailAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
	
		System.out.println("@@@ ItemsDetailAction_execute() 호출!");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String item_code = request.getParameter("item_code");
		System.out.println(idx);
		
		ItemsDAO idao = new ItemsDAO();
		ReviewDAO rdao = new ReviewDAO();
		
		ItemDTO idto = idao.getItems(idx);
		List<ReviewDTO> reviewList = rdao.getReviewList(item_code);
		System.out.println(reviewList+"=======================");
		
		
		request.setAttribute("idto", idto);
		request.setAttribute("reviewList", reviewList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./items/itemsDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

	

}
