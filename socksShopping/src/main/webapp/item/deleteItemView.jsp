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
<div class="delete_item">
	<h4>상품 삭제 페이지</h4>
	<div class="delete_box">
		<form action="/socksShopping/deleteItem" method="post" class="delete_form">
			<h5>삭제할 상품번호를 입력해주세용~~~~~~~~~</h5>
			<input type = "text" name = "itemId" placeholder="itemId-*"> &nbsp;
			<button>삭제</button>
		</form>
		<div class="delete_img_box">
			<img alt="delete_img" src="${initParam.rootPath }/img/delete.jpg">
		</div>
		<a href="managerView.jsp"><div>뒤로가기</div></a>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>