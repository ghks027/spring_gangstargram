package com.ganghwan.gangstargram.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ganghwan.gangstargram.post.bo.PostBO;
import com.ganghwan.gangstargram.post.model.PostDetail;

// 결과를 jsp에 전달
// model 활용
@RequestMapping("/post")
@Controller
public class PostController {

	@Autowired
	private PostBO postBO;
	
	// 게시글
	@GetMapping("/timeline")
	public String timeline(
			Model model
			) {
		
		List<PostDetail> postlist = postBO.getPostList();
		model.addAttribute("postList", postlist);
		
		return "post/timeline";
	}
}
