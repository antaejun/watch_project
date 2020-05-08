package net.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.main.db.*;

public class MainSliderListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("@@@ MainSliderListAction_execute() @@@");
		
		ActionForward forward = new ActionForward();
		// 한글처리 
		request.setCharacterEncoding("UTF-8");
		
		// 메인DAO
		MainDAO mdao = new MainDAO();
		// 슬라이더빈 리스트
		List<MainSliderBean> sliderList = mdao.getSliderList(1);
		
		// request 영역 저장
		request.setAttribute("sliderList", sliderList);
		
		List<MainSliderBean> trendList = mdao.getSliderList(2);
		request.setAttribute("trendList", trendList);
		
		
		forward.setPath("./main/home.jsp");
		forward.setRedirect(false);
		return forward;
	}
	
}
