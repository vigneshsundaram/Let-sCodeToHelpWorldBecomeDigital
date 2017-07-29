package com.stockmanagement.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.management.InstanceAlreadyExistsException;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.stockmanagement.exception.EmptyFile;
import com.stockmanagement.exception.IllegalOperation;
import com.stockmanagement.exception.InvalidStockQuantity;
import com.stockmanagement.exception.OrderNotFound;
import com.stockmanagement.main.StockManager;
import com.stockmanagement.stock.Stock;
import com.stockmanagement.stockexchange.Order;

public class StockManagerTest {
	static StockManager stockManager;
	static Method fileOperations;
	static Method getStocks;
	static Method getStock;
	static Method isOpenOrClose;
	static Method writeIntoOutputFile;
	static Class<StockManager>stockManagerClass;
	static Method createOutputFileAndOutputStream;
	static Method inputReader;
	static Method  readInputFileIntoStream;
	
	@BeforeClass
	public static void setp() throws NoSuchMethodException, SecurityException {
		stockManager=StockManager.getStockManager();
		stockManagerClass=StockManager.class;
		fileOperations=stockManagerClass.getDeclaredMethod("fileOperations", String.class);
		getStock=stockManagerClass.getDeclaredMethod("getStock", String.class);
		getStocks=stockManagerClass.getDeclaredMethod("getStocks");
		isOpenOrClose=stockManagerClass.getDeclaredMethod("isOpenORClose",int.class);
		createOutputFileAndOutputStream=stockManagerClass.getDeclaredMethod("createOutputFileAndOutputStream");
		inputReader=stockManagerClass.getDeclaredMethod("inputReader");
		readInputFileIntoStream=stockManagerClass.getDeclaredMethod("readInputFileIntoStream", String.class);
		writeIntoOutputFile=stockManagerClass.getDeclaredMethod("writeIntoOutputFile");
		fileOperations.setAccessible(true);
		getStock.setAccessible(true);
		getStocks.setAccessible(true);
		isOpenOrClose.setAccessible(true);
		writeIntoOutputFile.setAccessible(true);
		createOutputFileAndOutputStream.setAccessible(true);
		inputReader.setAccessible(true);
		readInputFileIntoStream.setAccessible(true);
	}
	
	@Test
	public void testGetStockManager()
	{
		
		Assert.assertTrue( StockManager.getStockManager() instanceof StockManager);
	}
	
	@Test(expected=InvocationTargetException.class)
	public  void testFileOperationsWhenInvalidFilePathPassed() throws  IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		String input="c:/Temp/input.csv";
		fileOperations.invoke(null,input);
	}
	
	@Test
	public  void testFileOperationsWhenValidFilePathPassed() throws  IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, InvalidStockQuantity, IllegalOperation
	{
		inputReader.invoke(null, null);
		String input="./input.csv";
		fileOperations.invoke(null,input);
		File outputFile=new File("./output.csv");
		Assert.assertTrue(outputFile.exists());
	}
	
	
	@Test 
	public void testGetStocks() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		 Object invoke = getStocks.invoke(null, null);
		 Assert.assertThat(invoke, IsInstanceOf.instanceOf(Map.class));
	
	}
	@Test 
	public void testGetStockWhenStockAvailable() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	Stock stock=new Stock();
		String companyName="Test";
		Object invoke = getStocks.invoke(null, null);
		Map<String, Stock>stocks=(Map<String, Stock>) invoke;
		stocks.put(companyName.toUpperCase(), stock);
		Object actual = getStock.invoke( null,companyName);
		Assert.assertThat(actual,IsInstanceOf.instanceOf(Stock.class));
	
	}
	@Test(expected=InvocationTargetException.class) 
	public void testGetStockWhenStockNotAvailable() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	Stock stock=new Stock();
		String companyName="Test";
		Object invoke = getStocks.invoke(null, null);
		Map<String, Stock>stocks=(Map<String, Stock>) invoke;
		stocks.clear();
		Object actual = getStock.invoke( null,companyName);
	
	}
	@Test
	public void testIsOpenORCloseWhenQuantityGreaterThanZero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		int qunatity=5;
		String actual = (String) isOpenOrClose.invoke(null, qunatity);
		Assert.assertEquals("Opened", actual);
	}
	@Test
	public void testIsOpenORCloseWhenQuantityEqualThanZero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		int qunatity=0;
		String actual = (String) isOpenOrClose.invoke(null, qunatity);
		Assert.assertEquals("Closed", actual);
	}
	@Test
	public void testCreateOutputFileAndOutputStream() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException
	{    Field outputFileWriter = stockManagerClass.getDeclaredField("outputFileWriter");
	Field outputWriter = stockManagerClass.getDeclaredField("outputWriter");
		createOutputFileAndOutputStream.invoke(null, null);
		File file=new File("./output.csv");
		outputFileWriter.setAccessible(true);
		outputWriter.setAccessible(true);
		Assert.assertTrue(file.exists()&&outputFileWriter!=null&&outputWriter!=null);
	}
	@Test
	public void testInputReader() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{ 
		String filePath = (String) inputReader.invoke(null, null);
		Assert.assertTrue(new File(filePath).isFile());
	}
	@Test
	public void testReadInputFileIntoStream() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException
	{
		Field inputFileReader = stockManagerClass.getDeclaredField("inputFileReader");
		Field inputReader = stockManagerClass.getDeclaredField("inputReader");
		inputFileReader.setAccessible(true);
		inputReader.setAccessible(true);
		String filePath = (String) readInputFileIntoStream.invoke(null,"./input.csv");
		Assert.assertTrue(inputFileReader!=null&&inputReader!=null);
	}
	
	@Test(expected=InvocationTargetException.class)
	public void testWriteIntoOutputFileForEmptyInputFile() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException
	{ 
	
		String input="./EmptyInput.csv";
		fileOperations.invoke(null,input);
	}
	@Test
	public void testWriteIntoOutputFileForInputFile() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException
	{ 
	
		String input="./input.csv";
		fileOperations.invoke(null,input);
		Assert.assertTrue(new File(input).length()>0);
	}
	@Test(expected=OrderNotFound.class)
	public void testGetOrderWhenOderEmpty() throws OrderNotFound
	{
		stockManager.getOrders().clear();
		stockManager.getOrder("ABC");
	}
	@Test
	public void testGetOrderWhenOderNotEmpty() throws OrderNotFound, InvalidStockQuantity
	{ 	String companyName="ABC";
		String orderType="Sell";
		int quantity=10;
		stockManager.setOrder(companyName,new Order(orderType,quantity));
		Order actualOrder = stockManager.getOrder(companyName);
		Assert.assertTrue(actualOrder instanceof Order&&actualOrder.getOrderType().equalsIgnoreCase(orderType)&&actualOrder.getQuantity()==quantity);
	}
	@Test
	public void testGetOrders() throws OrderNotFound, InvalidStockQuantity
	{ 	
		Map<String, Order> actualOrder = stockManager.getOrders();
		Assert.assertThat(actualOrder, IsInstanceOf.instanceOf(Map.class));
	}
	@Test
	public void testSetOrder() throws OrderNotFound, InvalidStockQuantity
	{ 	String companyName="ABC";
	String orderType="Sell";
	int quantity=10;
	stockManager.setOrder(companyName,new Order(orderType,quantity));
	Order actualOrder = stockManager.getOrder(companyName);
	Assert.assertTrue(actualOrder instanceof Order&&actualOrder.getOrderType().equalsIgnoreCase(orderType)&&actualOrder.getQuantity()==quantity);
	}
	
}
