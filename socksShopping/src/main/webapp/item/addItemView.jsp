<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function clearPlaceholder(tag){
	if(tag.value == 'itemId-*'){tag.value ='';}
	else if(tag.value == '10000'){tag.value ='';}
	else if(tag.value == '10000'){tag.value ='';}
	else if(tag.value == '100'){tag.value ='';}
	else if(tag.value == '상품명'){tag.value ='';}
}

function itemIdCheck(tag){
	var itemNum = document.addform.itemId.value;
	//15글자 이하
	if(itemNum.length >=15){
		alert("상품ID는 15글자 이내로 넣으세요");
		document.addform.itemId.value = "";
		document.addform.itemId.focus();
	}
}

function itemPriceCheck(tag){
	var itemP = document.addform.itemPrice.value;
	//100000초과 1000원 미만
	if(itemP > 100000){
		alert("상품가격을 100000원 미만");
		document.addform.itemPrice.value ="";
		document.addform.itemPrice.focus();
	} else if(itemP < 1000){
		alert("상품가격을 1000원이상");
		document.addform.itemPrice.value= "";
		document.addform.itemPrice.focus();
	}
}

function itemQuantityCheck(tag){
	var itemQ = document.addform.itemQuantity.value;
	//재고량이 1000개 초과 
	if(itemQ > 1000){
		alert("재고량은 1000개 미만");
		document.addform.itemQuantity.value = "";
		document.addform.itemQuantity.focus();
	}
}

function itemNameCheck(tag){
	var itemN = document.addform.itemName.value;
	//상품명이 10글자 이하
	if(itemN.length > 10){
		alert("상품명은 10글자 이하");
		document.addform.itemName.value="";
		document.addform.itemName.focus();
	}
} 

</script>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="add_item_view">
	<h4>상품등록페이지</h4>	
	
	<form name = "addform" action="/socksShopping/addItem" method="post" enctype="multipart/form-data" class="add_item_form">
		<table class="add_item_tbl">
			<tr>
				<td>상품번호</td>
				<td><input type = "text" name = "itemId" placeholder ="itemId-*" onblur ="itemIdCheck(this)"></td>
			</tr>
			<tr>
				<td>제품가격</td>
				<td><input type = "number" name = "itemPrice" placeholder = "10000" onblur = "itemPriceCheck(this)"></td>
				<td style="font-weight: bold;">원</td>
			</tr>
			<tr>
				<td>전체제품수</td>
				<td><input type ="number" name = "itemQuantity" placeholder ="100" onblur = "itemQuantityCheck(this)"></td>
			</tr>
			<tr>
				<td>상품이름</td>
				<td><input type = "text" name = "itemName" placeholder="상품명" onblur = "itemNameCheck(this)"></td>
			</tr>
			<tr>
				<td>메인이미지</td>
				<td><input style="font-size: 14px; font-weight: normal;" type="file" name="mainImage"></td>
			</tr>
			<tr>
				<td>상세이미지</td>
				<td><input style="font-size: 14px; font-weight: normal;" type="file" name="detailImage"></td>
			</tr>
		</table>
	 	
		<input type="submit" value="전송" onclick="return confirm('상품을 등록하시겠습니까?')">
	</form>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>