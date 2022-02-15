package com.ganghwan.gangstargram.post.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ganghwan.gangstargram.post.comment.model.Comment;

@Repository
public interface CommentDAO {

	// 댓글 작성
	public int insertComment(
			@Param("postId") int postId,
			@Param("userId") int userId,
			@Param("userLoginId") String userLoginId,
			@Param("content") String content
			);
	
	public List<Comment> selectCommentList(
			@Param("postId") int postId
			);
}
