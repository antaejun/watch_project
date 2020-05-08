package net.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.items.db.CodeDetailDTO;
import net.items.db.ItemDTO;
import net.items.db.ItemsDAO;

public class ItemsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@ ItemsListAction_execute() 호출!");
		
		ItemsDAO idao = new ItemsDAO();
		
		
		String code = request.getParameter("code");
		String code_name = request.getParameter("code_name");
		String code_detail = request.getParameter("code_detail");
		String code_detail_name = request.getParameter("code_detail_name");
		if(code_detail == null) {
			code_detail = "all";
		}
		List<ItemDTO> itemsList = idao.getItemsList(code, code_detail);
		List<CodeDetailDTO> codeDetailList = idao.getCodeDetailList(code);
		
		System.out.println(itemsList+"######################");
		
		request.setAttribute("itemsList", itemsList);
		request.setAttribute("codeDetailList", codeDetailList);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./items/itemsList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
