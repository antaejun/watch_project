package net.code.detail.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.detail.db.CodeDetailDAO;
import net.code.detail.db.CodeDetailDTO;

public class CodeDetailAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		System.out.println("@@@CodeDetailAddAction@@@");
		
		request.setCharacterEncoding("UTF-8");
		
		CodeDetailDTO cddto = new CodeDetailDTO();
		
		cddto.setCode_detail(request.getParameter("code_detail"));
		cddto.setCode_detail_name(request.getParameter("code_detail_name"));
		cddto.setCode(Integer.parseInt(request.getParameter("code")));
		
		CodeDetailDAO cddao = new CodeDetailDAO();
		
		cddao.addCodeDetail(cddto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./CodesList.co");
		forward.setRedirect(true);
		
		return forward;
	}

}
