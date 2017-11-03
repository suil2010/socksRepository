<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script type="text/javascript">
function removeMember(){
	window.location.href='/socksShopping/member/forwardMember3.jsp';
}
</script>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="member_show_view">
	<h4>내 정보</h4>
	<div class="member_show_view_box">
		<c:set var="member" value="${sessionScope.loginMember }" />
		<table>
			<tr>
				<td>ID</td>
				<td>${member.memberId}</td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td>${member.password}</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>${member.name}</td>
			</tr>
				<tr>
				<td>E-MAIL</td>
				<td>${member.email}</td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td>${member.address}</td>
			</tr>
		</table>
		<input type="button" value="정보수정하기" onclick="location.href='/socksShopping/member/MemberModifyView.jsp'"/>
		<input type="button" value="이전페이지" onclick="location.href='/socksShopping/member/MemberMyPage.jsp'">
		<input type="submit" value="탈퇴하기" onclick="location.href='/socksShopping/member/deleteMemberView.jsp'"/>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>









