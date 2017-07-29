package com.stockmanagement.main;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.stockmanagement.exception.EmptyFile;
import com.stockmanagement.exception.IllegalOperation;
import com.stockmanagement.exception.InvalidStockQuantity;
import com.stockmanagement.exception.OrderNotFound;
import com.stockmanagement.exception.StockNotFound;
import com.stockmanagement.stock.Stock;
import com.stockmanagement.stockexchange.Order;
import com.stockmanagement.stockexchange.StockExchange;

public class StockManager {
	private static final StockManager stockManager=new StockManager();
	private static StockExchange stockExchange=StockExchange.getStockExchnage();
	private static Map<String, Stock>stocks=new HashMap<String,Stock>();
	private static Map<String, Order>orders=new HashMap<String,Order>();


	public static Map<String, Order> getOrders() {
		return orders;
	}

	public static void setOrder(String CompanyName,Order order) {
		StockManager.orders.put(CompanyName,order);
	}

	static File inputFile=null;
	static FileReader inputFileReader=null;
	static BufferedReader inputReader=null;
	static File outputFile=null;
	static FileWriter outputFileWriter=null;
	static BufferedWriter outputWriter=null;
	static char valueSeperator=',';
	static Order order=null;
	private static Scanner input;
	public static void main(String[] args) throws IOException, InvalidStockQuantity, IllegalOperation, EmptyFile {
		String filePath = inputReader();
		fileOperations(filePath);
	}
	/**
	 * Gets the input file path form user
	 * @return input file path
	 */
	private static String inputReader() {
		System.out.println("Enter input file path");
		input = new Scanner(System.in);
		 String filePath=input.nextLine();
		return filePath;
	}
	
	/**
	 * Performs read write operations on file 
	 * @throws IOException
	 * @throws EmptyFile 
	 * @throws InvalidStockQuantity
	 * @throws IllegalOperation
	 */
	private static void fileOperations(String filePath) throws IOException, EmptyFile {
		
		try {
			
			 readInputFileIntoStream(filePath);
			 createOutputFileAndOutputStream();
			writeIntoOutputFile();
	
				outputWriter.flush();
				inputFileReader.close();
				outputFileWriter.close();
				inputReader.close();
				outputWriter.close();
			
		} catch (NumberFormatException | InvalidStockQuantity | IllegalOperation e) {
			System.out.println(	e.toString());
		}
		
		
	}
	/**
	 * Writes output data into output file
	 * @throws IOException
	 * @throws InvalidStockQuantity
	 * @throws IllegalOperation
	 * @throws EmptyFile 
	 */

	private static void writeIntoOutputFile() throws IOException, InvalidStockQuantity, IllegalOperation, EmptyFile {
		String line = null;
		line = inputReader.readLine();
		if(line!=null)
			{
			outputFileWriter.write(line);
			
			}
		else
		{
			throw new EmptyFile();
		}
		while((line=inputReader.readLine())!=null){
			String[] stockDetails = line.split(",");
			String operationName=stockDetails[1];
			int quantity=Integer.valueOf(stockDetails[3]);
			Stock stock;
			try {
				stock = getStock(stockDetails[2]);
			} catch (StockNotFound e) {
				stock=Stock.getStock();
				stock.setStockDetails(stockDetails);
				getStocks().put(stock.getCompanyName().toUpperCase(), stock);
				 
			}
			order=new Order(operationName, quantity);
			int stockRemainingValue = stockExchange.executeOrder(order, stock);	

			line=line+valueSeperator+stockRemainingValue+valueSeperator+isOpenORClose(stockRemainingValue);
			outputWriter.write(line);
			outputWriter.write(System.lineSeparator());
		}
	}
	/**
	 * Creates output file and output stream to store output data
	 * @throws IOException
	 */

	private static void createOutputFileAndOutputStream() throws IOException {
		
		 outputFile=new File("./output.csv");
		if (outputFile.exists())
		{
			outputFile.delete();
		}
		outputFileWriter = null;
		outputFileWriter = new FileWriter(outputFile);
		outputWriter=new BufferedWriter(outputFileWriter);
	}
	/**
	 * Reads the input file and loads into the input stream
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	private static void readInputFileIntoStream(String filePath) throws FileNotFoundException {
		inputFile=new File(filePath);
		 inputFileReader = new FileReader(inputFile);
		 inputReader=new BufferedReader(inputFileReader);
	}
	
	
	
	/**
	 * Checks whether stock is open or closed
	 * @param quantity
	 * @return {@link String}
	 */
	private static String isOpenORClose(int quantity) {
		return (quantity>0)?"Opened":"Closed";
	}
	
	/**
	 * Return Stocks
	 * @return  {@link Map}
	 */
	private static Map<String, Stock> getStocks() {
		return stocks;		
	}
	
	/**
	 *Returns the Stock 
	 * @param companyName
	 * @return Stock
	 * @throws StockNotFound
	 */
	private static Stock getStock(String companyName) throws StockNotFound {
		Stock existingstock  =getStocks().get(companyName.toUpperCase());
		if(existingstock==null)
		{
			throw new StockNotFound("StockNotFound");
		}
		else
		{
			return existingstock;
		}
	}
	
	/**
	 * Returns the instance of StockManager
	 * @return
	 */
	public static StockManager getStockManager() {
		// TODO Auto-generated method stub
		return stockManager;
	}
	/**
	 * 
	 * @param CompanyName
	 * @return Returns the order
	 * @throws OrderNotFound
	 */
	public static Order getOrder(String CompanyName) throws OrderNotFound {
		Order	existingOrder=orders.get(CompanyName);
			if(existingOrder!=null)
			{
				return existingOrder;
			}
			else
			{
				throw new OrderNotFound("OrderNotFOund");
			}
		}

}
