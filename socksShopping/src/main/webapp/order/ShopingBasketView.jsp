
<%@page import="java.util.List"%>
<%@page import="com.socks.order.vo.Order"%>
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

	function mySubmit(index){
		if(index == 1){
			document.basketForm.action = "/socksShopping/removeServlet";
			document.basketForm.submit();
		}
		if(index == 2){
			<%-- 자바스크립트는 DOM구조이다. --%>
			var checkList = document.basketForm.check;
			var cnt = 0;
			for(var i =0; i < checkList.length ; i++){
					if(checkList[i].checked){
						cnt++;	
					}
				}
			if(cnt == -1 ){
				alert("상품을 체크하거나 장바구니에 상품을 넣으세요");
				return false; //원래 창으로 돌아간다.
			} else{
				document.basketForm.action = "/socksShopping/InOrder";
				document.basketForm.submit();
			}
		}
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
			<c:when test="${sessionScope.listOrder eq null}">	
				<tr>
					<td colspan="6">조회된 상품이 없습니다.</td>
				<tr>
			</c:when>
			<c:otherwise>
				<c:forEach items= "${sessionScope.listOrder }" var="order">
					<tr>
						<td><input type="checkbox" name="check" value ="${order.orderId }" ></td>
						<td><div class="basket_img"><img alt="main_img" src="/socksShopping/mainImage/${order.item.mainCut }"></div></td>
						<td>${order.item.itemName }</td>
						<td><fmt:formatNumber value = "${order.item.itemPrice }" type ="currency"/></td> <!-- 제품가격 -->
						<td>${order.orderQuantity } 개</td> <!-- 제품 개수 -->
						<td><fmt:formatNumber value = "${order.item.itemPrice * order.orderQuantity}" type ="currency"/></td> <!-- 제품가격 * 제품개수 -->
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
					<td>  <c:forEach items="${sessionScope.listOrder }" var="order">
						  	  <c:set var = "sum" value = "${sum+order.item.itemPrice * order.orderQuantity}"/>    
						  </c:forEach>
						  <%-- type : number(기본)-단위구분자, currency :통화기호, percent : %기호 --%>

						  <fmt:formatNumber value = "${sum }" type ="currency"/>
					</td><!-- (각제품가격 * 제품개수)+..+..?  -->
				</tr>
				<tr>
					<td>DELIVERY FEE</td>
					<td>
						<c:choose>
							<c:when test="${sum >= 30000 or sum == null  }">
								<fmt:formatNumber value = "0" type ="currency"/>
							</c:when>
							<c:otherwise>
								<fmt:formatNumber value = "2500" type ="currency"/>
							</c:otherwise>
						</c:choose>
					</td><!-- 배송비? -->
				</tr>
				<tr>
					<td style="color: red;">TOTAL</td>
					<td style="color: red;">
						<c:choose>
							<c:when test="${sum >= 30000 or sum == null }">
								<fmt:formatNumber value = "${sum }" type ="currency"/>
							</c:when>
							<c:otherwise>
								<fmt:formatNumber value = "${sum + 2500 }" type ="currency"/>
							</c:otherwise>
						</c:choose>
					</td><!-- sub total + delivery fee? -->
				</tr>
			</table>
			<input type="button" value="checkout" class="basket_order_btn" onclick = "mySubmit(2)"><!-- 주문버튼 -->
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>