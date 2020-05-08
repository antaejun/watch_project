package net.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;
import net.basket.db.BasketDTO;

public class BasketAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("@@@ BasketAddAction_execute 호출!");
		
		// HttpSession session = request.getSession();
		// String id = (String) session.getAttribute("id");
		
		String id = request.getParameter("user_email");
		
		System.out.println(id);
		
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		int order_amount = Integer.parseInt(request.getParameter("order_amount"));
		int basket_price = item_price * order_amount;
		
		ActionForward forward = new ActionForward();
		/*if(id == null) {
			forward.setPath("./로그인페이지");
			forward.setRedirect(true);
			return forward;
		}*/
		
		request.setCharacterEncoding("UTF-8");
		
		BasketDTO bkdto = new BasketDTO();
		
		bkdto.setItem_code(request.getParameter("item_code"));
		bkdto.setBasket_amount(Integer.parseInt(request.getParameter("order_amount")));
		bkdto.setBasket_color(request.getParameter("item_color"));
		bkdto.setBasket_size(request.getParameter("item_size"));
		bkdto.setBasket_price(basket_price);
		bkdto.setUser_email(request.getParameter("user_email"));
		
		
		// 기존 장바구니에 중복상품이 있는 경우
		BasketDAO bkdao = new BasketDAO();
		int check = bkdao.getcheckItems(bkdto);
		
		// 기존 장바구니에 중복상품이 없을 경우
		if(check != 1) {
			bkdao.basketAdd(bkdto);
		}
		
		forward.setPath("./BasketList.ba");
		forward.setRedirect(true);
		return forward;
		
	}
	

}
