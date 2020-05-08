package net.code.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeFrontController extends HttpServlet{
	
	protected void doPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("doPro@@@");
		
		String requestURI = request.getRequestURI();
		System.out.println("URI : "+ requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("ContextPath : " + contextPath);
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command : " + command);
		
		System.out.println("----------페이지 주소 계산 완료----------");
	
		//페이지 구분(v/m)
		System.out.println("----------페이지 구분(view/model)----------");
		
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/CodesAdd.co")){
			//관리자 코드 등록(view)
			//code/codes_add.jsp
			System.out.println("/CodesAdd.co view 이동");
			
			forward = new ActionForward();
			forward.setPath("./code/codes_add.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/CodeAddAction.co")){
			System.out.println("/CodeAddAction.co model");
			
			action = new CodeAddAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/CodesList.co")){
			System.out.println("/CodesList.co model-view");
			
			action = new CodeListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/CodeDisable.co")){
			
			action = new CodeDisableAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/CodeAble.co")){
			
			action = new CodeAbleAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/CodeModify.co")){
			System.out.println("/CodeModify.co view");
			
			action = new CodeModifyForm();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/CodeModifyAction.co")){
			
			System.out.println("/CodeModifyAction.co model");
			
			action = new CodeModifyAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//페이지 이동
		System.out.println("----페이지 이동(redirect/forward)------");
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dis = 
						request.getRequestDispatcher(forward.getPath());
				
				dis.forward(request, response);
			}
		}
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet@@@");
		doPro(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost@@@");
		doPro(request,response);
	}

}
