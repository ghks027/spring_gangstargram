package com.ganghwan.gangstargram.post.comment.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {

	public int insertComment(
			@Param("postId") int postId,
			@Param("userId") int userId,
			@Param("userLoginId") String userLoginId,
			@Param("content") String content
			);
}
