<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>장바구니</h2>

	로그인 ID :	${sessionScope.loginMember.memberId }<br>
	상품 ID : ${requestScope.item.itemId } <br>
	상품 명 : ${requestScope.item.itemId } <br>
</body>

<form action="" method = "post">
	
</form>

<a href="/socksShopping/main/mainPage.jsp">메인페이지로 돌아가기</a>

</body>
</html>