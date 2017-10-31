package com.socks.order.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.order.dao.OrderDao;
import com.socks.order.vo.Order;

public class OrderDaoImpl implements OrderDao{
	private static OrderDaoImpl instance;

	private OrderDaoImpl() {
	}

	public static OrderDaoImpl getInstance() {
		if (instance == null)
			instance = new OrderDaoImpl();
		return instance;
	}
	
	private String makeId(String id) {
		return "config.mapper.OrderMapper."+id;
	}
	
	
	@Override
	public int addOrder(SqlSession session, Order order) {
		return session.insert(makeId("insertOrder"), order);
	}

	@Override
	public int deleteOrderById(SqlSession session, String orderId) {
		return session.delete(makeId("deleteOrderById"), orderId);
	}

	@Override
	public List<Order> selectAllOrder(SqlSession session) {
		// TODO Auto-generated method stub
		return null;
	}

}
