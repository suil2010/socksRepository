package com.socks.orderdetail;

import org.apache.ibatis.session.SqlSession;

import com.socks.orderdetail.vo.OrderDetail;

public interface OrderDetailDao {
	
	int insertOrderDetail(SqlSession session,OrderDetail orderDetail);
	
	int deleteOrderDetailById(SqlSession session, String orderDetailId);
}
