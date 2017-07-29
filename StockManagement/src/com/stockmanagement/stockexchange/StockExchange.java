package com.stockmanagement.stockexchange;

import java.awt.geom.QuadCurve2D;

import com.stockmanagement.exception.InvalidStockQuantity;
import com.stockmanagement.exception.OrderNotFound;
import com.stockmanagement.main.StockManager;
import com.stockmanagemen.stock.Stock;

public class StockExchange {
	private static final StockExchange stockExchange=new StockExchange();
	/**
	 * Returns the instance of the Stock Exchange
	 * @return {@link Buy}
	 */
		public static StockExchange getStockExchnage() {
			// TODO Auto-generated method stub
			return stockExchange;
		}
		/**
		 * Calculates the  order on Stock
		 * @param order
		 * @param stock
		 * @return {@link Integer}
		 * @throws InvalidStockQuantity
		 */
		public int executeOrder(Order order,Stock stock) throws InvalidStockQuantity {
			Order existingOrder=null;
			int remainingQuantity=0;
			String companyName = stock.getCompanyName();
			try{
				existingOrder=StockManager.getOrder(companyName);
				if(isOrderAlreadyExists(order, existingOrder))
				{
					existingOrder.setQuantity(existingOrder.getQuantity()+order.getQuantity());
					stock.setQuantity(existingOrder.getQuantity());
				}
				else
				{
					if(existingOrder.getQuantity()>=order.getQuantity())
					{
						remainingQuantity=existingOrder.getQuantity()-order.getQuantity();
						existingOrder.setQuantity(remainingQuantity);
						stock.setQuantity(remainingQuantity);
						remainingQuantity=0;
					}
					else if(existingOrder.getQuantity()<=order.getQuantity())
					{
						remainingQuantity=order.getQuantity()-existingOrder.getQuantity();
						order.setQuantity(remainingQuantity);
						StockManager.setOrder(companyName, order);
						stock.setQuantity(remainingQuantity);
					}
				
				}
			}
			catch(OrderNotFound e)
			{
				StockManager.setOrder(companyName, order);
				stock.setQuantity(order.getQuantity());
				remainingQuantity=0;
			}
			return remainingQuantity;
		}
		
		/**
		 * Checks the order already exists or not
		 * @param order
		 * @return {@link Boolean}
		 */
		private boolean isOrderAlreadyExists(Order order,Order existingOrder) {
			if(existingOrder!=null&&existingOrder.getOrderType().equalsIgnoreCase(order.getOrderType()))
			{
				return true;
			}
			
			else
			{
				return false;
			}
		}
	}
