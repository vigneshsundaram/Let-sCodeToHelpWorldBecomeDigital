package com.ajira.battelofmesoketes.exception;

public class StrategyNotFoundException extends Exception {
	String message;

	public StrategyNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}

}
