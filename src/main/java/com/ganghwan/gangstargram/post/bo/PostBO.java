package com.ganghwan.gangstargram.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ganghwan.gangstargram.common.FileManagerService;
import com.ganghwan.gangstargram.post.comment.bo.CommentBO;
import com.ganghwan.gangstargram.post.comment.model.Comment;
import com.ganghwan.gangstargram.post.dao.PostDAO;
import com.ganghwan.gangstargram.post.like.bo.LikeBO;
import com.ganghwan.gangstargram.post.model.Post;
import com.ganghwan.gangstargram.post.model.PostDetail;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;

	// 게시글 작성
	public int addPost(int userId, String userLoginId, String content, MultipartFile file) {
		
		String filePath = FileManagerService.saveFile(userId, file);
		
		return postDAO.insertPost(userId, userLoginId, content, filePath);
	}
	
	// 게시글 보기
	public List<PostDetail> getPostList(int userId) {
		// post 리스트 가져오기
		// post 대응하는 댓글 좋아요 가져오기
		// post 대응하는 댓글 좋아요 데이터 구조 만들기
		
		List<Post> postList = postDAO.selectPostList();
		
		List<PostDetail> postDetailList = new ArrayList<>();
		
		for(Post post:postList) {
			// 해당하는 postId 로 댓글 가져오기
			List<Comment> commentList = commentBO.getCommentList(post.getId());
			
			// 좋아요 개수
			int likeCount = likeBO.getLikeCount(post.getId());
			
			// 좋아요 여부 확인
			boolean isLike = likeBO.isLike(post.getId(), userId);
			
			// 댓글
			PostDetail postDetail = new PostDetail();
			postDetail.setPost(post);
			postDetail.setCommentList(commentList);
			// 좋아요 개수
			postDetail.setLikeCount(likeCount);
			// 좋아요 여부
			postDetail.setLike(isLike);
			
			postDetailList.add(postDetail);
		}
		
		return postDetailList;
	}
	
	// 게시글 삭제
	public int deletePost(int postId) {
		
		// 파일 삭제
		Post post = postDAO.selectPost(postId);
		FileManagerService.removeFile(post.getImage());
		
		// 댓글, 좋아요 삭제
		commentBO.deleteComment(postId);
		likeBO.deleteLikeByPostId(postId);
		
		// 게시글 삭제
		return postDAO.deletePost(postId);
	}
}