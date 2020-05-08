package net.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.user.db.UserBean;
import net.user.db.UserDAO;

public class UserInfoAction implements ActionUser{

	@Override
	public ActionForwardUser execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("@@@ UserInfoAction_execute() ");
		
		// 세션정보가 있을때만 진행
		// 없으면 로그인 페이지로 이동
		HttpSession session = request.getSession();
		
		String user_email = (String) session.getAttribute("user_email");
		
		ActionForwardUser forward = new ActionForwardUser();
		if(user_email == null){
			//response.sendRedirect(".UserLogin.com");
			forward.setPath("./UserLogin.com");
			forward.setRedirect(true);
			
			return forward;
		}
		
		// UserDAO 객체 생성
		UserDAO udao = new UserDAO();
		// getUser(user_email); 
		// => id에 해당하는 회원정보 모두를 가져오기
		UserBean ur = udao.getUser(user_email);
		
		// 회원정보를 request 영역에 저장
		request.setAttribute("ur", ur);
		
		// 페이지 이동  ./user/Userinfo.jsp
        forward.setPath("./user/Userinfo.jsp");
        forward.setRedirect(false);		
		return forward;
	}
	
}
