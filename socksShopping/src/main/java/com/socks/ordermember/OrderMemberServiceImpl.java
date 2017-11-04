package com.socks.ordermember;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.orderdetail.OrderDetailDaoImpl;
import com.socks.ordermember.vo.OrderMember;
import com.socks.util.SqlSessionFactoryManager;

public class OrderMemberServiceImpl implements OrderMemberService{
	
	private static OrderMemberServiceImpl instance;
	
	private SqlSessionFactory factory;
	
	private OrderMemberDaoImpl dao;
	
	private SqlSession session =null;
	
	private OrderMemberServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = OrderMemberDaoImpl.getInstance();
	}

	public static OrderMemberServiceImpl getInstance() throws IOException {
		if (instance == null)
			instance = new OrderMemberServiceImpl();
		return instance;
	}
	
	@Override
	public void addOrderMember(OrderMember orderMember) {
		// TODO Auto-generated method stub
		try {
			session = factory.openSession();
			dao.insertOrderMember(session, orderMember);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void removeOrderMemberById(String orderNum) {
		// TODO Auto-generated method stub
		try {
			session = factory.openSession();
			dao.deleteOrderMemberById(session, orderNum);
			session.commit();
		} finally {
			session.close();
		}
	}
}
