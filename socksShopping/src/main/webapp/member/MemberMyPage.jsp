<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="${initParam.rootPath }/css/css.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div class="mypage">
	<h4>${sessionScope.loginMember.name }님의 MY PAGE</h4>
	<div class="mypage_box">
		<table>
			<tr>
				<td>
					<a href="/socksShopping/member/MemberShowView.jsp">
						<div onmouseover='document.getElementById("img").src ="${initParam.rootPath}/img/mypage1.jpg"'>내 정보</div>
					</a>
				</td>
				<td>
					<a href="/socksShopping/order/shopingBasketView.jsp">
						<div onmouseover='document.getElementById("img").src ="${initParam.rootPath}/img/mypage2.jpg"'>장바구니</div>
					</a>
				</td>
				<td>
					<a href="/socksShopping/order/orderInfoView.jsp">
						<div onmouseover='document.getElementById("img").src ="${initParam.rootPath}/img/mypage3.jpg"'>주문정보</div>
					</a>
				</td>
			</tr>
		</table>
		<h5>${sessionScope.loginMember.memberId }님의 포인트는 ${sessionScope.loginMember.point } 점 입니다.</h5>
		<div class="mypage_img">
			<img id="img" alt="mypage_img" src="${initParam.rootPath }/img/mypage1.jpg" style="margin-top: -100px;">
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>