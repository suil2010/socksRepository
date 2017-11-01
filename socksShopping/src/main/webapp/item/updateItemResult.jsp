<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 수정완료 페이지</h2>
속성값<br>
상품번호 : ${requestScope.item.itemId }<br>
상품속성 : ${requestScope.item.itemPrice }<br>
전체제품수 : ${requestScope.item.itemQuantity }<br>
상품이름 : ${requestScope.item.itemName }<br>

메인이미지<br>
<img src="/socksShopping/mainImage/${requestScope.item.mainCut }">
<p>
상세이미지<br>
<img src="/socksShopping/detailImage/${requestScope.item.detailCut }">

수정완료
</body>
</html>