package net.admin.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.member.db.AdminMemberDAO;

public class MemberAbleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@MemberAbleAction@@@");
		
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		AdminMemberDAO mdao = new AdminMemberDAO();
		mdao.ableMember(idx);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberList.am");
		forward.setRedirect(true);
		
		return forward;
	}

}
