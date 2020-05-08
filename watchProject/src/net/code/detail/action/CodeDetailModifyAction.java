package net.code.detail.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.detail.db.CodeDetailDAO;
import net.code.detail.db.CodeDetailDTO;

public class CodeDetailModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		System.out.println("@@@CodeDetailModifyAction@@@");
		
		request.setCharacterEncoding("UTF-8");
		
		CodeDetailDTO cddto = new CodeDetailDTO();
		cddto.setIdx(Integer.parseInt(request.getParameter("idx")));
		cddto.setCode_detail(request.getParameter("code_detail"));
		cddto.setCode_detail_name(request.getParameter("code_detail_name"));
		
		CodeDetailDAO cddao = new CodeDetailDAO();
		cddao.modifyCodeDetail(cddto);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./CodeDetailList.cd?code="+code+"");
		forward.setRedirect(true);
		
		return forward;
	}

}
