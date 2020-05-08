package net.code.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.db.CodeDAO;
import net.code.db.CodeDTO;

public class CodeModifyForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@CodeModifyForm@@@");
		
		ActionForward forward = new ActionForward();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		CodeDAO cdao = new CodeDAO();
		
		CodeDTO cdto = cdao.getCode(idx);
		
		request.setAttribute("selectedCode", cdto);
		
		//페이지 이동(./code/code_modify.jsp)
		forward.setPath("./code/code_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
