package net.shoppingBasket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.shoppingBasket.db.shoppingBasketDAO;

public class shoppingBasketDeleteAction implements ActionshoppingBasket{

	@Override
	public ActionForwardshoppingBasket execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("BasketDeleteAction_execute() 호출");
		
		// 세션값 처리
		HttpSession session = request.getSession();
		String user_email =(String) session.getAttribute("user_email");
		
		ActionForwardshoppingBasket forward = new ActionForwardshoppingBasket();
		if(user_email == null){
			forward.setPath("./UserLogin.com");
			forward.setRedirect(true);
			return forward;
		}
		
		// 삭제할 장바구니 번호 저장
		int idx = Integer.parseInt(request.getParameter("idx"));
		// BasketDAO 객체 생성
		shoppingBasketDAO bkdao = new shoppingBasketDAO();
		
		// basketDelete(번호) 호출
		bkdao.shoppingBasketDelete(idx);
		
		// 페이지 이동	
		forward.setPath("./shoppingBasketList.shopping");
		forward.setRedirect(true);	
		return forward;
	}

}
