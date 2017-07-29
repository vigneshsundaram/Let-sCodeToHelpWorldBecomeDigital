package com.stockmanagement.stockexchange;

import com.stockmanagement.exception.InvalidStockQuantity;

public class Order {
String orderType=null;
int quantity=0;
	/**
	 * Constructor of Order class
	 * @param orderType
	 * @param quantity
	 * @throws InvalidStockQuantity
	 */
	public Order(String orderType, int quantity) throws InvalidStockQuantity {
		if(quantity>=0)
		{
		this.orderType=orderType;
		this.quantity=quantity;
		}
		else
		{
			throw new InvalidStockQuantity("Invalid quantity");
		}
		}
	/**
	 * Returns the order type
	 * @return {@link String}
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * Sets the order type
	 * @param orderType
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * Returns the quantity of stock to be processed 
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Sets quantity of the stock to be processed
	 * @param quantity
	 * @throws InvalidStockQuantity
	 */
	public void setQuantity(int quantity) throws InvalidStockQuantity {
		if(quantity>=0)
		{
		this.quantity = quantity;
		}
		else
		{
			throw new InvalidStockQuantity("Invalid quantity");
		}
		}
	public static Order getOrder(String OrderType,int quantity) throws InvalidStockQuantity
	{
	return new Order(OrderType,quantity);
	}

}
