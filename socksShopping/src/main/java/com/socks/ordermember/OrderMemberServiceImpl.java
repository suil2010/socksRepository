package com.socks.ordermember;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.order.dao.impl.OrderDaoImpl;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;
import com.socks.orderdetail.OrderDetailDaoImpl;
import com.socks.orderdetail.OrderDetailServiceImpl;
import com.socks.orderdetail.vo.OrderDetail;
import com.socks.ordermember.vo.OrderMember;
import com.socks.util.SqlSessionFactoryManager;

public class OrderMemberServiceImpl implements OrderMemberService{
	
	private static OrderMemberServiceImpl instance;
	
	private SqlSessionFactory factory;
	
	private OrderMemberDaoImpl dao;
	//장바구니 service
	private OrderServiceImpl service = OrderServiceImpl.getInstance();
	//주문 상세 service
	private OrderDetailServiceImpl service1 = OrderDetailServiceImpl.getInstance();
	
	//SQLSession엣
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
	
		//주문 처리과정 - service를 사용하여 각 session을 이용해야 한다.
		@Override
		public void orderProcessing(String[] orderId,String memberId) {
			//1. 주문 테이블에 insert
			String orderNum = "orderNum-"+System.currentTimeMillis();
			// String orderNum, memberId, orderDate
			addOrderMember(new OrderMember(orderNum,memberId,new Date()));
			//2. 주문 상세 테이블에 insert
			try {
			for(int i = 0 ; i < orderId.length ; i++) {
				Order order = service.findOrderById(orderId[i]);
				System.out.println(order);
				// orderDetailId , orderNum, itemId, orderQuantity
				service1.addOrderDetail(new OrderDetail("orderDetailId"+System.currentTimeMillis(),
						orderNum, order.getItem().getItemId() ,order.getOrderQuantity()));
				
				//3. 장바구니 테이블에서 주문한  column을 삭제
				service.removeOrder(orderId[i]);
				}
			} catch(Exception e) {
				
			}
		}
}
