package com.ganghwan.gangstargram.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ganghwan.gangstargram.post.bo.PostBO;
import com.ganghwan.gangstargram.post.model.Post;

@RequestMapping("/post")
@Controller
public class PostController {

	@Autowired
	private PostBO postBO;
	
	// 게시글
	@GetMapping("/timeline")
	public String timeline(
			HttpServletRequest request,
			Model model
			) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> postlist = postBO.getPostList(userId);
		model.addAttribute("postList", postlist);
		
		return "post/timeline";
	}
}
