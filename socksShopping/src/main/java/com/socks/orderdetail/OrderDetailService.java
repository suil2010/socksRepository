package com.socks.orderdetail;

import com.socks.orderdetail.vo.OrderDetail;

public interface OrderDetailService {
	
	void addOrderDetail(OrderDetail orderDetail);
	
	void removeOrderDetailById(String orderDetailId);
}
