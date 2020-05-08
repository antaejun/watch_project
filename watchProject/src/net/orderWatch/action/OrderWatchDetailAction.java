package net.orderWatch.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.orderWatch.db.WatchOrderDAO;

public class OrderWatchDetailAction implements ActionOrderWatch {

	@Override
	public ActionForwardOrderWatch execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("OrderDetailAction_execute() 호출");
		// 세션값 사용 (ID체크)
		HttpSession session = request.getSession();
		String user_email = (String) session.getAttribute("user_email");
		ActionForwardOrderWatch forward = new ActionForwardOrderWatch();
		if (user_email == null) {
			forward.setPath("./UserLogin.com");
			forward.setRedirect(true);
			return forward;
		}
		
		//주문번호 정보를 저장
		String order_code = request.getParameter("order_code");
		
		// OrderDAO 객체 생성
		//OrderDAO odao = new OrderDAO();
		//List orderDetailList = odao.orderDetail(trade_num);
		
		List orderDetailList 
		   = new WatchOrderDAO().orderDetail(order_code);
		
		
		// 저장(request 영역)
		request.setAttribute("orderDetailList", orderDetailList);

		// 페이지 이동(./goods_order/order_detail.jsp)
		forward.setPath("./watch_order/watch_detail.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
