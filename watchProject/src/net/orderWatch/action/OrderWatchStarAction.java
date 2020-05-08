package net.orderWatch.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.shoppingBasket.db.shoppingBasketDAO;
import net.user.db.UserBean;
import net.user.db.UserDAO;

public class OrderWatchStarAction implements ActionOrderWatch {

	@Override
	public ActionForwardOrderWatch execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("OrderWatchStarAction_execute() 호출");
		// 구매하기 페이지
		// 사용자 로그인 체크 -> 장바구니,상품정보를 가져오기
		// -> 사용자 정보를 가져오기-> 필요한 정보를 저장 -> 페이지 이동
		
	    HttpSession session = request.getSession();
	    String user_email = (String)session.getAttribute("user_email");
	    
	    ActionForwardOrderWatch forward = new ActionForwardOrderWatch();
	    if(user_email == null){
	    	forward.setPath("./UserLogin.com");
	    	forward.setRedirect(true);
	    	return forward;	    	
	    }
	    
	    //BasketDAO 객체 생성
	    shoppingBasketDAO sbkdao = new shoppingBasketDAO();
	    Vector vec = sbkdao.getshoopingBasketList(user_email);
	    
	    //request영역에 장바구니,상품정보 저장
	    List basketList = (List)vec.get(0);
	    List watchList = (List)vec.get(1);
	    
	    // 저장
	    request.setAttribute("basketList", basketList);
	    request.setAttribute("watchList", watchList);
	    
	    // +회원 정보를 저장 
	    UserDAO udao = new UserDAO();
	    // 로그인 한 사람의 정보
	    UserBean userDTO = udao.getUser(user_email);
	    
	    // 저장 
	    request.setAttribute("userDTO", userDTO);
		
	    // 페이지 이동
		forward.setPath("./watch_order/watch_buy.jsp");
		forward.setRedirect(false);		
		return forward;
	}

}
