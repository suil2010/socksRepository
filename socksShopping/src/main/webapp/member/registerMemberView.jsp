<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/socksShopping/member/forwardMember.jsp" method="post">

	아이디 : <input type="text" name="memberId"><br>
	이름 : <input type="text" name="name"><br>
	비밀번호 : <input type="password" name="password"><br>
	주소 : <input type="text" name="address"><br>
	email : <input type="text" name="email"><br>
	point : <input type="number" name="point"><br>
	<button type="submit">회원가입</button>

</form>
</body>
</html>