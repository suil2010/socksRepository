<%@ page contentType="text/html;charset=utf-8"%>
<<<<<<< HEAD
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>
<div class="main_form">
	<table>	
		<%for(int i = 0; i < 5; i++){ %> <!-- 테스트용 -->
		<tr> 
			<% for(int j=0; j < 5; j++) { %>
			<td class="item_box">
				<a href="#">
					<div class="items">
						<div class="item_img_box">
							<img alt="item_img" src=""> <!-- 상품 이미지 -->
						</div>
						<div class="fl_le">
							<div class="item_name">
								아이템 이름 예시 <!-- 상품 이름 -->
							</div>
						</div>
						<div class="fl_le">
							<div class="item_price">
								₩ 100000 <!-- 상품 가격 -->
							</div>
						</div>
						<div class="item_bar"></div>
					</div>
				</a>
			</td>
			<% } %>
		</tr>
		<%} %>
	</table>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div class="main_form">
	<c:forEach items="${requestScope.list}" var="item">
		<div class="item_box">
			<a href="${initParam.rootPath }/main/showDetail?itemId=${item.itemId }">
				<div class="items">
					<div class="item_img_box">
						<img style="width: 200px;" alt="item_img" src='/socksShopping/mainImage/${item.mainCut}'>
						<!-- 상품 이미지 -->
					</div>
					<div class="fl_le">
						<div class="item_name">
							${item.itemName }
						</div>
					</div>
					<div class="fl_le">
						<div class="item_price">
							₩ ${item.itemPrice }
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
>>>>>>> branch 'master' of https://github.com/suil2010/socksRepository.git
</body>
</html>