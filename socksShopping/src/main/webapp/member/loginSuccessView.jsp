<%@	page import="com.socks.member.vo.Member"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css?version=3" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="login_success">
	<div class="login_success_box">
		<div class="welcome_img">
			<img alt="welcome_img" src="${initParam.rootPath }/img/welcome.jpg">
		</div>
		<div class="welcome_txt">
			<h3>${sessionScope.loginMember.name }님 환영합니다.</h3>
			<h5>${sessionScope.loginMember.name }님의 포인트 : ${sessionScope.loginMember.point }</h5>
			<table>
				<tr>
					<td><a href="${initParam.rootPath }/main/showMain"><div>메인으로</div></a></td>
					<td><a href="/socksShopping/member/MemberMyPage.jsp"><div>마이페이지</div></a></td>
					<td><a href="/socksShopping/logoutMember"><div>로그아웃</div></a></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>