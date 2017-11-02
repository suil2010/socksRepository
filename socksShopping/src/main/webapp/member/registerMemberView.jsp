<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function inputCheck(){
	if(regForm.memberId.value==""){
		alert("id를 입력하세요.");
		regForm.memberId.focus();
		return false;
	}
	
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
function goFirstForm(){
	location.href="/socksShopping/main/mainPage.jsp";//메인페이지로 이동하기
}

</script>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="register_view">

	<h4>회원가입</h4>
	
	<form name="regForm" action="/socksShopping/member/forwardMember.jsp" method="post" onsubmit="return inputCheck()" class="register_form">
		<table class="register_table">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" onkeydown="idCheck"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<c:if test="${not empty requestScope.errorMessage }"><!-- id 중복시 errorMessage를 뿌려준다. -->
						<span style="color:red; font-size: 14px; font-weight: normal;">${requestScope.errorMessage }</span>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="passwordConf"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="hidden" name="point" value=1000><!-- 회원가입시 point는 자동으로 1000원 적립된다.(회원가입창에서 보여지지 않는다) --></td>
			</tr>
		</table>
		<button type="submit" class="register_btn">회원가입</button>
		<input type="button" value="취소" onclick="goFirstForm()" class="register_btn">
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>