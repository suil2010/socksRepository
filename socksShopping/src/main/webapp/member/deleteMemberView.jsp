<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="del_member">
	<h3>탈퇴 하시겠습니까?</h3>
	<form action="/socksShopping/member/forwardMember3.jsp" method="post">
		<input type="hidden" name="memberId" value="${sessionScope.loginMember.memberId }">
		<input type="hidden" name="name" value="${sessionScope.loginMember.name}">
		<input type="hidden" name="password" value="${sessionScope.loginMember.password }">
		<input type="hidden" name="address" value="${sessionScope.loginMember.address }">
		<input type="hidden" name="email" value="${sessionScope.loginMember.email }">
		<input type="hidden" name="point" value="${sessionScope.loginMember.point }">
		
		<button type="submit" onclick="location.href='/socksShopping/member/memberDeleteSuccess.jsp'">탈퇴하기</button>
		<button type="button" onclick="location.href='/socksShopping/member/MemberMyPage.jsp'">취소하기</button>
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>