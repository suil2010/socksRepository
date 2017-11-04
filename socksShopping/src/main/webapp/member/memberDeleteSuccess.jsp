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
<div class="del_mem_success">
	<h3>회원탈퇴가 완료되었습니다</h3>
	<div>
	<a href="${initParam.rootPath }/logoutMember"><div>처음으로</div></a>	
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>