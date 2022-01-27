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
		<header class = "bg-white"></header>
	
		<section class = "content d-flex justify-content-center">
			<div class = "join my-5">
			<form id = "loginForm">
				<h2 class = "text-center">Gangstargram</h2>
				<input type = "text" class = "form-control mt-5" placeholder = "Username" id = "loginIdInput">
				<input type = "password" class = "form-control mt-3" placeholder = "Password" id = "passwordInput">
				<button type = "submit" class = "btn btn-primary btn-block mt-3">로그인</button>
				
				<hr>
			</form>
				
				<a href = "/user/signup_view"></a>
				
				<button type = "button" class = "btn btn-secondary btn-block mt-3">회원가입</button>
			</div>
		</section>
		
		<c:import url = "/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	
	<script>
		$(document).ready(function() {
			
			// 로그인
			$("#loginForm").on("submit", function(e) {
				e.preventDefault();
				
				var loginId = $("#loginIdInput").val();
				var password = $("#passwordInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력하세요");
					return;
				}
				
				if(password == "") {
					alert("비밀번호를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/user/sign_in",
					data:{"loginId":loginId, "password":password},
					success:function(data) {
						if(data.result == "success") {
							location.href = "/post/list_view";
						} else {
							alert("아이디/비밀번호를 확인하세요");
						}
					},
					error:function() {
						alert("에러 발생");
					}
				});
			});
			
			// 회원가입
			$("#joinBtn").on("click", function() {
				
			});
		});,
	</script>
</body>
</html>