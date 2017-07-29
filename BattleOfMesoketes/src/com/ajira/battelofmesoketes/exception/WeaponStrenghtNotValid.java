package com.ajira.battelofmesoketes.exception;

public class WeaponStrenghtNotValid extends Exception {
	String message;

	public WeaponStrenghtNotValid(String message) {
		this.message=message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
}
