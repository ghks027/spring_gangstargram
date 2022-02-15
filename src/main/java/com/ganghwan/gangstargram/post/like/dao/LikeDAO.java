package com.ganghwan.gangstargram.post.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	// 좋아요 기능
	public int insertLike(
			@Param("postId") int postId,
			@Param("userId") int userId);
}
