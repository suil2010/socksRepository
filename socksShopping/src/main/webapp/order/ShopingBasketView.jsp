<%@page import="java.util.List"%>
<%@page import="com.socks.order.vo.Order"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">

<script type="text/javascript">
	function  mySubmit(index){
		if(index == 1){
			document.basketForm.action = "/socksShopping/removeServlet";
		}
		if(index == 2){
			document.basketForm.action = "#";
		}
		document.basketForm.submit();
	}
</script>
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="basket_view">
	<h4>${sessionScope.loginMember.name }회원의 장바구니</h4>
	<form name = "basketForm" method = "post">
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
			<c:choose>
			<c:when test="${requestScope.listOrder eq null}">	
				<tr>
					<td>조회된 상품이 없습니다.</td>
				<tr>
			</c:when>
			<c:otherwise>
				<c:forEach items= "${requestScope.listOrder }" var="order">
					<tr>
						<td><input type="checkbox" name="check" value ="${order.orderId }" ></td>
						<td><div class="basket_img"><img alt="main_img" src="/socksShopping/mainImage/${order.item.mainCut }"></div></td>
						<td>${order.item.itemName }</td>
						<td>₩ ${order.item.itemPrice }</td> <!-- 제품가격 -->
						<td>${order.orderQuantity } 개</td> <!-- 제품 개수 -->
						<td>₩ ${order.item.itemPrice * order.orderQuantity}</td> <!-- 제품가격 * 제품개수 -->
					<tr>	
				</c:forEach>
			</c:otherwise>
			</c:choose>
			</tbody>
		</table>
		<input type = "submit" value="remove" class="basket_remove" onclick = "mySubmit(1)"><!-- 클릭시 체크 되어 있는 아이템 삭제? -->
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
			<input type="submit" value="checkout" class="basket_order_btn"><!-- 주문버튼 -->
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>