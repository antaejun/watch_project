package net.basket.action;

import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;

public class BasketListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@ BasketListAction_execute() 호출!");
		
		// HttpSession session = request.getSession();
		// String id = (String) session.getAttribute("user_email");
		
		// String user_email = request.getParameter("user_email");
		String user_email = "test@test.com";
		ActionForward forward = new ActionForward();
		
		
		BasketDAO bkdao = new BasketDAO();
		
		Vector vec = bkdao.getBasketList(user_email);
		
		ArrayList basketList = (ArrayList)vec.get(0);
		
		ArrayList itemsList = (ArrayList)vec.get(1);
		
		request.setAttribute("basketList", basketList);
		request.setAttribute("itemsList", itemsList);
		
		forward.setPath("./order/basket.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	

}
