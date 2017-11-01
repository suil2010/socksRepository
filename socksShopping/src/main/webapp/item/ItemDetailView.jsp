<%@page import="com.socks.item.vo.Item"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/css.css?ver=2" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>
<% Item item = (Item)request.getAttribute("item"); %>
<div class="detail_view">
	<div class="detail_main_img">
		<img alt="main_img" src='<%--  --%>'> <!-- 제품 메인 사진 -->
	</div>
	<form class="detail_form" action="">
		<div class="detail_title">
			<%= item.getItemName() %> <!-- 제품 이름 -->
		</div>
		<div class="detail_price">
			₩ <%= item.getItemPrice() %> <!-- 제품 가격 -->
		</div>
		<div class="detail_bar"></div>	
		<div class="detail_item_num">
			상품 개수 선택
			<input type="number" size="3" maxlength="3"> 개 <!-- 제품 개수 선택 -->
			<br>
			<div class="detail_stuck">
				상품재고 : 
				<%= item.getItemQuantity() %> 개<!-- 재고량이 들어감 -->
			</div>
		</div>
		<input type="submit" value="add to cart" class="cart_btn">
	</form>
	<div class="detail_sub_img">
		<img alt="sub_img" src='<%= item.getDetailCut() %>'> <!-- 상세 이미지 들어가는 곳 -->
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>
</body>
</html>