package com.socks.ordermember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeMBeanException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;
import com.socks.orderdetail.OrderDetailServiceImpl;
import com.socks.orderdetail.vo.OrderDetail;
import com.socks.ordermember.vo.OrderMember;
import com.socks.util.SqlSessionFactoryManager;

public class OrderMemberServiceImpl implements OrderMemberService {

	private static OrderMemberServiceImpl instance;

	private SqlSessionFactory factory;

	private OrderMemberDaoImpl dao;
	// 장바구니 service
	private OrderServiceImpl service = OrderServiceImpl.getInstance();
	// 주문 상세 service
	private OrderDetailServiceImpl service1 = OrderDetailServiceImpl.getInstance();

	// SQLSession엣
	private SqlSession session = null;

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

	// 주문 처리과정 - service를 사용하여 각 session을 이용해야 한다.
	@Override
	public void orderProcessing(String[] orderId, String memberId) throws RuntimeException {
		// 1. 주문 테이블에 insert
		String orderNum = "orderNum-" + System.currentTimeMillis();
		// String orderNum, memberId, orderDate
		addOrderMember(new OrderMember(orderNum, memberId, new Date()));
		// 2. 주문 상세 테이블에 insert
		try {
			for (int i = 0; i < orderId.length; i++) {
				Order order = service.findOrderById(orderId[i]);
				System.out.println(order);
				// orderDetailId , orderNum, itemId, orderQuantity
				service1.addOrderDetail(new OrderDetail("orderDetailId" + System.currentTimeMillis(), orderNum,
						order.getItem().getItemId(), order.getOrderQuantity()));

				// 3. 장바구니 테이블에서 주문한 column을 삭제 -> 장바구니의 체크한 값이 사라짐 -> managerOrderList가 null을
				// 가짐
				service.removeOrder(orderId[i]);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public OrderMember findOrderMemberByNumJoin(String orderNum) {
		try {
			session = factory.openSession();
			OrderMember orderMember = dao.selectOrderMemberByNumJoin(session, orderNum);
			session.commit();
			return orderMember;
		} finally {
			session.close();
		}
	}

	@Override
	public String[] convertOrderNum(List<OrderDetail> list) throws RuntimeException {
		try {
			String[] orderNum = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				orderNum[i] = list.get(i).getOrderNum();
			}
			return orderNum;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void cancelOrderProcessing(String[] orderDetailIdList) throws RuntimeException{
		try {
			for(int j = 0; j < orderDetailIdList.length ; j++) {
				service1.removeOrderDetailById(orderDetailIdList[j]);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
