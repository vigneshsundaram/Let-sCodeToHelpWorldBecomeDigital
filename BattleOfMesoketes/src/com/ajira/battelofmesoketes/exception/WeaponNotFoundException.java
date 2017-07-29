package com.ajira.battelofmesoketes.exception;

public class WeaponNotFoundException extends Exception {
	String message;

	public WeaponNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}

}
