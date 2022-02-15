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
	
	// 좋아요 불러오기
	public int getLikeCount(int postId) {
		return likeDAO.selectLikeCount(postId);
	}
	
	// postId 와 userId 로 좋아요 여부 확인
	// ~인지 아닌지 - is
	public boolean isLike(int postId, int userId) {
		int count = likeDAO.selectLikeCountByUserId(postId, userId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
		
//		return !(count == 0);
		
//		return !(likeDAO.selectLikeCountByUserId(postId, userId) == 0);
	}
}
