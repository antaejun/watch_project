package net.orderWatch.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderWatchFrontController extends HttpServlet{
	
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
		ActionForwardOrderWatch forward = null;
		ActionOrderWatch action = null;
		
		if(command.equals("/OrderWatchStar.orw")){
			// 구매할 물품정보(장바구니) + 사용자 정보를 입력(model->view)
			System.out.println("/OrderWatchStar.or 처리 (model->view)");
			// OrderWatchStarAction() 객체 생성
			action = new OrderWatchStarAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/OrderWatchAdd.orw")){
			System.out.println("/OrderWatchAdd.or 처리 (model)");
			// OrderWatchAddAction() 객체 생성 
			action = new OrderWatchAddAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/OrderWatchList.orw")){
			// /OrderWatchList.or => model->view
			System.out.println("/OrderWatchList.or 처리 (model->view)");
			// OrderWatchListAction() 객체 생성
			action = new OrderWatchListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/OrderWatchDetail.orw")){
			// /OrderWatchDetail.or => 주문번호 상세페이지
			
			System.out.println("/OrderWatchDetail.or 처리 (model->view)");

			// OrderWatchDetailAction 객체 생성
			action = new OrderWatchDetailAction();
			
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

		if (forward != null) {
			// if(forward.isRedirect() == true){
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());

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
