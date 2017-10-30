<%@ page contentType="text/html;charset=utf-8"%>
<div class="wrap">
	<header>
		<div class="logo">
			<a href="#"> 
				<img alt="main_logo" src="../img/logo.png"> <!-- 로고 이미지 주소 -->
			</a>
		</div>
		<div class="top_box">
			<% if(true) { %> <!-- 로그인이 되면 -->
			<a href="#">로그아웃</a> &nbsp; | &nbsp; <!-- 로그아웃 페이지로 이동 -->
			<a href="#">마이 페이지</a> &nbsp; | &nbsp;
			<a href="#">장바구니</a>
			<% } else { %> <!-- 로그인이 안됬으면 -->
			<a href="#">로그인</a> &nbsp; | &nbsp; <!-- 로그인 페이지로 이동 -->
			<a href="#">회원 가입</a>
			<% } %>
		</div>
	</header>
	<div class="empty"></div>