package com.ajira.battelofmesoketes.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.reactivestrategy.HeightReactiveStrategy;
import com.ajira.battelofmesoketes.reactivestrategy.IReactiveStrategy;

public class ReactiveStrategyTest {
	
	IReactiveStrategy reactiveStrategy;
	
	@Before
	public void setUp()
	{
		reactiveStrategy=new HeightReactiveStrategy();
	}
	
	@Test
	public void shouldBeAbleToExecuteStrategyWithBothValueZero()
	{
		int repledHeight=reactiveStrategy.execute(0,0);
		Assert.assertEquals(0, repledHeight);
	}
	
	@Test
	public void shouldBeAbleToExecuteStrategyWithBothValueGreaterThanZero()
	{
		int repledHeight=reactiveStrategy.execute(5,6);
		Assert.assertEquals(6, repledHeight);
	}
	
	@Test
	public void shouldBeAbleToExecuteStrategyWithCurrentWallGreaterThanHeightToBeRaised()
	{
		int repledHeight=reactiveStrategy.execute(9,6);
		Assert.assertEquals(9, repledHeight);
	}
	
	
	
}
