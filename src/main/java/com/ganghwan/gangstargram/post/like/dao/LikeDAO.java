package com.ganghwan.gangstargram.post.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	// 좋아요 기능
	public int insertLike(
			@Param("postId") int postId,
			@Param("userId") int userId
			);
	
	// 좋아요 취소 기능
	public int deleteLike(
			@Param("postId") int postId,
			@Param("userId") int userId
			);
	
	// 좋아요 불러오기
	public int selectLikeCount(
			@Param("postId") int postId
			);
	
	// 좋아요 여부 확인
	public int selectLikeCountByUserId(
			@Param("postId") int postId,
			@Param("userId") int userId
			);
	
	// 좋아요 삭제
	public int deleteLikeByPostId(
			@Param("postId") int postId
			);
}
