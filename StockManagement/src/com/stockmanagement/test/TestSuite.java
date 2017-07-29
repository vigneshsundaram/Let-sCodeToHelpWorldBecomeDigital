package com.stockmanagement.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.stockmanagement.stock.Stock;
import com.stockmanagement.stockexchange.Order;

@RunWith(Suite.class)

@SuiteClasses({OrderTest.class,StockExchangeTest.class,StockManagerTest.class,StockTest.class})

public class TestSuite {

}
