package com.stockmanagement.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.hamcrest.CoreMatchers;

import com.stockmanagement.exception.IllegalOperation;
import com.stockmanagement.exception.InvalidStockQuantity;
import com.stockmanagement.exception.OrderNotFound;
import com.stockmanagement.main.StockManager;
import com.stockmanagement.stock.Stock;
import com.stockmanagement.stockexchange.Order;
import com.stockmanagement.stockexchange.StockExchange;

import junit.framework.Assert;

public  class StockExchangeTest  {
	static StockExchange stockExchnage;
	static Stock stock;
	Order order;
	
	@BeforeClass
	public static void setup() throws InvalidStockQuantity
	{
		stockExchnage=stockExchnage.getStockExchnage();
		stock=Stock.getStock();
		
	}
	
	@Test(expected=InvalidStockQuantity.class)
	public void testExecuteOrderForInvalidQuantity() throws InvalidStockQuantity
	{  	
		StockManager.getOrders().clear();
		order = Order.getOrder("sell", 10);
		StockManager.setOrder(stock.getCompanyName(), order);
		order=Order.getOrder("buy", -20);
		stockExchnage.executeOrder(order, stock);
	}
	@Test
	public void testExecuteOrderForvalidQuantity() throws InvalidStockQuantity
	{	
		StockManager.getOrders().clear();
		order = Order.getOrder("sell", 10);
		StockManager.setOrder(stock.getCompanyName(), order);
		order=Order.getOrder("buy", 20);
		int actualQuantity = stockExchnage.executeOrder(order, stock);
		Assert.assertEquals(10, actualQuantity);
	}
	@Test
	public void aTestExecuteOrderForvalidQuantityForFirstOrder() throws InvalidStockQuantity
	{
		order=Order.getOrder("buy", 20);
		StockManager.getOrders().clear();
		int actualQuantity = stockExchnage.executeOrder(order, stock);
		Assert.assertEquals(0, actualQuantity);
	}
	@Test
	public void testIsOrderAlreadyExistsWhenOrderExists() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InvalidStockQuantity, OrderNotFound
	{
		StockManager.getOrders().clear();
		Method isOrderAlreadyExists=stockExchnage.getClass().getDeclaredMethod("isOrderAlreadyExists", new  Class[]{Order.class,Order.class});	
		isOrderAlreadyExists.setAccessible(true);
		order = Order.getOrder("sell", 10);
		StockManager.setOrder(stock.getCompanyName(),Order.getOrder("Sell", 10));
		boolean actualValue = (boolean) isOrderAlreadyExists.invoke(stockExchnage,new Object[]{order, StockManager.getOrder(stock.getCompanyName())});
		Assert.assertTrue(actualValue);
	}
	@Test
	public void testIsOrderAlreadyExistsWhenOrderNotExists() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InvalidStockQuantity, OrderNotFound
	{	
		StockManager.getOrders().clear();
		Method isOrderAlreadyExists=stockExchnage.getClass().getDeclaredMethod("isOrderAlreadyExists", new  Class[]{Order.class,Order.class});	
		isOrderAlreadyExists.setAccessible(true);
		order = Order.getOrder("sell", 10);
		StockManager.setOrder(stock.getCompanyName(),Order.getOrder("Buy", 10));
		boolean actualValue = (boolean) isOrderAlreadyExists.invoke(stockExchnage,new Object[]{order, StockManager.getOrder(stock.getCompanyName())});
		Assert.assertFalse(actualValue);
	}
	@Test
	public void testGetStockExchange() throws InvalidStockQuantity
	{
		StockExchange stockExchange = StockExchange.getStockExchnage();
		Assert.assertTrue(stockExchange instanceof StockExchange);
		
	}
	
}