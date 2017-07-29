//package com.ajira.battelofmesoketes.test;
//
//import org.junit.Test;
//
//import com.ajira.battelofmesoketes.attack.Attack;
//import com.ajira.battelofmesoketes.attackers.IAttacker;
//import com.ajira.battelofmesoketes.day.Day;
//import com.ajira.battelofmesoketes.day.Days;
//import com.ajira.battelofmesoketes.directions.Direction;
//import com.ajira.battelofmesoketes.exception.WeaponStrenghtNotValid;
//import com.ajira.battelofmesoketes.parser.IParser;
//import com.ajira.battelofmesoketes.parser.StringParser;
//import com.ajira.battelofmesoketes.reactivestrategy.ReativeStrategy;
//import com.ajira.battelofmesoketes.wall.IWall;
//import com.ajira.battelofmesoketes.weapon.IWeapon;
//
//import junit.framework.Assert;
//
//public class ParserTest {
//	IParser parser;
//	String input;
//	
//	
//	
//	@Test
//	public void shouldAbleToCreateWall()
//		parser=new StringParser();
//		IWall wall=parser.createWall("N", 5, ReativeStrategy.HeightReactiveStrategy);
//		org.junit.Assert.assertTrue(wall instanceof IWall);
//	}
//	@Test
//	public void shouldAbleToCreateWeapon() 
//	{	
//		parser=new StringParser();
//		IWeapon weapon=parser.createWeapon("X", 5 );
//		org.junit.Assert.assertTrue(weapon instanceof IWeapon);
//	}
//	@Test
//	public void shouldAbleToCreateTribe()
//	{	
//		parser=new StringParser();
//		IWeapon weapon=parser.createWeapon("X", 5 );
//		IAttacker attacker=parser.createTribe("T1",weapon);
//		org.junit.Assert.assertTrue(attacker instanceof IAttacker);
//	}
//	@Test
//	public void shouldAbleToCreateAttack()
//	{	
//		parser=new StringParser();
//		Attack attack=parser.createAttack("T1 - E - X - 4");
//		
//		org.junit.Assert.assertTrue(attack instanceof Attack);
//	}
//	@Test
//	public void shouldAbleToCreateDay()
//	{	
//		input="Day 1$ T1 - E - X - 4; Day 2$ T1 - W - X - 3 : T2 - E - X - 3; Day 3$ T3 - N - X - 2: T2 - W - X - 4	";
//		parser=new StringParser();
//		String [] inputs=input.split(";");
//		Day day= parser.createDay(inputs[0]);
//	}
//	
//	@Test
//	public void shouldAbleToParseData()
//	{
//		input="Day 1$ T1 - E - X - 4; Day 2$ T1 - W - X - 3 : T2 - E - X - 3; Day 3$ T3 - N - X - 2: T2 - W - X - 4	";
//		parser=new StringParser();
//		Days parse = parser.parse(input);
//		
//	}
//}
