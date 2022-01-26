package com.ganghwan.gangstargram.user;

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
}
