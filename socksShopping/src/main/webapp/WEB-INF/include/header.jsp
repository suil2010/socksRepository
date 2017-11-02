<%@ page contentType="text/html;charset=utf-8"%>
<div class="wrap">
	<header>
		<div class="logo">
<<<<<<< HEAD
			<a href="${initParam.rootPath }/main/mainPage.jsp"> 
				<img alt="main_logo" src="../img/logo.png"> <!-- 로고 이미지 주소 -->
			</a>
		</div>
		<div class="top_box">
			<% if(false) { %> <!-- 로그인이 되면 -->
			<a href="#">로그아웃</a> &nbsp; | &nbsp; <!-- 로그아웃 페이지로 이동 -->
			<a href="#">마이 페이지</a> &nbsp; | &nbsp;
			<a href="#">장바구니</a>
			<% } else { %> <!-- 로그인이 안됬으면 -->
			<a href="#">로그인</a> &nbsp; | &nbsp; <!-- 로그인 페이지로 이동 -->
			<a href="#">회원 가입</a>
			<% } %>
		</div>
	</header>
=======
			<a href="${initParam.rootPath }/main/showMain"> 
				<img alt="main_logo" src="${initParam.rootPath }/img/logo.png"> <!-- 로고 이미지 주소 -->
			</a>
		</div>
		<div class="top_box">
			<% if(session.getAttribute("loginMember") == null) { %>  <!-- 로그인이 안됬으면 -->
			<a href="${initParam.rootPath }/member/loginView.jsp">로그인</a> &nbsp; | &nbsp; <!-- 로그인 페이지로 이동 -->
			<a href="${initParam.rootPath }/member/registerMemberView.jsp">회원 가입</a>
			<% } else { %><!-- 로그인이 되면 -->
			<a href="${initParam.rootPath }/logoutMember">로그아웃</a> &nbsp; | &nbsp; <!-- 로그아웃 페이지로 이동 -->
			<a href="#">마이 페이지</a>
			<% } %>
		</div>
	</header>
	<div class="header_empty"></div>
>>>>>>> branch 'master' of https://github.com/suil2010/socksRepository.git
	<div class="empty"></div>