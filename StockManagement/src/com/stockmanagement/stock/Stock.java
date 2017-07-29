package com.stockmanagement.stock;




import java.util.Stack;

import com.stockmanagement.exception.IllegalOperation;
import com.stockmanagement.exception.InvalidStockQuantity;
import com.stockmanagement.stockexchange.Order;

public class Stock {
private int stockID;
private String companyName;
private int quantity;
/**
	 * Returns instance of Stock
	 * @return {@link Stock}
	 */
	public static Stock getStock() {
		return new Stock();
	}

	/**
	 * Sets StockID
	 * @param stockID
	 */
	public void setStockID(int stockID ) {
		this.stockID=stockID;
	}

	/**
	 * Gets StockID
	 * @return {@link Integer}
	 */
	public int getStockID() {
		return stockID;
	}
	
	/**
	 * Sets Company Name
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName=companyName;		
	}

	/**
	 * Gets Company Name
	 * @return {@link String}
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * Gets Stock  quantity
	 * @return {@link Integer}
	 */

	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}
	/**
	 * Sets stock quantity
	 * @param quantity
	 * @throws InvalidStockQuantity
	 */

	public void setQuantity(int quantity) throws InvalidStockQuantity {
		if(isValidStockQuantity(quantity))
		{
			this.quantity=quantity;
		}
		else
		{
			throw new InvalidStockQuantity("Invalid buy stock");
		}
	}
	/**
	 * Checks whether Stock quantity is valid or not
	 * @param quantity
	 * @return {@link Boolean}
	 */

	public boolean isValidStockQuantity(int quantity) {
		boolean isValid=false;
		if(quantity>=0)
		{
			isValid=true;
		}
		return isValid;
	}

	
	/**
	 *Sets the Stock details 
	 * @param details
	 * @throws InvalidStockQuantity
	 * @throws IllegalOperation
	 */
	public void setStockDetails(String[] details) throws InvalidStockQuantity, IllegalOperation {
		
		this.stockID=Integer.valueOf(details[0]);	
		this.companyName=details[2];
		Integer quantity = Integer.valueOf(details[3]);
	
	}

	
}
