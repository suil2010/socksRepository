package com.socks.order.service.impl;


import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.member.vo.Member;
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

	public void addOrder(Order order) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			
			dao.insertOrder(session, order);
			
			session.commit();
		}finally {
			session.close();
		}
	}

	@Override
	public void removeOrder(String orderId) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			
			dao.deleteOrderById(session, orderId);
			
			session.commit();
		}finally {
			session.close();
		}
		
	}
	
	public void ModifyOrder(Order order) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			dao.updateOrderById(session, order);
			session.commit();
		}finally {
			session.close();
		}
	}

	public Member findOrder(String memberId) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			Member member = dao.selectAllOrderByJoin(session, memberId);
			session.commit();
			return member;
		}finally {
			session.close();
		}
	}
	
	public List<Member> findAllOrder() {
		SqlSession session = null;
		try {
			session = factory.openSession();
			List<Member> list = dao.selectAllOrder(session);
			session.commit();
			return list;
		}finally {
			session.close();
		}

	}
	
	public Order findOrderById(String orderId) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			Order order = dao.selectOrderByJoin(session, orderId);
			session.commit();
			return order;
		}finally {
			session.close();
		}
	}

}
