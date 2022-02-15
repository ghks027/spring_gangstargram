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
import com.ganghwan.gangstargram.post.model.Post;
import com.ganghwan.gangstargram.post.model.PostDetail;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private CommentBO commentBO;

	// 게시글 작성
	public int addPost(int userId, String userLoginId, String content, MultipartFile file) {
		
		String filePath = FileManagerService.saveFile(userId, file);
		
		return postDAO.insertPost(userId, userLoginId, content, filePath);
	}
	
	// 게시글 보기
	public List<PostDetail> getPostList() {
		// post 리스트 가져오기
		// post 대응하는 댓글 좋아요 가져오기
		// post 대응하는 댓글 좋아요 데이터 구조 만들기
		
		List<Post> postList = postDAO.selectPostList();
		
		List<PostDetail> postDetailList = new ArrayList<>();
		
		for(Post post:postList) {
			// 해당하는 post id 로 댓글 가져오기
			List<Comment> commentList = commentBO.getCommentList(post.getId());
			
			PostDetail postDetail = new PostDetail();
			postDetail.setPost(post);
			postDetail.setCommentList(commentList);
			
			postDetailList.add(postDetail);
		}
		
		return postDetailList;
	}
	
	// 게시글 삭제
	public int deletePost(int postId) {
		
		// 파일 삭제
		Post post = postDAO.selectPost(postId);
		FileManagerService.removeFile(post.getImage());
		
		return postDAO.deletePost(postId);
	}
}