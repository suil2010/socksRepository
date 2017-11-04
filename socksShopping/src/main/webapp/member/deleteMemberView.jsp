<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>탈퇴하시겠습니까?</h1>
<form action="/socksShopping/member/forwardMember3.jsp" method="post">
<input type="hidden" name="memberId" value="${sessionScope.loginMember.memberId }">
<input type="hidden" name="name" value="${sessionScope.loginMember.name}">
<input type="hidden" name="password" value="${sessionScope.loginMember.password }">
<input type="hidden" name="address" value="${sessionScope.loginMember.address }">
<input type="hidden" name="email" value="${sessionScope.loginMember.email }">
<input type="hidden" name="point" value="${sessionScope.loginMember.point }">
<button type="submit">탈퇴하기</button>
</form>
</body>
</html>