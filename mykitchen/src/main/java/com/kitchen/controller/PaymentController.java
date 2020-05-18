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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.kitchen.domain.KitchenVO;
import com.kitchen.service.KitchenService;

@Controller
@RequestMapping("/payment/*")
public class PaymentController {

	






			private static final Logger logger = LoggerFactory.getLogger(KitchenController.class);

			// 서비스 객체 (의존 주입)
			@Inject
			private KitchenService service;

		
			
			
			@RequestMapping(value = "/paymentPage", method = RequestMethod.GET)
			public void paymentPageGET(@ModelAttribute("paymentPage") String paymentPage, Model model) throws Exception {
				logger.info(" 글쓰기 완료후 글 목록페이지 요청(GET) ");
				logger.info("paymentPage "+paymentPage);

				// 게시판 디비에 있는 정보를 가져와서 출력(뷰페이지로 전달)
				// 서비스 계층에 있는 메서드 호출
				/*
				 * Map<KitchenVO> kitchenMap = service.Map(); logger.info("DB 글정보 가져오기 성공!!!");
				 * logger.info("글 정보 : " + kitchenMap);
				 * 
				 * model.addAttribute("kitchenMap", kitchenMap);
				 */
				
				
			}
			
			
	}


