<%@page import="com.socks.item.vo.Item"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>
<% Item item = (Item)request.getAttribute("item"); %>
<div class="detail_view">
	<div class="detail_main_img">
		<img style="width: 300px;" alt="main_img" src='/socksShopping/mainImage/<%=item.getMainCut() %>'> <!-- 제품 메인 사진 -->
	</div>

	 <% if(session.getAttribute("loginMember") == null){%>
	 	<!-- 로그인 되있지않았을 때 사용할 폼 -->
		<form class="detail_form" action="${initParam.rootPath }/member/loginView.jsp" onclick="alert('로그인 후에 사용가능한 기능입니다!')">
		<% } else { %>
		<!-- 로그인 되었을 때 사용할 폼 -->

		<form class="detail_form" action="/socksShopping/InShoppingBasket" method = "post">
		<% } %>
		<div class="detail_title">
			<%=item.getItemName() %> <!-- 제품 이름 -->
		</div>
		<div class="detail_price">
			₩ <%=item.getItemPrice() %> <!-- 제품 가격 -->
		</div>
		<div class="detail_bar"></div>	
		<div class="detail_item_num">
			상품 개수 선택
			<input type="number" size="3" maxlength="3" name="stuck"> 개 <!-- 제품 개수 선택 -->
			<br>
			<div class="detail_stuck">
				상품재고 : 
				<%=item.getItemQuantity() %> 개<!-- 재고량이 들어감 -->
			</div>
		</div>
		<input type="text" value="<%=item.getItemId() %>" name="id" style="display: none;"> <!-- 제품 id -->
		<input type="submit" value="add to cart" class="cart_btn">
	</form>
	<div class="detail_sub_img">
		<img style="width: 80%;" alt="sub_img" src='/socksShopping/detailImage/<%=item.getDetailCut() %>'> <!-- 상세 이미지 들어가는 곳 -->
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>
</body>
</html>