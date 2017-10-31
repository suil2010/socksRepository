<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/css.css?ver=1" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="main_form">
	<c:forEach items="${requestScope.itemList}" var="list">
		<div class="item_box">
			<a href="${initParam.rootPath }/item/ItemDetailView.jsp?itemId=${list.itemId}">
				<div class="items">
					<div class="item_img_box">
						<img alt="item_img" src='<c:url value="/C:/Java/Test/${list.mainCut }"/>'>
						<!-- 상품 이미지 -->
					</div>
					<div class="fl_le">
						<div class="item_name">${list.itemName }</div>
					</div>
					<div class="fl_le">
						<div class="item_price">
							₩ ${list.itemPrice }
							<!-- 상품 가격 -->
						</div>
					</div>
					<div class="item_bar"></div>
				</div>
			</a>
		</div>
	</c:forEach>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>