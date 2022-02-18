package com.ganghwan.gangstargram.post.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganghwan.gangstargram.post.comment.dao.CommentDAO;
import com.ganghwan.gangstargram.post.comment.model.Comment;
import com.ganghwan.gangstargram.post.model.Post;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;

	// 댓글 작성
	public int addComment(int postId, int userId, String userLoginId, String content) {
		return commentDAO.insertComment(postId, userId, userLoginId, content);
	}
	
	// postId 로 댓글 리스트 가져오기
	public List<Comment> getCommentList(int postId) {
		return commentDAO.selectCommentList(postId);
	}
	
	// 게시글 삭제시 댓글 삭제
	public int deleteCommentByPostId(int postId) {
		return commentDAO.deleteCommentByPostId(postId);
	}
	
	// 댓글 삭제
	public int deleteComment(int commentId, int userId) {
		
		/*
		 * Post comment = commentDAO.selectComment(commentId);
		 * 
		 * // 본인 댓글만 삭제 if(comment.getUserId() != userId) { return 0; }
		 */
		
		return commentDAO.deleteComment(commentId);
	}
}
