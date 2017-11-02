<%@	page import="com.socks.member.vo.Member"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css?version=3" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="login_success">
	${sessionScope.loginMember.name }님 환영합니다.
	
	<p>
		<a href="${initParam.rootPath }/main/showMain">메인으로 이동하기</a>
		<a href="/socksShopping/member/MemberMyPage.jsp">마이페이지</a>
	</p>
	<p>
		<a href="/socksShopping/logoutMember">로그아웃</a>
	</p>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>