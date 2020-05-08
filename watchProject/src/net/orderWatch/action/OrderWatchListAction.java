package net.orderWatch.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.orderWatch.db.WatchOrderDAO;

public class OrderWatchListAction implements ActionOrderWatch {

	@Override
	public ActionForwardOrderWatch execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("OrderListAction_execute() 호출");
		// 주문 상태의 정보를 확인 (본인의 주문정보만)
		// view 페이지에서 출력
		
		// 세션값사용 (ID체크)
		HttpSession session = request.getSession();
		String user_email = (String) session.getAttribute("user_email");
		ActionForwardOrderWatch forward = new ActionForwardOrderWatch();
		if(user_email == null){
			forward.setPath("./UserLogin.com");
			forward.setRedirect(true);
			return forward;
		}
		
		//OrderDAO 객체 생성
		// => 개인의 주문목록을 가져오기
		WatchOrderDAO odao = new WatchOrderDAO();
		ArrayList orderList = odao.getOrderList(user_email);
		
		// request 영역에 저장
		request.setAttribute("orderList", orderList);
		
		// 페이지 이동(./goods_order/order_list.jsp)
		forward.setPath("./watch_order/watch_order_list.jsp");
		forward.setRedirect(false);	
		return forward;
	}

}
