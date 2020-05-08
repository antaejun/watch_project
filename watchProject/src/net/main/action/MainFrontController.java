package net.main.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Index.jsp 로드");
    	
    	Action action = new MainSliderListAction();
    	ActionForward forward = null;
    	
    	try {
    		forward = action.execute(request, response);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	if(forward != null){
        	if(forward.isRedirect()){
        		response.sendRedirect(forward.getPath());
        		System.out.println("리다이렉트");
        	}else{
        		RequestDispatcher dis =
        				request.getRequestDispatcher(forward.getPath());
        		dis.forward(request, response);
        		System.out.println("포워드");
        	}
        }
    	
    }
    
    
    
    
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("두겟");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("두포스트");
		doProcess(request, response);
	}

}
