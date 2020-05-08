package net.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.items.db.CodeDTO;
import net.items.db.ItemDTO;
import net.items.db.ItemsDAO;

public class ItemCategoryAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("ItemCategoryAction_execute() 호출!");
		
		ItemsDAO idao = new ItemsDAO();
		
		List<CodeDTO> codeList = idao.getCodeList();
		List<ItemDTO> itemsList = idao.getItemsList();
		
		request.setAttribute("codeList", codeList);
		request.setAttribute("itemsList", itemsList);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./items/itemCategory.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	

}
