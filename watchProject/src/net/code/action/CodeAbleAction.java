package net.code.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.db.CodeDAO;

public class CodeAbleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@CodeAbleAction@@@");
		
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		CodeDAO cdao = new CodeDAO();
		cdao.ableCode(idx);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./CodesList.co");
		forward.setRedirect(true);
		
		return forward;
	}

}
