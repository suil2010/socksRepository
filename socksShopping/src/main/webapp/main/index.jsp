<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${initParam.rootPath }/js/jquery-1.12.3.js"></script>
<script type="text/javascript" src="${initParam.rootPath }/js/js.js"></script>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="index_view">
	<div class="sli_main_img">
		<div class="index_txt">
			<h3>저희 쇼핑몰에 오신 것을 환영합니다!</h3>
		</div>
		<div class="slide">
			<img alt="slide1" src="${initParam.rootPath }/slideImgs/slide1.jpg">
			<img alt="slide2" src="${initParam.rootPath }/slideImgs/slide2.jpg">
			<img alt="slide3" src="${initParam.rootPath }/slideImgs/slide3.jpg">
		</div>
		<div class="index_btn">
			<table>
				<tr>
					<td><a href="${initParam.rootPath }/main/showMain"><div>상점페이지</div></a></td>
					<td><a href="${initParam.rootPath }/member/loginView.jsp"><div>로그인페이지</div></a></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>