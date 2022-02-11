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
			@Param("userLoginId") String userLoginId,
			@Param("content") String content,
			@Param("image") String image
			);
	
	// 게시글 보기
	public List<Post> selectPostList(
			@Param("userId") int userId
			);
	
	// 게시글 삭제
	public int deletePost(
			@Param("postId") int postId
			);
	
	// 파일 삭제
	public Post selectPost(
			@Param("postId") int postId
			);
}
