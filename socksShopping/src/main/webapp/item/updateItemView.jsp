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
	var itemNum = document.updateform.itemId.value;
	//15글자 이하
	if(itemNum.length >=15){
		alert("상품ID는 15글자 이내로 넣으세요");
		document.updateform.itemId.value = "";
		document.updateform.itemId.focus();
	}
}

function itemPriceCheck(tag){
	var itemP = document.updateform.itemPrice.value;
	//100000초과 1000원 미만
	if(itemP > 100000){
		alert("상품가격을 100000원 미만");
		document.updateform.itemPrice.value= "";
		document.updateform.itemPrice.focus();
	} else if(itemP < 1000){
		alert("상품가격을 1000원이상");
		document.updateform.itemPrice.value= "";
		document.updateform.itemPrice.focus();
	}
}

function itemQuantityCheck(tag){
	var itemQ = document.updateform.itemQuantity.value;
	//재고량이 1000개 초과 
	if(itemQ > 1000){
		alert("재고량은 1000개 미만");
		document.updateform.itemQuantity.value = "";
		document.updateform.itemQuantity.focus();
	}
}

function itemNameCheck(tag){
	var itemN = document.updateform.itemName.value;
	//상품명이 10글자 이하
	if(itemN.length > 10){
		alert("상품명은 10글자 이하");
		document.updateform.itemName.value="";
		document.updateform.itemName.focus();
	}
}

</script>
</head>
<body>
<h2>상품수정페이지</h2>

<form name = "updateform" action="/socksShopping/updateItem" method="post" enctype="multipart/form-data">
	<label> 상품번호 : <input type = "text" name = "itemId" value ="itemId-*" onfocus="clearPlaceholder(this);" onblur ="itemIdCheck(this)"><br></label>
 	<label> 제품가격 : <input type = "number" name = "itemPrice" value = "10000" onfocus="clearPlaceholder(this);" onblur = "itemPriceCheck(this)"><br> </label> 원
 	<label> 전체제품수 : <input type ="number" name = "itemQuantity" value ="100" onfocus="clearPlaceholder(this);" onblur = "itemQuantityCheck(this)"><br> </label>
 	<label> 상품이름 : <input type = "text" name = "itemName" value ="상품명" onfocus="clearPlaceholder(this);" onblur = "itemNameCheck(this)" ><br> </label>
	<label> 메인이미지 : <input type="file" name="mainImage"><br> </label>
	<label> 상세이미지 : <input type="file" name="detailImage"><br> </label>
	<input type="submit" value="전송" onclick="return confirm('상품을 수정하시겠습니까?')">
</form>
</body>
</html>