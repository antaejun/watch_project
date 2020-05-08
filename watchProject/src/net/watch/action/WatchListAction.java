package net.watch.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.items.db.ItemDTO;
import net.watch.db.WatchDAO;

public class WatchListAction implements ActionWatch{

	@Override
	public ActionForwardWatch execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("WatchListAction_execute() 호출");
		
		// GoodsDAO() 객체 생성
		WatchDAO wdao = new WatchDAO();
		
		String item = request.getParameter("item");
		if(item == null){
			item = "all";
		}
		
		// getGoodsList();
		//-> "전체","인기상품","그외 나머지 카테고리"
		List<ItemDTO> watchList = wdao.getWatchList(item);
		
		// 등록된 모든 상품의 정보를 가져와서 request영역에 저장
		request.setAttribute("watchList", watchList);
		// 페이지 이동(./goods/goods_list.jsp)
		ActionForwardWatch forward = new ActionForwardWatch();
		forward.setPath("./watch/watch_list.jsp");
		forward.setRedirect(false);		
		return forward;
	}
	
}
