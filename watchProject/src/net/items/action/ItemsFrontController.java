package net.items.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ItemsFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doProcess() 호출!");
		//////////////////////////////////////////////////////////////////////////////
		// 1. 가상주소 계산
		//////////////////////////////////////////////////////////////////////////////
		
		String requestURI = request.getRequestURI();
		System.out.println("URI : " + requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("ContextPath(프로젝트명) : " + contextPath);
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command : " + command);
		
		System.out.println("----------------- 페이지 주소 계산 완료 -----------------");
		
		//////////////////////////////////////////////////////////////////////////////
		// 2. 계산된 주소를 사용해서 페이지 형태구분(View/Model)
		//////////////////////////////////////////////////////////////////////////////
		
		System.out.println("----------------- 페이지 구분(view/model) -----------------");
		
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/ItemCategory.go")) {
			System.out.println("/ItemCategory.go 처리 model->view");
			
			action = new ItemCategoryAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/ItemCodeDetail.go")) {
			System.out.println("/ItemCodeDetail.go 처리 model->view");
			
			action = new ItemCodeDetailAction();
			
			try {
				forward = action.execute(request, response);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/ItemsList.go")) {
			System.out.println("/ItemsList.go 처리 model->view");
			
			action = new ItemsListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/ItemsDetail.go")) {
			System.out.println("/ItemsDetail.go 처리 model->view");
			
			action = new ItemsDetailAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		//////////////////////////////////////////////////////////////////////////////
		// 3. 실제 페이지 이동 동작 (redirect/forward)
		//////////////////////////////////////////////////////////////////////////////
		
		System.out.println("----------------- 페이지 이동(redirect(true)/forward(false)) -----------------");
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = 
						request.getRequestDispatcher(forward.getPath());
				
				dis.forward(request, response);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet() 호출");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doPost() 호출");
		doProcess(request, response);
	}
	
	

}
