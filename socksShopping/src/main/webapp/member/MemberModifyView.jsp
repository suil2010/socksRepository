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
	if(regForm.name.value == "") {
		alert("이름를 입력하시오.");
		regForm.name.focus();
		return false;

	}
	
	if(regForm.password.value == "") {
		alert("passwd를 입력하시오.");
		regForm.password.focus();
		return false;

	}
	if(regForm.password.value !== regForm.passwordConf.value) {
		alert("비밀번호가 일치하지 않습니다!");
		regForm.password.focus();
		return false;
	}

	if(regForm.address.value == "") {
		alert("address를 입력하시오.");
		regForm.address.focus();
		return false;

	}

	if(regForm.email.value == "") {
		alert("email를 입력하시오.");
		regForm.email.focus();
		return false;

	}
	regForm.submit();
}
</script>
</head>
<body>

<h1>회원정보 수정</h1>
	
	<form name="modForm" action="/socksShopping/member/forwardMember2.jsp" method="post" onsubmit="return inputCheck()">
	${sessionScope.loginMember.memberId }
		<input type="hidden" name="memberId" value="${sessionScope.loginMember.memberId }"><!-- id는 변경할 수 없다. 따라서 화면에 뿌려주지 않는다. --><br>
		이름 : <input type="text" name="name" value="${sessionScope.loginMember.name }"><br> 
		비밀번호 :<input type="password" name="password"><br> 
		비밀번호 확인 : <input type="password" name="passwordConf"><br>
		주소 : <input type="text" name="address"><br> 
		email : <input type="text" name="email"><br> 
		<input type="hidden" name="point" value=1000><br><!-- 회원가입시 point는 자동으로 1000원 적립된다.(회원가입창에서 보여지지 않는다) -->
		<button type="submit">수정완료</button>
		<input type="button" value="취소" onclick="goFirstForm()">
	</form>

</body>
</html>