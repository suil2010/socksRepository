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
	<h4>ORDER LIST</h4>
	<form class="order_list">
		<table>
			<thead>
				<tr>
					<td></td>
					<td>Date</td>
					<td>Product Image</td>
					<td>Product Name</td>
					<td>Product Price</td>
					<td>Order Num</td>
					<td>Total</td>
				</tr>
			<thead>
			<tbody>
				<c:forEach items="${sessionScope.checkListOrder}" var="orderMember">
					<c:forEach items="${orderMember.orderDetailList}" var="orderDetail">
					<tr>
						<td><input type="checkbox" name="check"></td>
						<td>
							<fmt:setLocale value="ko_KR"/>
							<fmt:formatDate value="${orderMember.orderDate }" type ="date"/>
						</td>
						<td><div class="order_main_img"><img alt="main_img" src="/socksShopping/mainImage/${orderDetail.mainCut}"></div></td>
						<td>${orderDetail.itemName }</td>
						<td>${orderDetail.itemPrice }</td>	
						<td>${orderDetail.orderQuantity }</td>
						<td> <fmt:formatNumber value = "${orderDetail.itemPrice * orderDetail.orderQuantity}" type ="currency"/>
						</td>
					</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
		<input class="order_cancle_btn" type="submit" value="주문취소">
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>