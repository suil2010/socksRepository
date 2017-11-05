<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function inputCheck(){
	var itemNum = document.updateform.itemId.value;
	var itemP = document.updateform.itemPrice.value;
	var itemQ = document.updateform.itemQuantity.value;
	var itemN = document.updateform.itemName.value;
	var itemM = document.updateform.mainImage.value;
	var itemD = document.updateform.detailImage.value;
	
	if(itemNum == "") {
		alert("상품 Id이름를 입력하시오.");
		document.updateform.itemId.focus();
		return false;
	} else if(itemNum.length >= 15 ) {
		alert("상품ID는 15글자 이내로 넣으세요");
		document.updateform.itemId.focus();
		return false;
	}
	
	if(itemP == "") {
		alert("상품가격을 입력하시오.");
		document.updateform.itemPrice.focus();
		return false;
	} else if(itemP > 100000){
		alert("상품가격을 100000원 미만");
		document.updateform.itemPrice.focus();
		return false;
	}
	
	if(itemQ == "") {
		alert("전체상품수를 입력하시오.");
		document.updateform.itemQuantity.focus();
		return false;
	} else if(itemQ > 1000){
		alert("재고량은 1000개 미만");
		document.updateform.itemQuantity.focus();
		return false;
	}
	if(itemN == "") {
		alert("상품명를 입력하시오.");
		document.updateform.itemName.focus();
		return false;
	} else if(itemN.length > 10){
		alert("상품명은 10글자 이하");
		document.updateform.itemName.focus();
		return false;
	}
	if(itemM == "") {
		alert("메인이미지를 넣으세요.");
		document.updateform.mainImage.focus();
		return false;
	}
	if(itemD == "") {
		alert("상세이미지를 넣으세요.");
		document.updateform.detailImage.focus();
		return false;
	}
	updateform.submit();
}
</script>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="update_item">
	<h4>상품 수정</h4>
	<div class="update_box">
		<form name = "updateform" action="/socksShopping/updateItem" onsubmit="inputCheck()" method="post" enctype="multipart/form-data" class="update_form">
			<table>
				<tr>
					<td>상품번호</td>
					<td><input type = "text" name = "itemId" placeholder ="itemId-*" ></td>
				</tr>
				<tr>
					<td>제품가격</td>
					<td><input type = "number" name = "itemPrice" placeholder = "1000" ></td>
				</tr>
				<tr>
					<td>전체제품수</td>
					<td><input type ="number" name = "itemQuantity" placeholder ="100" ></td>
				</tr>
				<tr>
					<td>상품이름</td>
					<td><input type = "text" name = "itemName" placeholder ="상품명" ></td>
				</tr>
				<tr>
					<td>메인이미지</td>
					<td><input type="file" name="mainImage"></td>
				</tr>
				<tr>
					<td>상세이미지</td>
					<td><input type="file" name="detailImage"></td>
				</tr>
			</table>
			<input type="submit" value="전송" >
		</form>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>