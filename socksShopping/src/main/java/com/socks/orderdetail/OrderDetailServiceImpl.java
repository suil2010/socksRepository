package com.socks.orderdetail;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.order.dao.impl.OrderDaoImpl;
import com.socks.order.vo.Order;
import com.socks.orderdetail.vo.OrderDetail;
import com.socks.util.SqlSessionFactoryManager;

public class OrderDetailServiceImpl implements OrderDetailService{
	
	private static OrderDetailServiceImpl instance;
	
	private SqlSessionFactory factory;
	
	private OrderDetailDaoImpl dao;
	
	
	private SqlSession session =null;

	private OrderDetailServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = OrderDetailDaoImpl.getInstance();
		
	}

	public static OrderDetailServiceImpl getInstance() throws IOException {
		if (instance == null)
			instance = new OrderDetailServiceImpl();
		return instance;
	}
	
	public void addOrderDetail(OrderDetail orderDetail) {
		try {
			session = factory.openSession();
			dao.insertOrderDetail(session, orderDetail);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void removeOrderDetailById(String orderDetailId) {
		try {
			session = factory.openSession();
			dao.deleteOrderDetailById(session, orderDetailId);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	
	//주문상세에서 join된 item을 조회
	@Override
	public List<OrderDetail> findOrderDetail(String itemId) {
		try {
			session = factory.openSession();
			List<OrderDetail> order =dao.selectOrderDetailByJoin(session, itemId);
			session.commit();
			return order;
		} finally {
			session.close();
		}
	}
	
	
	
}
