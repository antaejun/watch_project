package net.admin.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminMemberFrontController extends HttpServlet{

	protected void doPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("@@@doPro@@@");
		
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
		
		if(command.equals("/MemberList.am")){
			System.out.println("MemberList.am model-view");
			
			action = new MemberListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberDisable.am")){
			
			action = new MemberDisableAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberAble.am")){
			action = new MemberAbleAction();
		
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/AdminMemberModify.am")){
			System.out.println("/AdminMemberModify.am view");
			
			action = new AdminMemberModifyForm();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/AdminMemberModifyAction.am")){
			
			System.out.println("/AdminMemberModifyAction.am model");
			
			action = new AdminMemberModifyAction();
			
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
		System.out.println("@@@doGet@@@");
		doPro(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("@@@doPost@@@");
		doPro(request, response);
	}

	
	
}
