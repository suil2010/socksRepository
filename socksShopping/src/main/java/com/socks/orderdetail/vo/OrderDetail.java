package com.socks.orderdetail.vo;

import java.io.Serializable;

import com.socks.item.vo.Item;

//주문 상세 VO 클래스 
public class OrderDetail implements Serializable{
	private String orderDetailId; //주문상세번호
	private String orderNum; //주문번호
	private String itemId; //상품번호
	private int orderQuantity; //상품 주문 수
	private Item item;
	
	public OrderDetail() {}

	public OrderDetail(String orderDetailId, String orderNum, String itemId, int orderQuantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderNum = orderNum;
		this.itemId = itemId;
		this.orderQuantity = orderQuantity;
	}

	public OrderDetail(String orderDetailId, String orderNum, String itemId, int orderQuantity, Item item) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderNum = orderNum;
		this.itemId = itemId;
		this.orderQuantity = orderQuantity;
		this.item = item;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", orderNum=" + orderNum + ", itemId=" + itemId
				+ ", orderQuantity=" + orderQuantity + ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderDetailId == null) ? 0 : orderDetailId.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + orderQuantity;
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
		OrderDetail other = (OrderDetail) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (orderDetailId == null) {
			if (other.orderDetailId != null)
				return false;
		} else if (!orderDetailId.equals(other.orderDetailId))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (orderQuantity != other.orderQuantity)
			return false;
		return true;
	}
}
