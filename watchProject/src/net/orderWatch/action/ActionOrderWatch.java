package net.orderWatch.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionOrderWatch {
	
	// 추상메서드 선언 => 인터페이스를 구현하는 모든 클래스에 처리하는 동작의 틀을 구성한다.
	public ActionForwardOrderWatch execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	

}
