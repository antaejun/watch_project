package com.kitchen.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.kitchen.domain.KitchenVO;
import com.kitchen.domain.RentalVO;
import com.kitchen.service.KitchenService;
import com.kitchen.service.RentalService;

@Controller
@RequestMapping("/rental/*")
public class RentalController {
	

		private static final Logger logger = LoggerFactory.getLogger(RentalController.class);

		// 서비스 객체 (의존 주입)
		@Inject
		private RentalService service;


		
	
			// 글쓰기 동작
			/*
			 * @RequestMapping("/regist") public void registGET() throws Exception {
			 * logger.info("@@@@@ 컨트롤러 registGET() 호출 "); //
			 * logger.info("서비스 객체 : "+service); // 객체 정보 생성 BoardVO vo = new BoardVO();
			 * vo.setTitle("새글 작성하기(컨트롤러)"); vo.setContent(" 글 작성하기 완료!!! ");
			 * vo.setWriter("사용자 7");
			 * 
			 * service.regist(vo);
			 * 
			 * System.out.println("@@@@@ 글 등록 완료 (컨트롤러)"); }
			 */
			//@RequestMapping(value = "매핑될 주소값",method = 호출방식)
			@RequestMapping(value = "/register",method = RequestMethod.GET )
			public void registGET() throws Exception{
				logger.info("@@@@@ /regist 주소 호출");
				logger.info("@@@@@ 컨트롤러 registGET() 호출");
				logger.info("./rental/regist.jsp 페이지 호출");
			}
			
			@RequestMapping(value = "/register",method = RequestMethod.POST )
			public String registPOST(RentalVO rental,RedirectAttributes rttr) throws Exception{
				// * 메서드의 전달인자에 객체를 지정시,
				//  전달받는 데이터를 알아서 저장해서 가져온다(바인딩)
				//  단, 해당 객체의 데이터만 가져올수 있음
				logger.info("@@@@@ /regist 주소 호출");
				logger.info("@@@@@ 컨트롤러 registPOST() 호출");
				logger.info("rental:"+rental);
				
				// 서비스 객체를 사용해서 정보를 저장 
				service.regist(rental);
				System.out.println("@@@@@컨트롤러 : 글 저장완료!(다음페이지로 이동)");
				
				// 글정보 저장 성공 값 저장 -> 다음페이지로 전달
				// Model객체에 저장
				//model.addAttribute("result", "SUCCESS");		
				rttr.addFlashAttribute("result", "SUCCESS");		

				//  페이지 이동
				// ./rental/success.jsp 페이지로 이동
//				return "/rental/success";
				// 글목록 페이지(listAll)
				// return "/rental/listAll"; (x)
				return "redirect:/rental/listAll";
			}
}

