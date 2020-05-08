package net.user.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.user.db.UserBean;
import net.user.db.UserDAO;

public class UserJoinAction implements ActionUser{
	// 회원가입 처리 Model객체 
	@Override
	public ActionForwardUser execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@ UserJoinAction_execute() ");
		
		// 한글처리 
		request.setCharacterEncoding("UTF-8");
		
		// 전달된 회원정보를 저장 객체생성(자바빈객체)
		UserBean ur = new UserBean();
		// 전달된 파라미터정보를 저장 
		ur.setAddress(request.getParameter("address"));
		ur.setAddress_detail(request.getParameter("address_detail"));
		ur.setDelete_yn(request.getParameter("delete_yn"));
		ur.setModify_date(new Timestamp(System.currentTimeMillis()));
		ur.setPhone(request.getParameter("phone"));
		ur.setReg_date(new Timestamp(System.currentTimeMillis()));
		ur.setUser_email(request.getParameter("user_email"));
		ur.setUser_name(request.getParameter("user_name"));
		ur.setUser_pw(request.getParameter("user_pw"));
		ur.setUser_status(request.getParameter("user_status"));
		
		// 확인	
		//System.out.println(ur.toString());

		// DB에 값을 저장하기 위한 객체생성 (DAO객체)
		UserDAO udao = new UserDAO();
		
		// insertUser(자바빈);
		udao.insertUser(ur);
		
		// 페이지 이동(로그인 페이지로이동)
		// ActionForward 객체를 생성해서 값 저장 후 이동
		ActionForwardUser forward = new ActionForwardUser();
		forward.setPath("./UserLogin.com");//옆에 주소 수정해야함. 원래 페이지로
		forward.setRedirect(true);		
		
		return forward;
	}

	
	
	

}
