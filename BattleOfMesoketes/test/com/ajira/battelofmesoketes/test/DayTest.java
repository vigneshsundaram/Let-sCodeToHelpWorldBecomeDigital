package com.ajira.battelofmesoketes.test;

import org.junit.Assert;
import org.junit.Test;

import com.ajira.battelofmesoketes.attack.Attack;
import com.ajira.battelofmesoketes.attack.Attacks;
import com.ajira.battelofmesoketes.attackers.IAttacker;
import com.ajira.battelofmesoketes.attackers.Tribe;
import com.ajira.battelofmesoketes.day.Day;
import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.StrategyNotFoundException;
import com.ajira.battelofmesoketes.exception.TribeNotFoundException;
import com.ajira.battelofmesoketes.exception.WallNotFoundException;
import com.ajira.battelofmesoketes.exception.WeaponStrenghtNotValid;
import com.ajira.battelofmesoketes.reactivestrategy.HeightReactiveStrategy;
import com.ajira.battelofmesoketes.wall.NorthWall;
import com.ajira.battelofmesoketes.weapon.IWeapon;
import com.ajira.battelofmesoketes.weapon.Weapon;

public class DayTest {
	Day day;
	Attacks attacks;
	String name;
	private IWeapon weapon;
	private IAttacker attacker;
	private HeightReactiveStrategy strategy;
	private NorthWall wall;
	private Attack attack;
	
	@Test
	public void shouldBeAbleToCreateDay()
	{
	 day=new Day(name,attacks);
	 Assert.assertTrue(day instanceof Day);
	}
	
	@Test
	public void shouldBeAbleToCalculateDemage() throws WeaponStrenghtNotValid, IllegalHeightException, StrategyNotFoundException, TribeNotFoundException, WallNotFoundException
	{	
		weapon=new Weapon("x", 5);
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(4, strategy);
		attack=new Attack(attacker,wall);
		attacks=new Attacks();
		attacks.add(attack);
		day=new Day(name,attacks);
		int demagesCount=day.caluclateDemage();
		Assert.assertEquals(1, demagesCount);
	}
	
	@Test
	public void shouldBeAbleToCalculateDemageForTwoAttacks() throws WeaponStrenghtNotValid, IllegalHeightException, StrategyNotFoundException, TribeNotFoundException, WallNotFoundException
	{	
		attacks=new Attacks();
		weapon=new Weapon("x", 5);
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(3, strategy);
		attack=new Attack(attacker,wall);
		attacks.add(attack);
		weapon=new Weapon("x", 5);
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(4, strategy);
		attack=new Attack(attacker,wall);
		attacks.add(attack);
		day=new Day(name,attacks);
		int demagesCount=day.caluclateDemage();
		Assert.assertEquals(2, demagesCount);
	}
	
	
	
}
