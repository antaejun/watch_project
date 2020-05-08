package net.code.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.code.db.CodeDAO;
import net.code.db.CodeDTO;

public class CodeListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("@@@CodeListAction@@@");
		
		CodeDAO cdao = new CodeDAO();
		
		List<CodeDTO> codesList = cdao.getCodesList();
		
		request.setAttribute("codesList", codesList);
		
		//veiw 페이지 이동
		//./code/codes_list.jsp
		ActionForward forward = new ActionForward();
		forward.setPath("./code/codes_list.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
