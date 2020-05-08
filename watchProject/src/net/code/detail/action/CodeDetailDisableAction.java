package net.code.detail.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.detail.db.CodeDetailDAO;

public class CodeDetailDisableAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@CodeDetailDisalbe@@@");
		
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int code = Integer.parseInt(request.getParameter("code"));
		
		CodeDetailDAO cddao = new CodeDetailDAO();
		cddao.disableCodeDetail(idx);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./CodeDetailList.cd?code="+code+"");
		forward.setRedirect(true);
		
		return forward;
	}

}
