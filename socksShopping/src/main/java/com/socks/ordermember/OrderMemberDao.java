package com.socks.ordermember;

import org.apache.ibatis.session.SqlSession;

import com.socks.ordermember.vo.OrderMember;

public interface OrderMemberDao {
	
	int insertOrderMember(SqlSession session,OrderMember orderMember);
	
	int deleteOrderMemberById(SqlSession session, String orderNum);
}
