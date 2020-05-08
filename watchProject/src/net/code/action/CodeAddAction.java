package net.code.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.db.CodeDAO;
import net.code.db.CodeDTO;

public class CodeAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@CodeAddAction@@@");
		
		request.setCharacterEncoding("UTF-8");
		
		CodeDTO cdto = new CodeDTO();
		
		cdto.setCode(Integer.parseInt(request.getParameter("code")));
		cdto.setCode_name(request.getParameter("code_name"));
		
		CodeDAO cdao = new CodeDAO();
		
		cdao.addCode(cdto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./CodesList.co");
		forward.setRedirect(true);
		
		return forward;
	}
	
	
}
