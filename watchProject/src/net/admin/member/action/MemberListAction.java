package net.admin.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.member.db.AdminMemberDAO;
import net.admin.member.db.AdminMemberDTO;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@MemberListAction execute@@@");
		
		AdminMemberDAO mdao = new AdminMemberDAO();
		
		List<AdminMemberDTO> memberList = mdao.getMemberList();
		
		request.setAttribute("memberList", memberList);
		
		//veiw 페이지 (./member/memberList.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./member/memberList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
