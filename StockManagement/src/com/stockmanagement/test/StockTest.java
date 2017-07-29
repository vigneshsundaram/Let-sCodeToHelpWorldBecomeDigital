package com.stockmanagement.test;

import org.junit.Before;
import org.junit.Test;

import com.stockmanagement.exception.IllegalOperation;
import com.stockmanagement.exception.InvalidStockQuantity;
import com.stockmanagement.stock.Stock;
import com.stockmanagement.stockexchange.StockExchange;

import junit.framework.Assert;

public class StockTest {
Stock stock;

	@Before
	public  void setup() {
		stock=Stock.getStock();
	}
	
	@Test
	public void testGetStockID()
	{
		int stockId=1;
		stock.setStockID(stockId);
		int actualStockID = stock.getStockID();
		Assert.assertEquals(stockId, actualStockID);
		
	}
	
	@Test
	public void testSetStockID()
	{
		int stockId=1;
		stock.setStockID(stockId);
		int actualStockID = stock.getStockID();
		Assert.assertEquals(stockId, actualStockID);
		
	}
	
	@Test
	public void testGetCompanyName()
	{
		String companyName="Sahaj";
		stock.setCompanyName(companyName);
		String actualCompanyName = stock.getCompanyName();
		
		Assert.assertEquals(companyName, actualCompanyName);
	}
	
	@Test
	public void testSetCompanyName()
	{
		String companyName="Sahaj";
		stock.setCompanyName(companyName);
		String actualCompanyName= stock.getCompanyName();
		Assert.assertEquals(companyName, actualCompanyName);
		
	}
	
	@Test
	public void testSetQuantity() throws InvalidStockQuantity
	{
		int quantity=10;
		stock.setQuantity(quantity);
		int actualQuantity = stock.getQuantity();
		Assert.assertEquals(quantity	, actualQuantity);
		
	}
	
	@Test(expected=InvalidStockQuantity.class)
	public void testSetQuantitytWithInvalidQuantity() throws InvalidStockQuantity
	{
		int quantity=-1;
		stock.setQuantity(quantity);
		
	}
	
	@Test
	public void testGetQuantity() throws InvalidStockQuantity
	{
		int quantity=10;
		stock.setQuantity(quantity);
		int actualQuantity = stock.getQuantity();
		Assert.assertEquals(quantity,actualQuantity);
		
	}
	
	
	@Test
	public void testIsValidStock()
	{
		int stockQuantity=10;
		boolean expectedValue=true;
		boolean actualIsvalid= stock.isValidStockQuantity(stockQuantity);
				Assert.assertTrue(actualIsvalid);
	}
	
	@Test
	public void testSetStockDetails() throws InvalidStockQuantity, IllegalOperation
	{
		String [] details={"1","Buy","ABC","10"};
		stock.setStockDetails(details);
		
	}
	@Test
	public void testGetStock() throws InvalidStockQuantity
	{
		Stock stock = Stock.getStock();
		Assert.assertTrue(stock instanceof Stock);
		
	}
}
