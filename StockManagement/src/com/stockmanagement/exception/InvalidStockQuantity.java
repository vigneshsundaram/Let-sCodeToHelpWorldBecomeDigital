package com.stockmanagement.exception;

public class InvalidStockQuantity extends Exception {
String exceptionMessage;
public InvalidStockQuantity(String message) {
exceptionMessage=message;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return exceptionMessage;
	}
}
