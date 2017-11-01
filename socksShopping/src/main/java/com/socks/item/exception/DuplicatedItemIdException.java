package com.socks.item.exception;


public class DuplicatedItemIdException extends Exception {
	private static final long serialVersionUID = 1L;

	private String DuplicatedItemId;

	public DuplicatedItemIdException() {
	}

	public DuplicatedItemIdException(String message) {
		super(message);
	}

	public DuplicatedItemIdException(String message, String DuplicatedItemId) {
		super(message);
		this.DuplicatedItemId = DuplicatedItemId;
	}

	public String DuplicatedItemId() {
		return DuplicatedItemId;
	}

}
