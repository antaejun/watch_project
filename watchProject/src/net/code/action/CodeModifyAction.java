package net.code.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.db.CodeDAO;
import net.code.db.CodeDTO;

public class CodeModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@CodeModifyAction@@@");
		
		request.setCharacterEncoding("UTF-8");
		
		CodeDTO cdto = new CodeDTO();
		cdto.setIdx(Integer.parseInt(request.getParameter("idx")));
		cdto.setCode(Integer.parseInt(request.getParameter("code")));
		cdto.setCode_name(request.getParameter("code_name"));
		cdto.setDelete_yn(request.getParameter("delete_yn"));
		
		System.out.println(cdto.toString()+"#########");
		System.out.println("수정 할 코드 : "+cdto);
		
		CodeDAO cdao = new CodeDAO();
		cdao.modifyCode(cdto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./CodesList.co");
		forward.setRedirect(true);
		
		return forward;
	}

}
