<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css?version=1" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="index_view">
	<div class="slide">
		<img alt="slide1" src="${initParam.rootPath }/slideImgs/slide1.jpg">
		<img alt="slide1" src="${initParam.rootPath }/slideImgs/slide2.jpg">
		<img alt="slide1" src="${initParam.rootPath }/slideImgs/slide3.jpg">
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>