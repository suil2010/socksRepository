package com.socks.orderdetail.vo;

import java.io.Serializable;

//주문 상세 VO 클래스 
public class OrderDetail implements Serializable{
	private String orderDetailId; //주문상세번호
	private String orderNum; //주문번호
	private String itemId; //상품번호
	private int orderQuantity; //상품 주문 수
	private int itemPrice; //상품 가격
	private String itemName; //상품 이름
	private String mainCut; //상품 메인 이미지
	
	public OrderDetail() {}

	public OrderDetail(String orderDetailId, String orderNum, String itemId, int orderQuantity, int itemPrice,
			String itemName, String mainCut) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderNum = orderNum;
		this.itemId = itemId;
		this.orderQuantity = orderQuantity;
		this.itemPrice = itemPrice;
		this.itemName = itemName;
		this.mainCut = mainCut;
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

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getmainCut() {
		return mainCut;
	}

	public void setmainCut(String mainCut) {
		this.mainCut = mainCut;
	}

	@Override
	public String toString() {
		return "orderDetail [orderDetailId=" + orderDetailId + ", orderNum=" + orderNum + ", itemId=" + itemId
				+ ", orderQuantity=" + orderQuantity + ", itemPrice=" + itemPrice + ", itemName=" + itemName
				+ ", mainCut=" + mainCut + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + itemPrice;
		result = prime * result + ((mainCut == null) ? 0 : mainCut.hashCode());
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
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPrice != other.itemPrice)
			return false;
		if (mainCut == null) {
			if (other.mainCut != null)
				return false;
		} else if (!mainCut.equals(other.mainCut))
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
