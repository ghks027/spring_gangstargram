package com.ganghwan.gangstargram.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ganghwan.gangstargram.common.FileManagerService;
import com.ganghwan.gangstargram.post.dao.PostDAO;
import com.ganghwan.gangstargram.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;

	// 게시글 작성
	public int addPost(int userId, String userLoginId, String content, MultipartFile file) {
		
		String filePath = FileManagerService.saveFile(userId, file);
		
		return postDAO.insertPost(userId, userLoginId, content, filePath);
	}
	
	// 게시글 보기
	public List<Post> getPostList() {
		return postDAO.selectPostList();
	}
	
	// 게시글 삭제
	public int deletePost(int postId) {
		
		// 파일 삭제
		Post post = postDAO.selectPost(postId);
		FileManagerService.removeFile(post.getImage());
		
		return postDAO.deletePost(postId);
	}
}