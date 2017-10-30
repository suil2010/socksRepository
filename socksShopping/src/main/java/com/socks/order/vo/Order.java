package com.socks.order.vo;

public class Order {
	private String orderId;
	private String orderQuantity;
	private String memberId;
	private String itemId;
	public Order() {
	}
	public Order(String orderId, String orderQuantity, String memberId, String itemId) {
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.memberId = memberId;
		this.itemId = itemId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(String orderQuantity) {
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
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderQuantity=" + orderQuantity + ", memberId=" + memberId + ", itemId="
				+ itemId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderQuantity == null) ? 0 : orderQuantity.hashCode());
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
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderQuantity == null) {
			if (other.orderQuantity != null)
				return false;
		} else if (!orderQuantity.equals(other.orderQuantity))
			return false;
		return true;
	}
	
}
