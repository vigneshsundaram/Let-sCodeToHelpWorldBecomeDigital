package com.ajira.battelofmesoketes.exception;

public class IllegalHeightException extends Exception {
	String message;
	public IllegalHeightException(String message) {
		this.message=message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
}
