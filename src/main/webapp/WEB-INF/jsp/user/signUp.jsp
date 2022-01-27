<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gangstargram 회원가입</title>

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
			<div class = "join my-5">
				<h2 class = "text-center"><b>회원가입</b></h2>
				
				<div class = "d-flex">
					<input type = "text" class = "form-control mt-5" placeholder = "Username" id = "loginIdInput">
					<button type = "button" id = "duplicateBtn" class = "btn btn-primary mt-5 ml-3">중복확인</button>
				</div>
				
				<div id = "duplicateId" class = "text-danger mt-1 d-none">중복된 아이디 입니다</div>
				<div id = "noneDuplicateId" class = "text-success mt-1 d-none">사용 가능한 아이디 입니다</div>
				
				<input type = "password" class = "form-control mt-3" placeholder = "Password" id = "passwordInput">
				<input type = "password" class = "form-control mt-3" placeholder = "비밀번호 확인" id = "passwordConflimInput">
				<input type = "text" class = "form-control mt-3" placeholder = "이름" id = "nameInput">
				<input type = "text" class = "form-control mt-3" placeholder = "이메일 주소" id = "emailInput">
				
				<button type = "button" id = "joinBtn" class = "btn btn-primary btn-block mt-3">가입하기</button>
			</div>
		</section>
		
		<c:import url = "/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	
	<script>
		$(document).ready(function() {
			
			// 회원가입
			$("#joinBtn").on("click", function() {
				var loginId = $("#loginIdInput").val();
				var password = $("#passwordInput").val();
				var passwordConflim = $("#passwordConflimInput").val();
				var name = $("#nameInput").val();
				var email = $("#emailInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력하세요");
					return;
				}
				
				if(password == "") {
					alert("비밀번호를 입력하세요");
					return;
				}
				
				if(passwordConflim == "") {
					alert("비밀번호가 일치하지 않습니다");
					return;
				}
				
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				
				if(email == "") {
					alert("이메일 주소를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/user/sign_up",
					data:{"loginId":loginId, "password":password, "name":name, "email":email},
					success:function(data) {
						if(data.result == "success") {
							location.href = "/user/signin_view";
						} else {
							alert("회원가입 실패");
						}
					},
					error:function() {
						alert("에러 발생");
					}
				});
			});
			
			// 중복확인
			$("#duplicateBtn").on("click", function() {
				var loginId = $("#loginIdInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/user/is_duplicate_id",
					data:{"loginId":loginId},
					success:function(data) {
						if(data.isDuplicate == "true") {
					 		$("#duplicateId").removeClass("d-none");
							$("#noneDuplicateId").addClass("d-none"); 
							isDuplicateId = true;
						} else {
							$("#noneDuplicateId").removeClass("d-none");
							$("#duplicateId").addClass("d-none"); 
							isDuplicateId = false;
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