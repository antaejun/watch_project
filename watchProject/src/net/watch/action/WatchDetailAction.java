package net.watch.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.items.db.ItemDTO;
import net.watch.db.WatchDAO;

public class WatchDetailAction implements ActionWatch{

	@Override
	public ActionForwardWatch execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("GoodsDetailAction_execute() 호출");
		
		// num 파라미터 저장
		//int item_code = Integer.parseInt(request.getParameter("item_code"));
		
		// GoodsDAO 생성
		// -> getGoods(num)
		//WatchDAO wdao = new WatchDAO();
		//ItemDTO wdto = wdao.getWatch(item_code);
		
		// GoodsDTO객체 담아서 전달
		// => request 영역에 저장
		//request.setAttribute("wdto", wdto);
		
		// 페이지 이동(./goods/goods_detail.jsp)
		ActionForwardWatch forward = new ActionForwardWatch();
		System.out.println("###########");
		forward.setPath("./watch/watch_detail.jsp");
		forward.setRedirect(false);		
		return forward;
	}

}
