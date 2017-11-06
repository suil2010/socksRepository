package com.socks.ordermember.dao;

import org.apache.ibatis.session.SqlSession;

import com.socks.ordermember.vo.OrderMember;

public interface OrderMemberDao {
	
	int insertOrderMember(SqlSession session,OrderMember orderMember);
	
	int deleteOrderMemberById(SqlSession session, String orderNum);
	//주문을 조회 OrderMember에 해당하는 OrderDetail과 item을 조회
	OrderMember selectOrderMemberByNumJoin(SqlSession session, String orderNum);
}
