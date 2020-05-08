package net.shoppingBasket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.shoppingBasket.db.shoppingBasketDAO;
import net.shoppingBasket.db.shoppingBasketDTO;

public class shoppingBasketAddAction implements ActionshoppingBasket {

	@Override
	public ActionForwardshoppingBasket execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("BasketAddAction_execute() 호출");
		
		// 세션값을 사용해서 장바구니 사용 가능 
		// 세션값이 없을경우 장바구니 사용 불가능 (로그인 페이지 이동)
		
		HttpSession session = request.getSession();
		String user_email =(String) session.getAttribute("user_email");
		
		ActionForwardshoppingBasket forward = new ActionForwardshoppingBasket();
		if( user_email == null ){
			forward.setPath("./UserLogin.com");
			forward.setRedirect(true);
			return forward;			
		}
		
   	 
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// BasketDTO 객체 생성 -> 정보 저장
		shoppingBasketDTO sbkdto = new shoppingBasketDTO();
		// num,amount,size,color, + id
		sbkdto.setItem_code(request.getParameter("item_code"));
		
		sbkdto.setBasket_amount(Integer.parseInt(request.getParameter("item_amount")));
		sbkdto.setBasket_size(request.getParameter("item_size"));
		sbkdto.setBasket_color(request.getParameter("item_color"));
		sbkdto.setBasket_price(Integer.parseInt(request.getParameter("item_price")));
		
		
		System.out.println("밑에꺼 오류임 넘버 오류");
		//sbkdto.setBasket_price(Integer.parseInt(request.getParameter("item_price")));
		System.out.println("위에꺼 오류임 넘버 오류");
		sbkdto.setUser_email(user_email);
		
		// BasketDAO 저장
		shoppingBasketDAO bkdao = new shoppingBasketDAO();
		// 기존의 장바구니에 상품이 있는지 체크
		int check = bkdao.checkWatch(sbkdto);
		System.out.println("데이터 확인가능()위 ㅇㅋ");
		// 없을경우 장바구니에 추가
		if(check != 1){
			bkdao.basketAdd(sbkdto);
		}
		
		// 페이지 이동 (장바구니 목록 페이지)
		forward.setPath("./shoppingBasketList.shopping");
		forward.setRedirect(true);	
		return forward;
	}

}
