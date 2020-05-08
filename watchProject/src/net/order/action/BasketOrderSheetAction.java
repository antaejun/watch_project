package net.order.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.basket.db.BasketDAO;

public class BasketOrderSheetAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("BasketOrderSheetAction_execute() 호출");
		
		String user_email = "test@test.com";
		
		BasketDAO bkdao = new BasketDAO();
		Vector vec = bkdao.getBasketList(user_email);
		
		List basketList = (List)vec.get(0);
		List itemsList = (List)vec.get(1);
		
		request.setAttribute("basketList", basketList);
		request.setAttribute("itemsList", itemsList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./order/basketOrderSheet.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	

}
