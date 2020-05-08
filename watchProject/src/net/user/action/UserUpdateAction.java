package net.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.user.db.UserBean;
import net.user.db.UserDAO;

public class UserUpdateAction implements ActionUser {

	@Override
	public ActionForwardUser execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 System.out.println("@@@ UserUpdateAction_execute() ");
		 
		 // 세션처리 
		 HttpSession session = request.getSession();
		 String user_email = (String)session.getAttribute("user_email");
		 
		 ActionForwardUser forward = new ActionForwardUser();
		 if(user_email == null){
			 forward.setPath("./UserLogin.com");
			 forward.setRedirect(true);
			 return forward;
		 }
		 
		 
		 // 한글처리 
		 request.setCharacterEncoding("UTF-8");
		 
		 // 이전페이지에서 전달한 정보 저장(파라미터)
		 // UserBean 객체 생성(자바빈)
		 UserBean ur = new UserBean();
		 
		/*
		 * ur.setAge(Integer.parseInt(request.getParameter("age")));
		 * ur.setEmail(request.getParameter("email"));
		 * ur.setGender(request.getParameter("gender"));
		 */
		 ur.setUser_email(user_email);
		 ur.setUser_name(request.getParameter("user_name"));
		 ur.setUser_pw(request.getParameter("user_pw"));
		 ur.setAddress(request.getParameter("address"));
		 ur.setAddress_detail(request.getParameter("address_detail"));
		 ur.setPhone(request.getParameter("phone"));
		
		 
		 // MemberDAO 객체 생성
		 UserDAO udao = new UserDAO();
		 // 수정 처리 메서드 : updateMember(ur)
		 int check = udao.updateUser(ur);
		 
		 // 0,1,-1 결과에 따라서 처리 
		 // 0 => 비밀번호 오류
		 // 1 => 정상수정
		 // -1 => 아이디 없음
		 // alert 메세지 후 뒤로이동, 메인페이지로 이동  
		 
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
		 out.print("<script>");
		 out.print(" alert('정보 수정 성공'); ");
		 out.print(" location.href='./MainView.com'; ");
		 out.print("</script>"); 
		 out.close();
		 return null;
		
	}

}
