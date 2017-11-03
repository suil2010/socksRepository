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
<div class="mem_mod_success">
	<h4>회원정보 수정이 완료되었습니다</h4>
	<div class="mem_mod_success_box">
		<table>
			<tr>
				<td>ID</td>
				<td>${sessionScope.loginMember.memberId }</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>${sessionScope.loginMember.name }</td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td>${sessionScope.loginMember.address }</td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td>${sessionScope.loginMember.email }</td>
			</tr>
			<tr>
				<td>POINT</td>
				<td>${sessionScope.loginMember.point }</td>
			</tr>
		</table>
	</div>
	<input type="button" value="메인으로" onclick="window.location.href='/socksShopping/main/showMain'">
	<input type="button" value="뒤로가기" onclick="window.location.href='/socksShopping/member/MemberModifyView.jsp'">
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>