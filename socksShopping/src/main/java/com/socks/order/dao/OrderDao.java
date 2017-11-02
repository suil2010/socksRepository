package com.socks.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.member.vo.Member;
import com.socks.order.vo.Order;

public interface OrderDao {
	/**
	    * 한 장바구니 정보를 insert 처리하는 메소드.
	    * 등록된 row 수를 리턴한다.
	    * @param session Transaction 처리는 Business Service 에서 하므로 TX 처리를 하는 객체(Connection/SqlSession)를 매개변수로 받는다. 
	    * @param Order 등록할 주문 정보
	    * @return 처리 결과 수
	    * 
	    */
	   int insertOrder(SqlSession session, Order order);
	   
	   /**
	    * orderId로 주문테이블의 row를 삭제 하는 메소드
	    * 삭제된 row 수를 리턴한다.
	    * @param session
	    * @param memberId
	    * @return
	    * 
	    */
	   int deleteOrderById(SqlSession session, String orderId);
	   
	   int updateOrderById(SqlSession session, Order order);
	   
	   /**
	    * 각 회원이 자신의 장바구니 정보를 싹 다 조회
	    */
	   Member selectAllOrderByJoin(SqlSession session,String memberId);
	   
	   /*
	    *  전체 주문현황을 본다.
	    */
	   List<Member> selectAllOrder(SqlSession session);
	    
}
