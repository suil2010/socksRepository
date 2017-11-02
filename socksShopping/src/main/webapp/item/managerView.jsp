<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${initParam.rootPath }/css/css.css?version=3" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="manager_view">
	<h4>관리자 페이지</h4>
	<div class="manager_link_box">
		<table>
			<tr>
				<td onmouseover='document.getElementById("img").src ="${initParam.rootPath}/img/manager.jpg"'>
					<a href="/socksShopping/item/addItemView.jsp">상품등록</a>
				</td>
		 		<td onmouseover='document.getElementById("img").src ="${initParam.rootPath}/img/manager2.jpg"'>
		 			<a href="/socksShopping/item/updateItemView.jsp">상품수정(재고관리)</a>
		 		</td>
		 		<td onmouseover='document.getElementById("img").src ="${initParam.rootPath}/img/manager3.jpg"'>
		 			<a href="/socksShopping/item/deleteItemView.jsp">상품삭제</a>
		 		</td>
		 		<td onmouseover='document.getElementById("img").src ="${initParam.rootPath}/img/manager4.jpg"'>
		 			<a href="/socksShopping/main/mainPage.jsp">메인페이지로 돌아가기</a>
		 		</td>
			</tr>
		</table>
		<div class="manager_img">
			<img id="img" alt="manager_page_img" src="${initParam.rootPath }/img/manager_img.jpg">
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>