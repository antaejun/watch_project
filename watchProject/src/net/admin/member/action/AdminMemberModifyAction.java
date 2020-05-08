package net.admin.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.member.db.AdminMemberDAO;
import net.admin.member.db.AdminMemberDTO;

public class AdminMemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@AdminMemberModifyAction@@@");
		
		request.setCharacterEncoding("UTF-8");
		
		AdminMemberDTO amdto = new AdminMemberDTO();
		amdto.setIdx(Integer.parseInt(request.getParameter("idx")));
		amdto.setUser_email(request.getParameter("user_email"));
		amdto.setUser_pw(request.getParameter("user_pw"));
		amdto.setUser_name(request.getParameter("user_name"));
		amdto.setAddress(request.getParameter("address"));
		amdto.setAddress_detail(request.getParameter("address_detail"));
		amdto.setPhone(request.getParameter("phone"));
		amdto.setUser_status(request.getParameter("user_status"));
		amdto.setDelete_yn(request.getParameter("delete_yn"));
		
		AdminMemberDAO amdao = new AdminMemberDAO();
		amdao.adminMemberModify(amdto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberList.am");
		forward.setRedirect(true);
		
		return forward;
	}

}
