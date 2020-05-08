package net.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.user.db.UserDAO;

public class UserDeleteAction implements ActionUser {

	@Override
	public ActionForwardUser execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("@@@ UserDeleteAction_execute() ");
		
		// 세션 제어
		 HttpSession session = request.getSession();
		 String user_email = (String)session.getAttribute("user_email");
		 
		 ActionForwardUser forward = new ActionForwardUser();
		 if(user_email == null){
			 forward.setPath("./UserLogin.com");
			 forward.setRedirect(true);
			 return forward;
		 }
		// 파라미터값 저장(user_email,user_pw)
		 String user_pw = request.getParameter("user_pw");
		
		// MemberDAO객체 생성후 이동
		 UserDAO udao = new UserDAO();		 

		 // deleteMember(user_email,user_pw or ur);
		 int check = udao.deleteUser(user_email,user_pw);
		
		// update동작 처럼  0,1,-1 이동
		
	
		 response.setContentType("text/html; charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 if( check == 0 ){
			 out.print("<script>");
			 out.print(" alert('비밀번호 오류'); ");
			 out.print(" history.back(); ");
			 out.print("</script>");
			 out.close();
			 return null;
		 }else if(check == -1){
			 out.print("<script>");
			 out.print(" alert('아이디 없음'); ");
			 out.print(" history.back(); ");
			 out.print("</script>"); 
			 out.close();
			 return null;
		 }
		 // check == 1;
     	// 세션값 초기화(user_email정보삭제)
		 session.invalidate();
		 
		 out.print("<script>");
		 out.print(" alert('회원 탈퇴 성공'); ");
		 out.print(" location.href='./MainView.com'; ");
		 out.print("</script>"); 
		 out.close();
		 return null;
	}

}
