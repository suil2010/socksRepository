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
</head>
<body>
	<h1>회원가입</h1>
	
	<form name="regForm" action="/socksShopping/member/forwardMember.jsp" method="post" onsubmit="return inputCheck()">
	
		아이디 : <input type="text" name="memberId" onkeydown="idCheck">
		<c:if test="${not empty requestScope.errorMessage }"><!-- id 중복시 errorMessage를 뿌려준다. -->
			<span style="color:red">${requestScope.errorMessage }</span>
		</c:if><br>
		이름 : <input type="text" name="name"><br> 
		비밀번호 :<input type="password" name="password"><br> 
		비밀번호 확인 : <input type="password" name="passwordConf"><br>
		주소 : <input type="text" name="address"><br> 
		email : <input type="text" name="email"><br> 
		<input type="hidden" name="point" value=1000><br><!-- 회원가입시 point는 자동으로 1000원 적립된다.(회원가입창에서 보여지지 않는다) -->
		<button type="submit">회원가입</button>
		<input type="button" value="취소" onclick="goFirstForm()">
	</form>
</body>
</html>