<%@ page import="com.socks.ordermember.vo.OrderMember"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
<script type="text/javascript">
	function mySubmit(){
			document.orderForm.action = "/socksShopping/removeOrder";
			document.orderForm.submit();
	}
</script>
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="order_view">
	<h4>${sessionScope.loginMember.name }회원의 주문내역</h4>
	<form name = "orderForm" method = "post">
	<div class="order_list">
		<table>
			<thead>
				<tr>
					<td>Date</td>
					<td>Order Num</td>
					<td>Product Price</td>
					<td>Product Image</td>
					<td>Product Name</td>
					<td>Total</td>
					<td></td>
				</tr>
			<thead>
			<tbody>
				<c:forEach items="${sessionScope.checkListOrder}" var="orderMember">
					<c:forEach items="${orderMember.orderDetailList}" var="orderDetail">
					<tr>
						<td>
							<fmt:setLocale value="ko_KR"/>
							<fmt:formatDate value="${orderMember.orderDate }" type ="date"/>
						</td>
						<td>${orderDetail.orderQuantity }</td>
						<td>${orderDetail.itemPrice }</td>
						<td><div class="order_main_img"><img alt="main_img" src="/socksShopping/mainImage/${orderDetail.mainCut}"></div></td>
						<td>${orderDetail.itemName }</td>
						<td> <fmt:formatNumber value = "${orderDetail.itemPrice * orderDetail.orderQuantity}" type ="currency"/>
						</td>						
						<td><input type="submit" value="${orderDetail}" name="order" onclick= "mySubmit()"></td>
					</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>