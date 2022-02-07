package com.ganghwan.gangstargram.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {

	// 게시글
	@GetMapping("/timeline")
	public String timeline() {
		return "post/timeline";
	}
}
