package com.ajira.battelofmesoketes.exception;

public class TribeNotFoundException extends Exception {
	String message;

	public TribeNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}

}
