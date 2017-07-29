package com.ajira.battelofmesoketes.exception;

public class WallNotFoundException extends Exception {
	String message;

	public WallNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
}
