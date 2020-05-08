package net.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.items.db.CodeDetailDTO;
import net.items.db.ItemDTO;
import net.items.db.ItemsDAO;

public class ItemCodeDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("ItemCodeDetailAction_execute() 호출!");
		
		String code = request.getParameter("code");
		String code_name = request.getParameter("code_name");
		
		ItemsDAO idao = new ItemsDAO();
		
		List<CodeDetailDTO> codeDetailList = idao.getCodeDetailList(code);
		List<ItemDTO> itemsList = idao.getItemsList(code);
		
		
		request.setAttribute("codeDetailList", codeDetailList);
		request.setAttribute("itemsList", itemsList);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./items/itemCodeDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	

}
