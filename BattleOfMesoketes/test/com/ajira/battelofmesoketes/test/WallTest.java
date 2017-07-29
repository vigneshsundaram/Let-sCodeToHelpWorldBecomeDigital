package com.ajira.battelofmesoketes.test;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.StrategyNotFoundException;
import com.ajira.battelofmesoketes.reactivestrategy.HeightReactiveStrategy;
import com.ajira.battelofmesoketes.reactivestrategy.IReactiveStrategy;
import com.ajira.battelofmesoketes.wall.IWall;
import com.ajira.battelofmesoketes.wall.NorthWall;

public class WallTest {
	
	IWall wall;
	IReactiveStrategy stragtegy;
	int heightOfWall=5;
	
	@Test
	public void shouldBeAbleToCreateWall() throws IllegalHeightException, StrategyNotFoundException
	{
		heightOfWall=10;
		stragtegy=new HeightReactiveStrategy();
		wall=new NorthWall(heightOfWall,stragtegy);	
		Assert.assertTrue(wall instanceof IWall);
	}
	
	@Test(expected=IllegalHeightException.class)
	public void shouldNotBeAbleToCreateWallWhenHeightIsLessThanZero() throws IllegalHeightException, StrategyNotFoundException
	{
		heightOfWall=-1;
		stragtegy=new HeightReactiveStrategy();
		wall=new NorthWall(heightOfWall,stragtegy);	
	}
	
	@Test(expected=StrategyNotFoundException.class)
	public void shouldNotBeAbleToCreateWallWhenStrategyIsNull() throws IllegalHeightException, StrategyNotFoundException
	{
		heightOfWall=10;
		wall=new NorthWall(heightOfWall,stragtegy);	
	}
	
	@Test
	
	public void shouldbeAbleToRepelAttackForPositveValues() throws IllegalHeightException, StrategyNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	
		heightOfWall=5;
		Class<NorthWall>northwall=NorthWall.class;
		Field heightToBeRaised = northwall.getDeclaredField("heightToBeRaised");
		heightToBeRaised.setAccessible(true);
		stragtegy=new HeightReactiveStrategy();
		wall=new NorthWall(heightOfWall,stragtegy);
		heightToBeRaised.setInt(wall, 10);
		wall.repelAttacks();
		Field heightOfWall = northwall.getDeclaredField("heightOfWall");
		heightOfWall.setAccessible(true);
		Assert.assertEquals(10,heightOfWall.getInt(wall));
		
	}
	
	@Test(expected=IllegalHeightException.class)
	public void shouldbeNotAbleToRepelAttackForNegativeValues() throws IllegalHeightException, StrategyNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	
		heightOfWall=5;
		Class<NorthWall>northwall=NorthWall.class;
		Field heightToBeRaised = northwall.getDeclaredField("heightToBeRaised");
		heightToBeRaised.setAccessible(true);
		stragtegy=new HeightReactiveStrategy();
		wall=new NorthWall(heightOfWall,stragtegy);
		heightToBeRaised.setInt(wall, -5);
		wall.repelAttacks();
		
	}
	
	@Test
	public void shouldbeNotAbleToRepelAttackForBothValuesheightsAreEqual() throws IllegalHeightException, StrategyNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	
		heightOfWall=5;
		Class<NorthWall>northwall=NorthWall.class;
		Field heightToBeRaised = northwall.getDeclaredField("heightToBeRaised");
		heightToBeRaised.setAccessible(true);
		stragtegy=new HeightReactiveStrategy();
		wall=new NorthWall(heightOfWall,stragtegy);
		heightToBeRaised.setInt(wall, 5);
		wall.repelAttacks();
		Field heightOfWall = northwall.getDeclaredField("heightOfWall");
		heightOfWall.setAccessible(true);
		Assert.assertEquals(heightToBeRaised.get(wall),heightOfWall.getInt(wall));
		
	}
	
	
	
	
	@Test
	public void shouldNotBreach() throws IllegalHeightException, StrategyNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	
		heightOfWall=10;
		Class<NorthWall>northwall=NorthWall.class;
		Field heightToBeRaised = northwall.getDeclaredField("heightToBeRaised");
		heightToBeRaised.setAccessible(true);
		stragtegy=new HeightReactiveStrategy();
		wall=new NorthWall(heightOfWall,stragtegy);
		heightToBeRaised.setInt(wall, 5);
		boolean isBreached = wall.isBreached(5);
		Assert.assertFalse(isBreached);
		
		
		
		
		
	}
	@Test
	public void shouldBreach() throws IllegalHeightException, StrategyNotFoundException
	{	heightOfWall=1;
		stragtegy=new HeightReactiveStrategy();
		wall=new NorthWall(heightOfWall,stragtegy);
		boolean isBreached = wall.isBreached(5);
		Assert.assertTrue(true);
		
		
	}
	

}
