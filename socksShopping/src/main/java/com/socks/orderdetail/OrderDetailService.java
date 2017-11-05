package com.socks.orderdetail;

import java.util.List;

import com.socks.orderdetail.vo.OrderDetail;

public interface OrderDetailService {
	
	//주문 상세 column 추가
	void addOrderDetail(OrderDetail orderDetail);
	//주문 상세 column 삭제
	void removeOrderDetailById(String orderDetailId);
	//주문 상세 조회 - itemId로
	List<OrderDetail> findOrderDetail(String itemId);
	//주문 상세 조회 - orderDetailId로
	OrderDetail findOrderDetailOne(String orderDetailId);
	//주문 상세 조회 - orderDetailId로 join item
	OrderDetail findOrderDetailJoinItem(String orderDetaiId);
}
