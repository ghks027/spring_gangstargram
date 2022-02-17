package com.ganghwan.gangstargram.post;

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
import org.springframework.web.multipart.MultipartFile;

import com.ganghwan.gangstargram.post.bo.PostBO;

// 명령만 수행
// model 사용 안함
@RestController
@RequestMapping("/post")
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	// 게시글 작성
	@PostMapping("/create")
	public Map<String, String> create(
			@RequestParam("content") String content,
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request
			) {
		
		HttpSession session = request.getSession();
		
		int userId = (Integer)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		int count = postBO.addPost(userId, userLoginId, content, file);

		Map<String, String> result = new HashMap<>();

		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}

		return result;
	}
	
	// 게시글 삭제
	@GetMapping("/delete")
	public Map<String, String> delete(
			@RequestParam("postId") int postId
			) {
		
		int count = postBO.deletePost(postId);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) { // postId 를 기반으로 삭제하기 때문에 1 이어야 한다.
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
