<%@page import="com.socks.member.vo.Member"%>
<%@ page contentType="text/html;charset=utf-8"%>
<div class="wrap">
	<header>
		<div class="logo">
			<a href="${initParam.rootPath }/main/showMain"> 
				<img alt="main_logo" src="${initParam.rootPath }/img/logo.png"> <!-- 로고 이미지 주소 -->
			</a>
		</div>
		<div class="top_box">
			<%-- 관리자 페이지 일 때 관리자 페이지로 이동 좀 부탁드립니당. --%>
			<%-- <% if(session.getAttribute("loginMember") == "socks") {%> <!-- 관리자 페이지 -->
			<a href="${initParam.rootPath }/logoutMember">로그아웃</a> &nbsp; | &nbsp; <!-- 로그아웃 페이지로 이동 -->
			<a href="${initParam.rootPath }/member/MemberMyPage.jsp">마이 페이지</a> &nbsp; | &nbsp;
			<a href="${initPraam.rootPath }/item/managerView.jsp">관리지 페이지</a>  --%>
			
			<% if(session.getAttribute("loginMember") == null) { %><!-- 로그인이 되면 -->
			<a href="${initParam.rootPath }/member/loginView.jsp">로그인</a> &nbsp; | &nbsp; <!-- 로그인 페이지로 이동 -->
			<a href="${initParam.rootPath }/member/registerMemberView.jsp">회원 가입</a>
			<% } else { %><!-- 로그인이 되면 -->
			<% if(session.getAttribute("loginMember").equals("socks")) { %>
			<a href="${initParam.rootPath }/logoutMember">로그아웃</a> &nbsp; | &nbsp; <!-- 로그아웃 페이지로 이동 -->
			<a onmouseover="this.style.color='blue'" onmouseout="this.style.color='red'" style="color: red;" href="${initParam.rootPath }/item/managerView.jsp">관리자 페이지</a>
			<% } else { %>
			<a href="${initParam.rootPath }/logoutMember">로그아웃</a> &nbsp; | &nbsp; <!-- 로그아웃 페이지로 이동 -->
			<a href="${initParam.rootPath }/member/MemberMyPage.jsp">마이 페이지</a>
			<% } %>
			<% } %>
		</div>
	</header>
	<div class="header_empty"></div>
	<div class="empty"></div>