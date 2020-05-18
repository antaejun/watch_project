package com.kitchen.controller;

import java.io.File;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.kitchen.service.KitchenBService;
import com.kitchen.utils.UploadFileUtils;

@Controller
@RequestMapping("/kitchenB/*")
public class KitchenBController {
	
	private static final Logger logger = LoggerFactory.getLogger(KitchenBController.class);
	
	@Inject
	private KitchenBService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registGET() throws Exception {
		return "kitchenB/register";
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String RegistPOST(KitchenVO vo, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		vo.setImage(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setThumb_image(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		service.regist(vo);
		System.out.println("@@@ 컨트롤러 : 사업자 주방 등록 완료!");
		String kitchen_name = URLEncoder.encode(vo.getKitchen_name(), "UTF-8");
		return "redirect:/kitchenB/option_register?kitchen_name="+kitchen_name;
	}
	
	// 주방등록 이후 처리 -> 주방옵션 페이지 이동
	@RequestMapping(value = "/option_register", method = RequestMethod.GET)
	public ModelAndView optionRegisterGET(HttpServletRequest request) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		String kitchen_name = request.getParameter("kitchen_name");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("kitchenB/option_register");
		mav.addObject("kitchen_name",kitchen_name);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@"+kitchen_name);
		
		return mav;
	}
	
	@RequestMapping(value = "/option_register", method = RequestMethod.POST)
	public String optionRegisterPOST(KitchenOptionVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("@@@ /option_register 주소 호출");
		logger.info("@@@ 컨트롤러 optionRegisterPOST 호출");
		logger.info("kitchen: " + vo);
		
		service.optionRegist(vo);
		System.out.println("@@@ 컨트롤러 : 옵션 정보 저장완료!(다음페이지로 이동)");
		
		rttr.addFlashAttribute("result", "SUCCSESS");
		
		return "redirect:/kitchenB/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(@RequestParam("user_email") String user_email, Model model) throws Exception {
		logger.info("@@@ 사업자 주방 정보 등록 후 목록페이지 요청(GET)");
		logger.info("@@@ 해당 사업자 등록 주방보기 : " + user_email + " 동작을 처리");
		
		List<KitchenVO> kitchenList = service.list(user_email);
		logger.info("DB 등록정보 가져오기 성공!!!");
		logger.info("등록 정보" + kitchenList);
		
		model.addAttribute("kitchenList", kitchenList);
	}
	
	@RequestMapping(value="/kitchen_detail", method = RequestMethod.GET)
	public void kitchenDetailGET(@RequestParam("kitchen_name") String kitchen_name, Model model) throws Exception {
		System.out.println("@@@ /kitchenDetail 주소 호출");
		System.out.println("@@@ 주방 정보 디테일 보기" + kitchen_name + "동작을 처리");
		
		KitchenVO kitchenVO = service.detail(kitchen_name);
		System.out.println("@@@ 서비스 계층 호출 완료");
		System.out.println("kitchenVO : " + kitchenVO);
		
		model.addAttribute("kitchenVO", kitchenVO);
	}
	
	// 글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePost(@RequestParam("kitchen_name") String kitchen_name) {
		System.out.println("@@@ /delete(post) 주소 실행");
		System.out.println("@@@ 삭제할 주방이름: " + kitchen_name);
		
		try {
			service.removeKitchen(kitchen_name);
			
			System.out.println("@@@ 주방 삭제 완료!(컨트롤러)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/kitchenB/list";
	}
	
	@RequestMapping(value = "/businessMain", method = RequestMethod.GET)
	public void businessMainGET(@ModelAttribute("businessMain") String businessMain, Model model) throws Exception {
		logger.info(" 글쓰기 완료후 글 목록페이지 요청(GET) ");
		logger.info("businessMain "+businessMain);

		// 게시판 디비에 있는 정보를 가져와서 출력(뷰페이지로 전달)
		// 서비스 계층에 있는 메서드 호출
		/*
		 * News<KitchenVO> kitchenNews = service.News(); logger.info("DB 글정보 가져오기 성공!!!");
		 * logger.info("글 정보 : " + kitchenNews);
		 * 
		 * model.addAttribute("kitchenNews", kitchenNews);
		 */
		
		
	}
	
	
	
	
	
}
