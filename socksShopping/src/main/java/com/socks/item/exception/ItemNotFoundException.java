package com.socks.item.exception;

public class ItemNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	private String failId; 

	public ItemNotFoundException() {
	}

	public ItemNotFoundException(String message) {
		super(message);
	}

	public ItemNotFoundException(String message, String failId) {
		super(message);
		this.failId = failId;
	}

	public String getFailId() {
		return failId;
	}

}
