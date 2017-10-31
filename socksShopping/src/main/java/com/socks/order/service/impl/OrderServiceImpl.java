package com.socks.order.service.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.order.dao.OrderDao;
import com.socks.order.dao.impl.OrderDaoImpl;
import com.socks.order.service.OrderService;
import com.socks.order.vo.Order;
import com.socks.util.SqlSessionFactoryManager;

public class OrderServiceImpl implements OrderService{
	private SqlSessionFactory factory;
	private OrderDao dao;
	private static OrderServiceImpl instance;

	private OrderServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = OrderDaoImpl.getInstance();
	}

	public static OrderServiceImpl getInstance() throws IOException {
		if (instance == null)
			instance = new OrderServiceImpl();
		return instance;
	}

	public void insertOrder(Order order) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			
			dao.addOrder(session, order);
			
			session.commit();
		}finally {
			session.close();
		}
	}

}
