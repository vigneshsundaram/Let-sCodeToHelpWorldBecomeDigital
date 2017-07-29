package com.stockmanagement.exception;

public class StockNotFound extends Exception {
	String exceptionMessage;
	public StockNotFound(String message) {
	exceptionMessage=message;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return exceptionMessage;
		}
	}
