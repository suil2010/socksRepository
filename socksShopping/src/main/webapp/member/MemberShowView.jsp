<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style type="text/css">
table {
	border: 3px solid gray;
}
td {
	border: 1px solid gray;
}
#title {
	background-color: white
}
</style>
<script type="text/javascript">
function removeMember(){
	window.location.href='/socksShopping/member/forwardMember3.jsp';
}

</script>
</head>
<body>
<p>
<a href="/socksShopping/member/MemberMyPage.jsp">이전페이지로</a>
</p>

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
	
	
	<input type="button" value="정보수정하기" onclick="location.href='/socksShopping/member/MemberModifyView.jsp'"/>
    <input type="submit" value="탈퇴하기" onclick="location.href='/socksShopping/member/deleteMemberView.jsp'"/>  

</body>
</html>









