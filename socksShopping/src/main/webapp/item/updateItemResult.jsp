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
<div class="up_item_result">
	<h4>${requestScope.item.itemName } 수정 완료</h4>
	
	<div class="up_result_box">
		<div class="up_result_main">
			<img alt="main_img" src="/socksShopping/mainImage/${requestScope.item.mainCut }">
		</div>
		<div class="item_result_txt">
			<table>
				<tr>
					<td>상품 ID</td>
					<td>${requestScope.item.itemId }</td>
				</tr>
				<tr>
					<td>상품 이름</td>
					<td>${requestScope.item.itemName }</td>
				</tr>
				<tr>
					<td>상품 가격</td>
					<td>${requestScope.item.itemPrice }</td>
				</tr>
				<tr>
					<td>상품 수</td>
					<td>${requestScope.item.itemQuantity }</td>
				</tr>
			</table>
		</div>
		<div class="up_result_detail">
			<h5>상세 이미지</h5>
			<img alt="detail_img" src="/socksShopping/detailImage/${requestScope.item.detailCut }">
		</div>
		<div class="up_item_link">
			<a href="/socksShopping/item/managerView.jsp"><div>관리자 페이지</div></a>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>