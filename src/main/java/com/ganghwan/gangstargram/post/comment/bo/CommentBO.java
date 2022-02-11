package com.ganghwan.gangstargram.post.comment.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganghwan.gangstargram.post.comment.dao.CommentDAO;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;

	public int addComment(int postId, int userId, String userLoginId, String content) {
		return commentDAO.insertComment(postId, userId, userLoginId, content);
	}
}
