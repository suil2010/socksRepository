package com.socks.orderdetail;

import java.util.List;

import com.socks.orderdetail.vo.OrderDetail;

public interface OrderDetailService {
	
	void addOrderDetail(OrderDetail orderDetail);
	
	void removeOrderDetailById(String orderDetailId);
	
	List<OrderDetail> findOrderDetail(String itemId);
}
