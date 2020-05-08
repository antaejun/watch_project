package net.code.detail.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.detail.db.CodeDetailDAO;
import net.code.detail.db.CodeDetailDTO;

public class CodeDetailListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@CodeDetailListAction@@@");
		request.setCharacterEncoding("UTF-8");
		
		CodeDetailDTO cddto = new CodeDetailDTO();
		int code = Integer.parseInt(request.getParameter("code"));
		System.out.println("코드 :" +code);
		
		CodeDetailDAO cddao = new CodeDetailDAO();
		
		List<CodeDetailDTO> codeDetailList = cddao.getCodeDetailList(code);
		
		request.setAttribute("codeDetailList", codeDetailList);
		
		//view 페이지 이동
		//./code_detail/code_detail_list.jsp
		ActionForward forward = new ActionForward();
		forward.setPath("./code_detail/code_detail_list.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
