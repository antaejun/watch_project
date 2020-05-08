package net.watch.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WatchFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doProcess() 호출!");
		////////////////////////////////////////////////////////////
		// 1. 가상주소 계산
		////////////////////////////////////////////////////////////

		String requestURI = request.getRequestURI();
		System.out.println("URI : " + requestURI);

		String contextPath = request.getContextPath();
		System.out.println("ContextPath(프로젝트명) : " + contextPath);

		String command = requestURI.substring(contextPath.length());
		System.out.println("command : " + command);

		System.out.println("----------페이지 주소 계산 완료----------------------");

		////////////////////////////////////////////////////////////
		// 2. 계산된 주소를 사용해서 페이지 형태구분(View/Model)
		////////////////////////////////////////////////////////////
		System.out.println("----------페이지 구분 (view/model)-----------------");
		
		// 이동정보 처리객체 
		ActionForwardWatch forward = null;
		ActionWatch action = null;
		
		if(command.equals("/WatchList.gos")){
			// 일반 사용자가 상품의 정보를 확인하는 리스트
			// GoodsListAction() 객체 생성
			System.out.println("/WatchList.go 처리 model->view");
			
			action = new WatchListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/WatchDetail.gos")){
			// 상품 상세페이지 (model->view)
			// GoodsDetailAction() 객체 생성
			System.out.println("/WatchDetail.go 페이지 처리 model->view");
			
			action = new WatchDetailAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		////////////////////////////////////////////////////////////
		// 3. 실제 페이지 이동 동작 (redirect/forward)
		////////////////////////////////////////////////////////////
		System.out.println("-----------페이지 이동(redirect(true)/forward(false))---------------");
		
		if(forward != null){
			//if(forward.isRedirect() == true){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dis =
						request.getRequestDispatcher(forward.getPath());
				
				dis.forward(request, response);
			}
		}
		
		
		
		
		// 페이지 이동정보가 있을때만 페이지 이동

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
