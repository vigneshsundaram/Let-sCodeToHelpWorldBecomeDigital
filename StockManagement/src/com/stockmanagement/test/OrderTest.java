package com.stockmanagement.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.stockmanagement.exception.InvalidStockQuantity;
import com.stockmanagement.stockexchange.Order;

import junit.framework.Assert;

public class OrderTest {
	static Order order;
	@BeforeClass
	public static  void setup() throws InvalidStockQuantity {
		order=Order.getOrder("Sell", 10);
	}	
	@Test
	public void testSetQuantityForValidQuantity() throws InvalidStockQuantity
	{
		order.setQuantity(20);
		Assert.assertEquals(20, order.getQuantity());
	}
	@Test(expected=InvalidStockQuantity.class)
	public void testSetQuantityForInValidQuantity() throws InvalidStockQuantity
	{
		order.setQuantity(-20);
		Assert.assertEquals(20, order.getQuantity());
	}
	
	@Test
	public void testGetQuantity() throws InvalidStockQuantity
	{
		order.setQuantity(20);
		int actualQuantity = order.getQuantity();
		Assert.assertEquals(20, actualQuantity);
	}
	
	@Test
	public void testSetOrderType() throws InvalidStockQuantity
	{
		order.setOrderType("Sell");
		Assert.assertEquals("Sell", order.getOrderType());
	}
	
	@Test
	public void testGetOrderType() throws InvalidStockQuantity
	{
		order.setOrderType("Sell");
		Assert.assertEquals("Sell", order.getOrderType());
	}
	@Test
	public void testGetOrder() throws InvalidStockQuantity
	{
		Order order = Order.getOrder("Sell", 10);
		Assert.assertTrue(order instanceof Order);
		
	}
	
}
