package com.te.accountapp.service;

public class AmountNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "AmountNotValidException [message=" + message + "]";
	}
	
	
}
