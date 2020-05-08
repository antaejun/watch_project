package net.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.user.db.UserBean;
import net.user.db.UserDAO;

public class UserUpdate implements ActionUser {

	@Override
	public ActionForwardUser execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("@@@UserUpdate_execute() ");
		
		// 세션값 제어
		HttpSession session = request.getSession();
		String user_email = (String)session.getAttribute("user_email");
		
		ActionForwardUser forward = new ActionForwardUser();
		if(user_email == null){
			forward.setPath("./UserLogin.com");
			forward.setRedirect(true);
			return forward;
		}
		
		// UserDAO 객체 생성
		UserDAO udao = new UserDAO();
		
		// getUser(id) 사용해서 사용자 정보를 가져와서 출력
		// => UserBean 객체를 사용해서 저장후 출력
		UserBean ur = udao.getUser(user_email);
		
		// request 객체에 저장
		request.setAttribute("ur", ur);
		
		// 페이지 이동 (./updateFormUser.jsp)
		forward.setPath("./user/updateFormUser.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
