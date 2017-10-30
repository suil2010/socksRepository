<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>
<div class="detail_view">
	<div class="detail_main_img">
		<img alt="main_img" src=""> <!-- 제품 메인 사진 -->
	</div>
	<form class="detail_form" action="">
		<div class="detail_title">
			제품 이름 샘플 ㅇㅇㅇㅇㅇㅇ <!-- 제품 이름 -->
		</div>
		<div class="detail_price">
			₩ 100000 <!-- 제품 가격 -->
		</div>
		<div class="detail_bar"></div>	
		<div class="detail_item_num">
			상품 개수 선택
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>
</body>
</html>