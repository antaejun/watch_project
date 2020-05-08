package net.orderWatch.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.orderWatch.db.WatchOrderDAO;
import net.orderWatch.db.WatchOrderDTO;
import net.shoppingBasket.db.shoppingBasketDAO;
import net.watch.db.WatchDAO;

public class OrderWatchAddAction implements ActionOrderWatch {

	@Override
	public ActionForwardOrderWatch execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("OrderAddAction_execute() 호출");

		// 세션값 사용해서 로그인 체크
		HttpSession session = request.getSession();
		String user_email = (String) session.getAttribute("user_email");

		ActionForwardOrderWatch forward = new ActionForwardOrderWatch();
		if (user_email == null) {
			forward.setPath("./UserLogin.com");
			forward.setRedirect(true);
			return forward;
		}

		// 한글 처리
		request.setCharacterEncoding("UTF-8");

		// 주문정보를 저장 (결제)
		// OrderDTO 객체 생성
		WatchOrderDTO owdto = new WatchOrderDTO();
		 
		owdto.setUser_email(request.getParameter("user_email"));
		owdto.setOrder_name(request.getParameter("order_name"));
		owdto.setOrder_phone(request.getParameter("order_phone"));
		owdto.setReceive_name(request.getParameter("receive_name"));
		owdto.setReceive_phone(request.getParameter("receive_phone"));
		owdto.setReceive_address(request.getParameter("receive_address"));
		owdto.setReceive_adress_detail(request.getParameter("receive_adress_detail"));
		owdto.setMemo(request.getParameter("memo"));
		owdto.setTrade_payer(request.getParameter("trade_payer"));
		// 결제 타입을 추가적으로 저장
		
		

		// 장바구니 상품정보를 가져오기
		shoppingBasketDAO sbkdao = new shoppingBasketDAO();
		Vector vec = sbkdao.getshoopingBasketList(user_email);

		List basketList = (List) vec.get(0);
		List watchList = (List) vec.get(1);

		// 결제 모듈(동작) 처리

		// OrderDAO 객체 생성 -> addOrder()
		WatchOrderDAO wodao = new WatchOrderDAO();
		wodao.addOrderWatch(owdto, basketList, watchList);

		// 메일,문자 발송

		// 상품정보 수정( 수량 차감 )
		// -> GoodsDAO 객체 사용 처리 (AdminGoodsDAO 처리 가능)
		WatchDAO wdao = new WatchDAO();
		wdao.updateAmount(basketList);

		// 장바구니 비우기(장바구니 삭제)
		// BasketDAO sbkdao = new BasketDAO();
		sbkdao.basketDelete(user_email);

		// 페이지 이동
		forward.setPath("./OrderWatchList.or");
		forward.setRedirect(true);
		return forward;
	}

}
