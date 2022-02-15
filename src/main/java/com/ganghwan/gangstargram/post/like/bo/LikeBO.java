package com.ganghwan.gangstargram.post.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganghwan.gangstargram.post.like.dao.LikeDAO;

@Service
public class LikeBO {

	@Autowired
	private LikeDAO likeDAO;
	
	// 좋아요 기능
	public int addLike(int postId, int userId) {
		return likeDAO.insertLike(postId, userId);
	}
}
