package com.socks.member.vo;

import java.io.Serializable;
import java.util.List;

import com.socks.order.vo.Order;

public class Member implements Serializable{
	private String memberId;
	private String name;
	private String password;
	private String address;
	private String email;
	private int point;
	private List<Order> orderList;
	
	public Member() {
	}

	public Member(String memberId, String name, String password, String address, String email, int point,
			List<Order> orderList) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.point = point;
		this.orderList = orderList;
	}

	public Member(String memberId, String name, String password, String address, String email, int point) {
		this.memberId = memberId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.point = point;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", email=" + email + ", point=" + point + ", orderList=" + orderList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderList == null) ? 0 : orderList.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + point;
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
		Member other = (Member) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderList == null) {
			if (other.orderList != null)
				return false;
		} else if (!orderList.equals(other.orderList))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (point != other.point)
			return false;
		return true;
	}

}
