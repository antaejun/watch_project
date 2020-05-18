package com.kitchen.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kitchen.domain.UserVO;
import com.kitchen.service.UserService;
import com.kitchen.domain.Myinfo;

@Controller
@RequestMapping("/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(RentalController.class);
	@Inject
	UserService service;

	@GetMapping("/mainRegister")
	public void mainRegister() {

	}

	// 회원 가입 get
	@RequestMapping(value = "/ownerRegister", method = RequestMethod.GET)
	public void getOwerRegister() {
		System.out.println("owner get register");
	}

	// 회원 가입 post
	@RequestMapping(value = "/ownerRegister", method = RequestMethod.POST)
	public String postOwnerRegister(UserVO vo) throws Exception {

		System.out.println(" owner post register");

		service.register(vo);

		return "/user/login";
	}

	// 회원 가입 get
	@RequestMapping(value = "/userRegister", method = RequestMethod.GET)
	public void getUserRegister() {
		System.out.println("user get register");
	}

	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public String postUserRegister(UserVO vo) throws Exception {

		System.out.println(" owner post register");

		service.register(vo);

		return "/user/login";
	}
	
	

	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void getLogin() {

		// return "redirect:/user/mainPage";
	}

	// 로그인 처리 후 메인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		String returnUrl = "";
		System.out.println("post login");

		HttpSession session = req.getSession();
		UserVO login = service.login(vo);

		System.out.println("이거 나오면 서비스 오케이");

		if (login == null) {
			// 로그인 실패시
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
			returnUrl = "redirect:/user/login";
		} else {
			// 로그인 성공시 페이지 이동
			session.setAttribute("user", login);
			returnUrl = "redirect:http://localhost:8088/controller/";
		}

		return returnUrl;
	}

	// 메이 페이지 이동
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void mainPage() {

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		System.out.println("이거 나오면 logout");
		session.invalidate();

		return "redirect:/user/login";
	}
	
	// 유저정보
	@RequestMapping(value = "/userinfo", method=RequestMethod.GET)
	public void infoGET() throws Exception{
		logger.info("@@@@ /userinfo 주소 호출");
	}
	
	@RequestMapping(value="/userinfo", method=RequestMethod.POST)
	public String infoPOST(Myinfo minfo, 
			Model model)throws Exception{
		
		UserVO user = service.getInfo(minfo);
		System.out.println("@@@@컨트롤러 : 유저 정보 가져오기 완료! 다음 페이지로");
		
		//rttr.addAttribute("user" , user);
		model.addAttribute("user",user);
		
		return "user/myInfo";
	}
	//내정보
	@RequestMapping(value="/myInfo", method=RequestMethod.GET)
	public void myInfoGET(@ModelAttribute UserVO user, Model model) throws Exception{
		
	}
	//유저삭제
	@RequestMapping(value="/userdelete", method=RequestMethod.POST)
	public String deleteUser(@RequestParam("idx") Integer idx) {
		
		System.out.println("@@@ /delete(post) exe@@@@");
		
		System.out.println("@@@ 탈퇴하는 회원 번호 : " + idx);
		
		try {
			service.deleteUser(idx);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/userinfo";
	}
	
	@RequestMapping(value="/modiform", method=RequestMethod.POST)
	public String modiUser(Myinfo minfo, Model model) throws Exception{
		
		System.out.println("@@@회원 정보 수정 폼@@@");
		
		UserVO user = service.getInfo(minfo);
		System.out.println("user : " +user);
		model.addAttribute("user", user);
		
		return "user/modiform";
		
	}
	
	/*@RequestMapping(value="/modiform", method=RequestMethod.GET)
	public void modiUserGET(@ModelAttribute UserVO user, Model model) throws Exception{
	}*/
	
	@RequestMapping(value="/modiaction", method=RequestMethod.POST)
	public String modiUserAction(UserVO user) throws Exception {
		
		System.out.println("@@@ 회원 정보 수정 액션 @@@");
		
		System.out.println("@@@ 수정 할 정보 : " +user);
		
		service.modifyUser(user);
		
		return "redirect:/user/userinfo";
	}
	
	@RequestMapping(value="/pwmodify", method=RequestMethod.POST)
	public String passModi(@RequestParam("idx") Integer idx) {
		
		System.out.println("수정 할 회원 : " + idx);
		
		return "/user/pwmodify";
	}
	
	@RequestMapping(value="/pwmodiAction", method=RequestMethod.POST)
	public String pwModi(Myinfo minfo) {
		
		try {
			service.pwmodi(minfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@@@Con 비번 수정 완료");
		
		return "redirect:/user/userinfo";
	}

}
