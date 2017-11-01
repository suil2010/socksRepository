<%@page import="com.socks.member.vo.Member"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${sessionScope.loginMember.name }님 환영합니다.

<p>
	<a href="main/mainPage.jsp">메인으로 이동하기</a>
	<a href="/myPage.jsp">마이페이지</a>
</p>
<p>
	<a href="/socksShopping/main/mainPage.jsp">로그아웃</a>
</p>
</body>
</html>