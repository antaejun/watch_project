package net.order.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderSheetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("@@@ OrderSheetAction_execute() 호출 !");
		
		String user_email = "test@test.com";
		
		request.setCharacterEncoding("UTF-8");
		
		int order_amount = Integer.parseInt(request.getParameter("order_amount"));
		String order_code = request.getParameter("item_code");
		String order_name = request.getParameter("item_name");
		String order_size = request.getParameter("item_size");
		String order_color =  request.getParameter("item_color");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./order/orderSheet.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
