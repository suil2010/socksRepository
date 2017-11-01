<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/socksShopping/updateItem" method="post" enctype="multipart/form-data">
	상품번호 : <input type = "text" name = "itemId"><br>
 	제품가격 : <input type = "text" name = "itemPrice"><br>
 	전체제품수 : <input type ="text" name = "itemQuantity"><br>
 	상품이름 : <input type = "text" name = "itemName"><br>
	메인이미지 : <input type="file" name="mainImage"><br>
	상세이미지 : <input type="file" name="detailImage"><br>
<button>전송</button>
</form>
</body>
</html>