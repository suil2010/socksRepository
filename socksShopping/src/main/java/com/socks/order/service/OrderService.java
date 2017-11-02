package com.socks.order.service;


import java.util.List;

import com.socks.member.vo.Member;
import com.socks.order.vo.Order;

public interface OrderService {

	//주문 추가 
	void addOrder(Order order);
	
	//주문 취소
	void removeOrder(String orderId);
	
	//맴버 id로 주문을 조회한다.
	Member findOrder(String memberId);
	
	//모든 주문 현황 보기
	List<Member> findAllOrder();
}
