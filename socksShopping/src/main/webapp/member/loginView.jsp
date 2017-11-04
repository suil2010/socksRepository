<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="login_view">

	<h4>로그인</h4>
	
	<form action="/socksShopping/loginMember" method="post" class="login_form">
		<table class="login_table">
			<tr>
				<td>
					<input type="text" name="memberId" placeholder="ID" class="login_input"><br>
					<input type="password" name="password" placeholder="PASSWORD" class="login_input">
				</td>
				<td>
					<button type="submit" class="login_btn">Login</button><br>
					<a href="/socksShopping/member/registerMemberView.jsp" class="go_register">회원가입하기</a>
				</td>
			</tr>
		</table>
		
		<c:if test="${not empty requestScope.errorMessage }">
			<span style="color:red">${requestScope.errorMessage }</span>
		</c:if>
	</form>
	
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>