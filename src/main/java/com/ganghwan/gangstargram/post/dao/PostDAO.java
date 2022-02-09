package com.ganghwan.gangstargram.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ganghwan.gangstargram.post.model.Post;

@Repository
public interface PostDAO {

	// 게시글 작성
	public int insertPost(
			@Param("userId") int userId,
			@Param("userName") String userName,
			@Param("content") String content,
			@Param("image") String image
			);
	
	// 게시글 보기
	public List<Post> selectPostList(
			@Param("userId") int userId
			);
}
