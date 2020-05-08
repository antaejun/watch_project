package net.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.items.db.CodeDTO;
import net.items.db.ItemDTO;
import net.items.db.ItemsDAO;
import net.main.action.ActionForward;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String code = request.getParameter("code");
		
		ItemsDAO idao = new ItemsDAO();
		List<CodeDTO> codeList = idao.getCodeList();
		List<ItemDTO> itemsList = idao.getItemsList(code);
		
		request.setAttribute("codeList", codeList);
		request.setAttribute("itemsList", itemsList);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("main/main.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
