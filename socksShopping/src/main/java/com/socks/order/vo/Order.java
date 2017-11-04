package com.socks.order.vo;

import java.io.Serializable;
import java.util.Date;

import com.socks.item.vo.Item;

public class Order implements Serializable{
	private String orderId;
	private int orderQuantity;
	private String memberId;
	private String itemId;
	private Date orderDate;
	private Item item;
	
	public Order() {
	}

	public Order(String orderId, int orderQuantity, String memberId, String itemId, Date orderDate) {
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.memberId = memberId;
		this.itemId = itemId;
		this.orderDate = orderDate;
	}

	public Order(String orderId, int orderQuantity, String memberId, String itemId, Date orderDate, Item item) {
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.memberId = memberId;
		this.itemId = itemId;
		this.orderDate = orderDate;
		this.item = item;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderQuantity=" + orderQuantity + ", memberId=" + memberId + ", itemId="
				+ itemId + ", orderDate=" + orderDate + ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		Order other = (Order) obj;
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
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderQuantity != other.orderQuantity)
			return false;
		return true;
	}
}
