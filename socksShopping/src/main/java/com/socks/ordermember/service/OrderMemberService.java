package com.socks.ordermember.service;

import java.util.List;

import com.socks.orderdetail.vo.OrderDetail;
import com.socks.ordermember.vo.OrderMember;

public interface OrderMemberService {
	void addOrderMember(OrderMember orderMember);
	
	void removeOrderMemberById(String orderNum);
	
	//주문을 조회, OrderMember에 해당하는 OrderDetail과 item을 조회
	OrderMember findOrderMemberByNumJoin(String orderNum);
	
	//주문을 처리하는 메소드
	void orderProcessing(String[] orderId,String memberId);
	//주문 취소하는 메소드
	void cancelOrderProcessing(String[] orderDetailId);
	
	String[] convertOrderNum(List<OrderDetail> list) throws RuntimeException;
}
