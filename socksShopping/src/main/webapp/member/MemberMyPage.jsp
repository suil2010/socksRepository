<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
${sessionScope.loginMember.memberId }님의 포인트는 ${sessionScope.loginMember.point } 점 입니다.

<p>
<a href="/socksShopping/member/MemberShowView.jsp">나의 정보</a>
</p>

<p>
<a href="/socksShopping/order/shopingBasketView.jsp">장바구니</a>
</p>

<p>
<a href="/socksShopping/order/orderInfoView.jsp">주문정보 조회</a>
</p>


</body>
</html>