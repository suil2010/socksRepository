<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="order_view">
	<h4>ORDER LIST</h4>
	<div class="order_list">
		<table>
			<thead>
				<tr>
					<td>Date</td>
					<td>Order Num</td>
					<td>Product Image</td>
					<td>Product Name</td>
					<td>Total</td>
					<td></td>
				</tr>
			<thead>
			<tbody>
				<c:forEach items="${sessionScope.checkListOrder}" var="order">
				<tr>
					<td>
						<fmt:setLocale value="ko_KR"/>
						<fmt:formatDate value="${order.orderDate }" type ="date"/>
					</td>
					<td>${order.itemId }</td>
					<td><div class="order_main_img"><img alt="main_img" src="/socksShopping/mainImage/${order.item.mainCut}"></div></td>
					<td>${order.item.itemName }</td>
					<td> <fmt:formatNumber value = "${order.item.itemPrice * order.orderQuantity}" type ="currency"/>
					</td>
					<td><input type="submit" value="주문취소"></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>