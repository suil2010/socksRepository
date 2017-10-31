package com.socks.member.exception;

public class MemberNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	private String failId; 

	public MemberNotFoundException() {
	}

	public MemberNotFoundException(String message) {
		super(message);
	}

	public MemberNotFoundException(String message, String failId) {
		super(message);
		this.failId = failId;
	}

	public String getFailId() {
		return failId;
	}

}
