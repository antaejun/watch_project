package net.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.basket.db.BasketDAO;

public class BasketDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("@@@ BasketDeleteAction_execute 호출 !");
		
		// HttpSession session = request.getSession();
		// String id = (String) session.getAttribute("id");
		
		String id = "test@test.com";
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BasketDAO bkdao = new BasketDAO();
		
		bkdao.basketDelete(idx);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./BasketList.ba");
		forward.setRedirect(true);
		
		return forward;
	}
	

}
