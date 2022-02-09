<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

</head>
<body>
	<div id = "warp">
		<c:import url = "/WEB-INF/jsp/include/header.jsp"/>
		
		<section class = "content d-flex justify-content-center">
			<div class = "join-box my-5">
				<div class = "create-box">
					<textarea class = "form-control text-secondary" rows="3" id = "contentInput" placeholder = "내용을 입력하세요"></textarea>
					
					<div class = "d-flex justify-content-between mt-1">
						<input type = "file" id = "fileInput">
						<button type = "button" class = "btn btn-primary btn-sm" id = "saveBtn">게시</button>
					</div>
				</div>
				
				<div class = "post-box">
					<div class = "postDetail mt-3 d-flex justify-content-between d-flex align-items-center">
						<b class = "ml-3">ganghwan</b>
						<button type = "button" class = "btn btn-danger btn-sm" id = "delelteBtn">삭제</button>
					</div>
					
					<div class = "d-flex justify-content-center">
						<img class = "mt-2" width = "500" src = "#">
					</div>
					
					<div class = "form-control mt-3" rows="3">오호</div>
					
					<div class = "postDetail mt-2 d-flex align-items-center">
						<div class = "ml-3">댓글</div>
					</div>
					
					
				</div>
			</div>
		</section>
		
		<c:import url = "/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	
	<script>
	$(document).ready(function() {
		$("#saveBtn").on("click", function() {
			let content = $("#contentInput").val().trim();
			let file = $("#fileInput").val();
			
			if(content == "") {
				alert("내용을 입력하세요");
				return;
			}
			
			if(file == "") {
				alert("파일을 선책하세요");
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
	});
	</script>
</body>
</html>