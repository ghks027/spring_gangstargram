package com.ganghwan.gangstargram.post.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ganghwan.gangstargram.post.dao.PostDAO;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;

	public int addPost(int userId, String content, MultipartFile file) {
		return postDAO.insertPost(userId, content, null);
	}
}