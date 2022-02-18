package com.ganghwan.gangstargram.post.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ganghwan.gangstargram.post.comment.model.Comment;
import com.ganghwan.gangstargram.post.model.Post;

@Repository
public interface CommentDAO {

	// 댓글 작성
	public int insertComment(
			@Param("postId") int postId,
			@Param("userId") int userId,
			@Param("userLoginId") String userLoginId,
			@Param("content") String content
			);
	
	// 댓글 불러오기
	public List<Comment> selectCommentList(
			@Param("postId") int postId
			);
	
	// 게시글 삭제시 댓글 삭제
	public int deleteCommentByPostId(
			@Param("postId") int postId
			);
	
	// 댓글 삭제
	public int deleteComment(
			@Param("commentId") int commentId
			);
	
			/*
			 * public Post selectComment(
			 * 
			 * @Param("commentId") int commentId );
			 */
}
