package com.ganghwan.gangstargram.post.model;

import java.util.List;

import com.ganghwan.gangstargram.post.comment.model.Comment;

public class PostDetail {

	// 포스트, 댓글, 좋아요
	private Post post;
	private List<Comment> commentList;
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
