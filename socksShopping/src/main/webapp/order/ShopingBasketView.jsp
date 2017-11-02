<%@page import="java.util.List"%>
<%@page import="com.socks.order.vo.Order"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css?version=2" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="basket_view">
	<h4>${sessionScope.loginMember.name }회원의 장바구니</h4>
	<form action="#">
		<table class="basket_table">
			<thead>
				<tr>
					<td></td>
					<td>Product</td>
					<td>Option</td>
					<td>Price</td>
					<td>Quantity</td>
					<td>Total</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list }" var="item">
					<tr>
						<td><input type="checkbox" name="check"></td>
						<td><div class="basket_img"><img alt="main_img" src="/socksShopping/mainImage/${item.mainCut }"></div></td>
						<td>${item.itemName }</td>
						<td>₩ ${item.itemPrice }</td> <!-- 제품가격 -->
						<td>${item.orderQuantity } 개</td> <!-- 제품 개수 -->
						<td>₩ ${item.itemPrice * item.orederQuantity }</td> <!-- 제품가격 * 제품개수 -->
					<tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="remove" class="basket_remove"><!-- 클릭시 체크 되어 있는 아이템 삭제? -->
		<div class="total_due">
			<h3>TOTAL DUE</h3>
			<table>
				<tr>
					<td>SUB TOTAL</td>
					<td>₩ 보류
					</td><!-- (각제품가격 * 제품개수)+..+..?  -->
				</tr>
				<tr>
					<td>DELIVERY FEE</td>
					<td>₩ 보류</td><!-- 배송비? -->
				</tr>
				<tr>
					<td style="color: red;">TOTAL</td>
					<td style="color: red;">₩ 보류</td><!-- sub total + delivery fee? -->
				</tr>
			</table>
			<input type="submit" value="checkout" class="basket_order_btn" src=""><!-- 주문버튼 -->
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>