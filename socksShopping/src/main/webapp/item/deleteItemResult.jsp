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
<div class="delete_result">
	<h3>삭제가 완료되었습니다.</h3>
	<a href="${initParam.rootPath }/item/managerView.jsp"><div>관리자 페이지로 이동</div></a>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>