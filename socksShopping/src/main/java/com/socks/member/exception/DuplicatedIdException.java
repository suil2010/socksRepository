package com.socks.member.exception;


public class DuplicatedIdException extends Exception {
	private static final long serialVersionUID = 1L;

	private String duplicatedId;

	public DuplicatedIdException() {
	}

	public DuplicatedIdException(String message) {
		super(message);
	}

	public DuplicatedIdException(String message, String duplicatedId) {
		super(message);
		this.duplicatedId = duplicatedId;
	}

	public String getDuplicatedId() {
		return duplicatedId;
	}

}
