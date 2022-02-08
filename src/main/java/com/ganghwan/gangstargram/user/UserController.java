package com.ganghwan.gangstargram.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

	// 회원가입
	@GetMapping("/signup_view")
	public String signupView() {
		return "user/signUp";
	}
	
	// 로그인
	@GetMapping("/signin_view")
	public String singinView() {
		return "user/signIn";
	}
	
	// 로그아웃
	@GetMapping("/signout_view")
	public String signoutView(
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		return "redirect:/user/signin_view";
	}
}
