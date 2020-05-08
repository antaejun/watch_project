package net.review.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

import net.review.db.ReviewDTO;

public class ReviewFrontController extends HttpServlet{
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
		
		if(command.equals("/ReviewWrite.re")) {
			String body = null;
	        StringBuilder stringBuilder = new StringBuilder();
	        BufferedReader bufferedReader = null;
	 
	        try {
	            InputStream inputStream = request.getInputStream();
	            if (inputStream != null) {
	                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	                char[] charBuffer = new char[256];
	                int bytesRead = -1;
	                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                    stringBuilder.append(charBuffer, 0, bytesRead);
	                }
	            } else {
	                stringBuilder.append("");
	            }
	        } catch (IOException ex) {
	            throw ex;
	        } finally {
	            if (bufferedReader != null) {
	                try {
	                    bufferedReader.close();
	                } catch (IOException ex) {
	                    throw ex;
	                }
	            }
	        }
	 
	        body = stringBuilder.toString();
	        JSONParser jsonParser = new JSONParser();
	        try {
	        	action = new ReviewWriteAction();
	        	
	        	request.setCharacterEncoding("UTF-8");
				
				JSONObject jsonObj = (JSONObject) jsonParser.parse(body);
				request.setAttribute("jsonObj", jsonObj);
				List<ReviewDTO> rvo = action.exeute(request, response);
				
				 System.out.println("$$$$$ : "+rvo);
				 Gson gson = new Gson();
				 Gson gson1 = new Gson();
				String list = gson1.toJson(rvo);
				 PrintWriter out = response.getWriter();
				System.out.println("list : " + list);
				 out.write(list);
				 out.flush();
				
				 out.close();
				    //  out.write(str);
				    //  out.write(arr);
				    //  out.write(user);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
	

