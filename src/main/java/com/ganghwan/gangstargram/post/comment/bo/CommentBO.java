package com.ganghwan.gangstargram.post.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganghwan.gangstargram.post.comment.dao.CommentDAO;
import com.ganghwan.gangstargram.post.comment.model.Comment;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;

	// 댓글 작성
	public int addComment(int postId, int userId, String userLoginId, String content) {
		return commentDAO.insertComment(postId, userId, userLoginId, content);
	}
	
	// postId 러 댓글 리스트 가져오기
	public List<Comment> getCommentList(int postId) {
		return commentDAO.selectCommentList(postId);
	}
}
