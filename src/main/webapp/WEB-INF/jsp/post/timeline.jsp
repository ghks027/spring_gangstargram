<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gangstargram</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>
	<div id = "warp">
		<c:import url = "/WEB-INF/jsp/include/header.jsp"/>
		
		<section class = "content d-flex justify-content-center">
			<div class = "timeline my-3">
				
				<!-- 게시물 작성 -->
				<div class = "create-box form-control">
					<textarea style = "border:none; resize:none" class = "form-control text-secondary" rows="2" id = "contentInput" placeholder = "내용을 입력하세요"></textarea>
						
					<div class = "d-flex justify-content-between my-1">
					
						<!-- icon - 글자처럼 취급 -->
						<span class = "img-icon"><i class="bi bi-image" id = "imageBtn"></i></span>
						<input type = "file" id = "fileInput" class = "d-none">
							
						<button type = "button" class = "btn btn-primary btn-sm" id = "saveBtn">게시</button>
					</div>
				</div>
				
				<!-- 게시글 보기 -->
				<c:forEach var = "postDetail" items = "${postList }">
				
					<div class = "post-box mt-3 border rounded">
						<div class = "postDetail d-flex justify-content-between align-items-center">
							<b class = "ml-3">${postDetail.post.userLoginId }</b>
							
							<!-- 삭제 기능 -->
							<div class="more-icon mr-1">
								<a class="text-dark moreBtn" data-post-id = "${postDetail.post.id }" href="#" data-toggle="modal" data-target="#exampleModalCenter"> 
									<i class="bi bi-three-dots-vertical"></i>
								</a>
							</div>
							
						</div>
							
						<div class = "d-flex justify-content-center"><img class = "mt-1 w-100 imageClick" src = "${postDetail.post.image} "></div>
						
						<hr>
						
						<!-- 좋아요 기능 -->
						<div class = "ml-2" >
								
							<a href = "#" class = "likeBtn text-dark" data-post-id = "${postDetail.post.id }">
								<c:choose>
									<c:when test = "${postDetail.like }">
											<i class="bi bi-heart-fill text-danger"></i>
									</c:when>
								
									<c:otherwise>
											<i class="bi bi-heart"></i>
									</c:otherwise>
								</c:choose>
								
								<b style = "font-size:small">좋아요 ${postDetail.likeCount }개</b>
							</a>
								
					<%-- 			<c:choose>
									<c:when test = "${postDetail.like }">
										<a href = "#" class = "unlikeBtn" data-post-id = "${postDetail.post.id }">
											<i class="bi bi-heart-fill text-danger"></i>
										</a>
									</c:when>
								
									<c:otherwise>
										<a href = "#" class = "likeBtn text-dark" data-post-id = "${postDetail.post.id }">
											<i class="bi bi-heart"></i>
										</a>
									</c:otherwise>
								</c:choose> --%>

						</div>	
						
						<div style = "border:none" class = "form-control">${postDetail.post.content }</div>
						
						<!-- 댓글 기능 -->
						<div class = "postDetail d-flex align-items-center"><b class = "ml-3">댓글</b></div>
						<div style = "border:none" class = "form-control mt-1">
						
						<!-- 댓글 보이기 -->
						<c:forEach var = "comment" items = "${postDetail.commentList }">
							<div class = "d-flex justify-content-between">
								<div style = "font-size:small"><b class = "text-dark">${comment.userLoginId }</b> - ${comment.content }</div>
								
						<!-- 댓글 삭제 -->
								<a href="#" class = "text-dark commentDeleteBtn" data-comment-id = "${comment.id }"> 
									<i class="bi bi-three-dots"></i>
								<!-- 	<select name = "comment" class = " d-none">
										<option value="취소" selected="selected">취소</option>
										<option value="댓글 삭제">삭제</option>
									</select> -->
								</a>
							</div>
						</c:forEach>
						
						</div>
						<div class = "d-flex form-control">
							<input  style = "border:none;" type = "text" class = "form-control broder-0 bin mr-2" id = "commentInput${postDetail.post.id }" placeholder = "댓글을 입력하세요">
							<button type = "button" class = "btn btn-primary btn-sm commentBtn" data-post-id = "${postDetail.post.id }">등록</button>
						</div>
					</div>
					
				</c:forEach>
				
			</div>
		</section>
		
		<c:import url = "/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	
	<!-- 게시글 삭제 Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	    
	      <div class="modal-body text-center">
	      	<button class = "btn form-control" type="button" id = "deleteBtn">삭제하기</button>
        	
        	<hr>
        	
	      	<button class = "btn form-control" type="button" data-dismiss="modal">취소</button>
	      </div>
	      
	    </div>
	  </div>
	</div>
	
	<script>
	$(document).ready(function() {
		
		// 이미지 파일 클릭 효과
		$("#imageBtn").on("click", function() {
			$("#fileInput").click();
		});
		
		// 게시글 작성
		$("#saveBtn").on("click", function() {
			let content = $("#contentInput").val().trim();
			let file = $("#fileInput").val();
			
			if(content == "") {
				alert("내용을 입력하세요");
				return;
			}
			
			// 파일 유효성 검사
			if($("#fileInput")[0].files.length == 0) {
				alert("파일을 선택하세요");
				return;
			}
			
			var formData = new FormData();
			formData.append("content", content);
			formData.append("file", $("#fileInput")[0].files[0]);
			
			$.ajax({
				type:"post",
				url:"/post/create",
				data:formData,
				// 파일 업로드 필수
				enctype:"multipart/form-data",
				processData:false,
				contentType:false,
				success:function(data) {
					if(data.result == "success") {
						location.href = "/post/timeline";
					} else {
						alert("작성 실패");
					}
				},
				error:function() {
					alert("에러 발생");
				}
			});
		});
		
		// 댓글 작성
		$(".commentBtn").on("click", function() {
			
			let postId = $(this).data("post-id");
			
			// "#commentInput5"
			let content =  $("#commentInput" + postId).val();
			
			$.ajax({
				type:"post",
				url:"/post/comment/create",
				data:{"postId":postId, "content":content},
				success:function(data) {
					if(data.result == "success") {
						location.reload();
					} else {
						alert("댓글 작성 실패");
					}
				},
				error:function() {
					alert("에러 발생");
				}
				
			});
		});
		
  		// 댓글 삭제 기능
		$(".commentDeleteBtn").on("click", function(e) {
			
			e.preventDefault();
			
			let commentId = $(this).data("comment-id");
			
  			$.ajax({
				type:"get",
				url:"/post/comment/delete",
				data:{"commentId":commentId},
				success:function(data) {
					if(data.result == "success") {
						alert("삭제되었습니다")
						location.reload();
					} else {
						alert("삭제 실패");
					}
				},
				error:function() {
					alert("에러 발생");
				}
			});  
		});
		
		// 좋아요 기능
		$(".likeBtn").on("click", function(e) {
			
			e.preventDefault(); // 고유의 기능을 지움
			
			let postId = $(this).data("post-id");
			
			$.ajax({
				type:"get",
				url:"/post/like",
				data:{"postId":postId},
				success:function(data) {
						location.reload();
				},
				error:function(){
					alert("에러 발생");
				}
			});
		});
		
		// 게시글 삭제
		$(".moreBtn").on("click", function(e) {
			
			e.preventDefault();
			
			let postId = $(this).data("post-id");
			
			// postId 를 modal 의 삭제하기 button 에 값을 부여한다
			$("#deleteBtn").data("post-id", postId);
		});
		
		$("#deleteBtn").on("click", function(e) {
			
			e.preventDefault();
			
			let postId = $(this).data("post-id");
			
			$.ajax({
				type:"get",
				url:"/post/delete",
				data:{"postId":postId},
				success:function(data) {
					if(data.result == "success") {
						location.reload();
					} else {
						alert("삭제 불가");
					}
				},
				error:function(){
					alert("에러 발생");
				}
			});
		});
		
/* 		// 좋아요 취소 기능
		$(".unlikeBtn").on("click", function(e) {
			
			e.preventDefault(); // 고유의 기능을 지움
			
			let postId = $(this).data("post-id");
			
			$.ajax({
				type:"get",
				url:"/post/unlike",
				data:{"postId":postId},
				success:function(data) {
					if(data.result == "success"){
						location.reload();
					} else {
						alert("좋아요 취소 실패");
					}
				},
				error:function() {
					alert("에러 발생");
				}
			});
		}); */
	});
	</script>
</body>
</html>