package net.shoppingBasket.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.shoppingBasket.db.shoppingBasketDAO;

public class shoppingBasketListAction implements ActionshoppingBasket {

	@Override
	public ActionForwardshoppingBasket execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("BasketListAction_execute() 호출");
		
		// 세션값(id)있을때만 처리 가능
		// 없을경우 로그인페이지 이동
		HttpSession session = request.getSession();
		
		String user_email = (String) session.getAttribute("user_email");
		
		ActionForwardshoppingBasket forward = new ActionForwardshoppingBasket();
		if(user_email == null){
			forward.setPath("./UserLogin.com");
			forward.setRedirect(true);
			return forward;
		}
		
		// BasketDAO 객체 생성
		shoppingBasketDAO bkdao = new shoppingBasketDAO();
		// 장바구 리스트 가져와서 저장 
		Vector vec =  bkdao.getshoopingBasketList(user_email);

		// 해당정보 request 저장
		ArrayList basketList = (ArrayList)vec.get(0);

		ArrayList watchList = (ArrayList)vec.get(1);
		
		request.setAttribute("basketList", basketList);
		request.setAttribute("watchList", watchList);
		
		//request.setAttribute("basketList", vec.get(0));
		
		// 페이지 이동(./goods_order/goods_basket.jsp)
		forward.setPath("./watch_order/watch_basket.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
