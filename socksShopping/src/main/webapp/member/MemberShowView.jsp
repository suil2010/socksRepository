<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.socks.member.service.impl.MemberServiceImpl"%>
<%@ page import="com.socks.member.service.MemberService"%>
<%@ page import="com.socks.member.dao.impl.MemberDaoImpl"%>
<%@ page import="com.socks.member.vo.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style type="text/css">
table {
	margin-left: auto;
	margin-right: auto;
	border: 3px solid skyblue;
}

td {
	border: 1px solid skyblue
}

#title {
	background-color: skyblue
}
</style>
</head>
<body>

	<c:set var="member" value="${sessionScope.loginMember }" />
	<table>
		<tr>
			<td id="title">아이디</td>
			<td>${member.memberId}</td>
		</tr>
		<tr>
			<td id="title">비밀번호</td>
			<td>${member.password}</td>
		</tr>

		<tr>
			<td id="title">이름</td>
			<td>${member.name}</td>
		</tr>

		<tr>
			<td id="title">이메일</td>
			<td>${member.email}</td>
		</tr>

		<tr>
			<td id="title">주소</td>
			<td>${member.address}</td>
		</tr>

	</table>
</body>
</html>