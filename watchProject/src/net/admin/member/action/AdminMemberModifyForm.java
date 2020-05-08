package net.admin.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.member.db.AdminMemberDAO;
import net.admin.member.db.AdminMemberDTO;

public class AdminMemberModifyForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@AdminMemberModifyForm@@@");
		
		ActionForward forward = new ActionForward();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		AdminMemberDAO amdao = new AdminMemberDAO();
		
		AdminMemberDTO amdto = amdao.getMember(idx);
		
		request.setAttribute("selectedMember", amdto);
		
		//페이지 이동(./member/member_modify.jsp)
		forward.setPath("./member/member_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
