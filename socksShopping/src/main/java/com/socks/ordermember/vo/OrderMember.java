package com.socks.ordermember.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.socks.orderdetail.vo.OrderDetail;

//주문 VO 클래스
public class OrderMember implements Serializable{
	private String orderNum; //주문번호
	private String memberId; //회원ID
	private Date orderDate; //주문 날짜
	private List<OrderDetail> orderDetailList; //주문 상품 리스트
	
	public OrderMember() {}

	public OrderMember(String orderNum, String memberId, Date orderDate) {
		super();
		this.orderNum = orderNum;
		this.memberId = memberId;
		this.orderDate = orderDate;
	}
	
	public OrderMember(String orderNum, String memberId, Date orderDate, List<OrderDetail> orderDetailList) {
		super();
		this.orderNum = orderNum;
		this.memberId = memberId;
		this.orderDate = orderDate;
		this.orderDetailList = orderDetailList;
	}

	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getorderDate() {
		return orderDate;
	}
	public void setorderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@Override
	public String toString() {
		return "orderMember [orderNum=" + orderNum + ", memberId=" + memberId + ", orderDate=" + orderDate + ", orderDetailList="
				+ orderDetailList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((orderDetailList == null) ? 0 : orderDetailList.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderMember other = (OrderMember) obj;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (orderDetailList == null) {
			if (other.orderDetailList != null)
				return false;
		} else if (!orderDetailList.equals(other.orderDetailList))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		return true;
	}
	
}
