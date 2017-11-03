<%@page import="com.socks.member.service.impl.MemberServiceImpl"%>
<%@page import="com.socks.member.service.MemberService"%>
<%@page import="com.socks.member.dao.impl.MemberDaoImpl"%>
<%@page import="com.socks.member.dao.MemberDao"%>
<%@page import="com.socks.member.vo.Member"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 페이지</title>
<script type="text/javascript">
function inputCheck(){
	if(modForm.name.value == "") {
		alert("이름를 입력하시오.");
		modForm.name.focus();
		return false;
	}
	if(modForm.password.value == "") {
		alert("passwd를 입력하시오.");
		modForm.password.focus();
		return false;
	}
	if(modForm.password.value !== modForm.passwordConf.value) {
		alert("비밀번호가 일치하지 않습니다!");
		modForm.password.focus();
		return false;
	}
	if(modForm.address.value == "") {
		alert("address를 입력하시오.");
		modForm.address.focus();
		return false;
	}
	if(modForm.email.value == "") {
		alert("email를 입력하시오.");
		regForm.email.focus();
		return false;
	}
	modForm.submit();
}
function modifySuccess(){
	alert("회원정보 수정이 완료되었습니다.");
}
</script>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="member_modify">
<h4>회원정보 수정</h4>
	<div class="member_modify_box">
		<form name="modForm" action="/socksShopping/member/forwardMember2.jsp" method="post" onsubmit="return inputCheck()" class="member_modify_form">
			<input style="display: none;" type="hidden" name="memberId" value="${sessionScope.loginMember.memberId }"><!-- id는 변경할 수 없다. 따라서 화면에 뿌려주지 않는다. -->
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${sessionScope.loginMember.name }"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" value="${sessionScope.loginMember.password}"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="passwordConf" value="${sessionScope.loginMember.password}"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="${sessionScope.loginMember.address}"></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="text" name="email" value="${sessionScope.loginMember.email}"> </td>
				</tr>
			</table>
			<input style="display: none;" type="text" name="point" value="${sessionScope.loginMember.point }"><br><!-- 회원가입시 point는 자동으로 1000원 적립된다.(회원가입창에서 보여지지 않는다) -->
			<button class="member_modify_btn" type="submit" onclick="window.location.href='/socksShopping/member/MemberModifyView.jsp'">수정완료</button>
			<input class="member_modify_btn" type="button" value="취소" onclick="window.location.href='MemberMyPage.jsp'">
		</form>	
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>