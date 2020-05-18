package com.kitchen.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kitchen.domain.KitchenOptionVO;
import com.kitchen.domain.KitchenVO;
import com.kitchen.service.KitchenService;
import com.kitchen.utils.UploadFileUtils;

@Controller
@RequestMapping("/kitchen/*")
public class KitchenController {
	

		private static final Logger logger = LoggerFactory.getLogger(KitchenController.class);

		// 서비스 객체 (의존 주입)
		@Inject
		private KitchenService service;

	
		
		
		@RequestMapping(value = "/List", method = RequestMethod.GET)
		public void ListGET(@ModelAttribute("List") String List, Model model) throws Exception {
			logger.info(" 글쓰기 완료후 글 목록페이지 요청(GET) ");
			logger.info("List "+List);

			// 게시판 디비에 있는 정보를 가져와서 출력(뷰페이지로 전달)
			// 서비스 계층에 있는 메서드 호출
			List<KitchenVO> kitchenList = service.List();
			logger.info("DB 글정보 가져오기 성공!!!");
			logger.info("글 정보 : " + kitchenList);

			model.addAttribute("kitchenList", kitchenList);
			
			
		}
		
		// 특정 글 읽기(본문보기)
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public void readGET(@RequestParam("idx") int idx, Model model) throws Exception {
			System.out.println("@@@@@ /read 주소 호출");
			System.out.println("@@@@@ 글 본문보기" + idx + " 동작을 처리 ");

			// 전달정보(파라미터값)
			// @RequestParam("파라미터값")
			// => request.getParameter()처럼 사용됨(문자열,숫자,날짜 캐스팅 가능)

			// DB에 있는 정보를 가져오기 (idx에 해당하는 값 가져오기)
			KitchenVO kitchenVO = service.read(idx);
			System.out.println("@@@@@ 서비스 계층 호출 완료 ");
			System.out.println("kitchenVO : " + kitchenVO);

			// 해당정보를 저장
			model.addAttribute("kitchenVO", kitchenVO);
			// 페이지 이동
			// -> 메서드 리턴타입이 없기 때문에
			// /kitchen/read.jsp 페이지 찾아간다.
		}
		
//		@Resource(name="uploadPath")
//		private String uploadPath;
//		
//		@RequestMapping(value="/register", method=RequestMethod.GET)
//		public String registGET() throws Exception {
//			return "kitchen/register";
//		}
//		
//		@RequestMapping(value = "/register", method=RequestMethod.POST)
//		public String RegistPOST(KitchenVO vo, MultipartFile file) throws Exception {
//			
//			String imgUploadPath = uploadPath + File.separator + "imgUpload";
//			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
//			String fileName = null;
//
//			if(file != null) {
//			 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
//			} else {
//			 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
//			}
//
//			vo.setImage(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
//			vo.setThumb_image(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
//			
//			service.regist(vo);
//			System.out.println("@@@ 컨트롤러 : 사업자 주방 등록 완료!");
//			String kitchen_name = URLEncoder.encode(vo.getKitchen_name(), "UTF-8");
//			return "redirect:/kitchen/option_register?kitchen_name="+kitchen_name;
//		}
//		
//		// 주방등록 이후 처리 -> 주방옵션 페이지 이동
//		@RequestMapping(value = "/option_register", method = RequestMethod.GET)
//		public ModelAndView optionRegisterGET(HttpServletRequest request) throws Exception {
//			
//			request.setCharacterEncoding("UTF-8");
//			String kitchen_name = request.getParameter("kitchen_name");
//			
//			ModelAndView mav = new ModelAndView();
//			
//			mav.setViewName("kitchen/option_register");
//			mav.addObject("kitchen_name",kitchen_name);
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@"+kitchen_name);
//			
//			return mav;
//		}
//		
//		@RequestMapping(value = "/option_register", method = RequestMethod.POST)
//		public String optionRegisterPOST(KitchenOptionVO vo, RedirectAttributes rttr) throws Exception {
//			logger.info("@@@ /option_register 주소 호출");
//			logger.info("@@@ 컨트롤러 optionRegisterPOST 호출");
//			logger.info("kitchen: " + vo);
//			
//			service.optionRegist(vo);
//			System.out.println("@@@ 컨트롤러 : 옵션 정보 저장완료!(다음페이지로 이동)");
//			
//			rttr.addFlashAttribute("result", "SUCCSESS");
//			
//			return "redirect:/kitchen/List";
//		}
//		
//	
//		
//		
//		
//		// 글 삭제
//		@RequestMapping(value = "/delete", method = RequestMethod.POST)
//		public String deletePost(@RequestParam("kitchen_name") String kitchen_name) {
//			System.out.println("@@@ /delete(post) 주소 실행");
//			System.out.println("@@@ 삭제할 주방이름: " + kitchen_name);
//			
//			try {
//				service.removeKitchen(kitchen_name);
//				
//				System.out.println("@@@ 주방 삭제 완료!(컨트롤러)");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return "redirect:/kitchen/List";
//		}
		
		
}

