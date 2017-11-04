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
<div class="reg_success">
	<div class="reg_success_box">
		<div class="reg_success_img">
			<img alt="reg_success_img" src="${initParam.rootPath }/img/reg_success.jpg">
		</div>
		<div class="reg_success_txt">
			<h3>회원가입이 완료되었습니다.</h3>
			<table>
				<tr>
					<td><a href="${initParam.rootPath }/main/showMain"><div>메인으로 이동</div></a></td>
					<td><a href="${initParam.rootPath }/member/loginView.jsp"><div>로그인하기</div></a></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>