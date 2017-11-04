package com.socks.orderdetail;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.orderdetail.vo.OrderDetail;

public interface OrderDetailDao {
	
	int insertOrderDetail(SqlSession session,OrderDetail orderDetail);
	
	int deleteOrderDetailById(SqlSession session, String orderDetailId);
	
	//itemId를 가지고 있는 상품을 값 조회
	List<OrderDetail> selectOrderDetailByJoin(SqlSession session, String itemId);   
}
