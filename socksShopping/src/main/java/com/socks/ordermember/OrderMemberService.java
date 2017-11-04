package com.socks.ordermember;

import com.socks.ordermember.vo.OrderMember;

public interface OrderMemberService {
	void addOrderMember(OrderMember orderMember);
	
	void removeOrderMemberById(String orderNum);
}
