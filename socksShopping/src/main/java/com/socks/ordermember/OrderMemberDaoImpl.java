package com.socks.ordermember;

import org.apache.ibatis.session.SqlSession;

import com.socks.ordermember.vo.OrderMember;

public class OrderMemberDaoImpl implements OrderMemberDao{
	
	private static OrderMemberDaoImpl instance;

	private OrderMemberDaoImpl() {

	}

	public static OrderMemberDaoImpl getInstance() {
		if (instance == null)
			instance = new OrderMemberDaoImpl();
		return instance;
	}
	
	public String makeSqlId(String id) {
		return "config.mapper.orderMemberMapper." + id;
	}
	
	public int insertOrderMember(SqlSession session,OrderMember orderMember) {
		return session.insert(makeSqlId("insertOrderMember"),orderMember);
	}
	
	public int deleteOrderMemberById(SqlSession session, String orderNum) {
		return session.delete(makeSqlId("deleteOrderMemberById"),orderNum);
	}

	@Override
	public OrderMember selectOrderMemberByNumJoin(SqlSession session, String orderNum) {
		return session.selectOne(makeSqlId("selectOrderMemberByNumJoin"),orderNum);
	}
	
}
