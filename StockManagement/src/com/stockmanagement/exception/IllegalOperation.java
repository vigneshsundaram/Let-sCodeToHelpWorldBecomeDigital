package com.stockmanagement.exception;

public class IllegalOperation extends Exception {
String exceptionMessage;
public IllegalOperation(String message) {
exceptionMessage=message;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return exceptionMessage;
	}
}
