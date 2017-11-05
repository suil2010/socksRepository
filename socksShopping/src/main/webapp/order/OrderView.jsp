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
			if(confirm("주문을 취소하시겠습니까?")){
				document.orderForm.action = "/socksShopping/removeOrder";
				document.orderForm.submit();
			} else{
				return false;
			}
	}
</script>
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div class="order_view">
	<h4>${sessionScope.loginMember.name }님의 주문목록</h4>
	<form class="order_list" name ="orderForm" method ="post">
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
			<c:choose>
				<c:when test="${sessionScope.checkListOrder eq null}">
					<tr>
						<td colspan="7">주문된 상품이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
				<c:forEach items="${sessionScope.checkListOrder}" var="orderMember">
					<c:forEach items="${orderMember.orderDetailList}" var="orderDetail">
					<tr>
						<td><input type="checkbox" name="checkOrderDetailId" value=${orderDetail.orderDetailId }></td>
						<td>
							<fmt:setLocale value="ko_KR"/>
							<fmt:formatDate value="${orderMember.orderDate }" type ="date"/>
						</td>
						<td><div class="order_main_img"><img alt="main_img" src="/socksShopping/mainImage/${orderDetail.item.mainCut }"></div></td>
						<td>${orderDetail.item.itemName }</td>
						<td>${orderDetail.item.itemPrice }</td>	
						<td>${orderDetail.orderQuantity }</td>
						<td> <fmt:formatNumber value = "${orderDetail.item.itemPrice * orderDetail.orderQuantity}" type ="currency"/>
						</td>
					</tr>
					</c:forEach>
				</c:forEach>
				</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<input class="order_cancle_btn" type="button" value="주문취소" onclick ="mySubmit()">
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>