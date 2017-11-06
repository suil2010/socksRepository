package com.socks.orderdetail.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.orderdetail.vo.OrderDetail;

public interface OrderDetailDao {
	
	int insertOrderDetail(SqlSession session,OrderDetail orderDetail);
	
	int deleteOrderDetailById(SqlSession session, String orderDetailId);
	
	//itemId를 가지고 있는 상품을 값 조회 -> orderDetail에 item정보를 조회
	List<OrderDetail> selectOrderDetailByJoin(SqlSession session, String itemId);
	
	//orderDetailId로 orderDetail조회
	OrderDetail selectOrderDetail(SqlSession session, String orderDetailId);
	
	//orderDetailid로 orderDetail과 item의 정보를 조회
	OrderDetail selectOrderDetailByIdJoin(SqlSession session, String orderDetailId);
}
