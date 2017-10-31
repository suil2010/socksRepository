<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty requestScope.errorMessage }">
	<span style="color:red">${requestScope.errorMessage }</span>
</c:if>
<form action="/socksShopping/loginMember" method="post">
		ID : <input type="text" name="id"><br>
		Password : <input type="password" name="password"><br>
		<button type="submit">로그인</button>
</form>
<a href="">회원가입하기</a>
</body>
</html>