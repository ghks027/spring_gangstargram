package com.ganghwan.gangstargram.post.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganghwan.gangstargram.post.comment.bo.CommentBO;

@RestController
@RequestMapping("/post/comment")
public class CommentRestController {

	@Autowired
	private CommentBO commentBO;
	
	// 댓글 작성
	@PostMapping("/create")
	public Map<String, String> create(
			@RequestParam("postId") int postId,
			@RequestParam("content") String content,
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		int count = commentBO.addComment(postId, userId, userLoginId, content);
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	// 댓글 삭제
	@GetMapping("/delete")
	public Map<String, String> delete(
			@RequestParam("commentId") int commentId,
			HttpServletRequest request
			) {
		
		// 본인 댓글만 삭제
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		int count = commentBO.deleteComment(commentId, userId);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
