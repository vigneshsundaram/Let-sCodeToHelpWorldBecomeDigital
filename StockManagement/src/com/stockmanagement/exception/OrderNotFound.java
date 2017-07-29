package com.stockmanagement.exception;

public class OrderNotFound extends Exception {
	String exceptionMessage;
	public OrderNotFound(String message) {
	exceptionMessage=message;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return exceptionMessage;
		}
	}
