package com.socks.orderdetail;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.orderdetail.vo.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao{
	private static OrderDetailDaoImpl instance;

	private OrderDetailDaoImpl() {

	}

	public static OrderDetailDaoImpl getInstance() {
		if (instance == null)
			instance = new OrderDetailDaoImpl();
		return instance;
	}
	
	public String makeSqlId(String id) {
		return "config.mapper.orderDetailMapper." + id;
	}
	
	public int insertOrderDetail(SqlSession session,OrderDetail orderDetail) {
		return session.insert(makeSqlId("insertOrderDetail"),orderDetail);
	}
	
	public int deleteOrderDetailById(SqlSession session, String orderDetailId) {
		return session.delete(makeSqlId("deleteOrderDetailById"),orderDetailId);
	}

	@Override
	public List<OrderDetail> selectOrderDetailByJoin(SqlSession session, String itemId) {
		return session.selectList(makeSqlId("selectOrderDetailByJoin"),itemId);
	}
}
