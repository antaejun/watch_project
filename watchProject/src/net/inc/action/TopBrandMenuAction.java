package net.inc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.inc.db.IncDAO;
import net.items.db.CodeDTO;

public class TopBrandMenuAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		IncDAO indao = new IncDAO();
		
		List<CodeDTO> codeList = indao.getCodeList();
		
		request.setAttribute("codeList", codeList);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./inc/top.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	

}
