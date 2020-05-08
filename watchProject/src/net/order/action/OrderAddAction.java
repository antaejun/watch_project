package net.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.order.db.OrderDAO;
import net.order.db.OrderDTO;

public class OrderAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("OrderAddAction_execute() 호출!");
		
		String user_email = "test@test.com";
		
		request.setCharacterEncoding("UTF-8");
		
		OrderDTO odto = new OrderDTO();
		
		odto.setItem_code(request.getParameter("item_code"));
		odto.setMemo(request.getParameter("memo"));
		odto.setOrder_amount(Integer.parseInt(request.getParameter("order_amount")));
		odto.setOrder_color(request.getParameter("order_color"));
		odto.setOrder_name(request.getParameter("order_name"));
		odto.setOrder_phone(request.getParameter("order_phone"));
		odto.setOrder_price(Integer.parseInt(request.getParameter("order_price")));
		odto.setOrder_size(request.getParameter("order_size"));
		odto.setReceive_address(request.getParameter("receive_address"));
		odto.setReceive_address_detail(request.getParameter("receive_address_detail"));
		odto.setReceive_name(request.getParameter("receive_name"));
		odto.setReceive_phone(request.getParameter("receive_phone"));
		odto.setUser_email(request.getParameter("user_email"));
		odto.setPayment_type(request.getParameter("payment_type"));
		odto.setTrade_payer(request.getParameter("trade_payer"));
		
		OrderDAO odao = new OrderDAO();
		odao.addOrder(odto);
		
		return null;
	}
	

}
