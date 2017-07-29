package com.ajira.battelofmesoketes.test;

import org.junit.Assert;
import org.junit.Test;

import com.ajira.battelofmesoketes.attackers.IAttacker;
import com.ajira.battelofmesoketes.attackers.Tribe;
import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.StrategyNotFoundException;
import com.ajira.battelofmesoketes.exception.WeaponNotFoundException;
import com.ajira.battelofmesoketes.exception.WeaponStrenghtNotValid;
import com.ajira.battelofmesoketes.reactivestrategy.HeightReactiveStrategy;
import com.ajira.battelofmesoketes.wall.IWall;
import com.ajira.battelofmesoketes.wall.NorthWall;
import com.ajira.battelofmesoketes.weapon.IWeapon;
import com.ajira.battelofmesoketes.weapon.Weapon;


public class TribeTest {
	private IAttacker attacker;
	private String name;
	private IWeapon weapon;
	private IWall wall;
	private HeightReactiveStrategy strategy; 
	
	@Test
	public void shouldBeAbleToCreateAttacker()
	{
		attacker=new Tribe(name,weapon);
		Assert.assertTrue(attacker instanceof Tribe);
	}
	
	@Test
	public void shouldBeAbleToAttack() throws IllegalHeightException, StrategyNotFoundException, WeaponStrenghtNotValid, WeaponNotFoundException
	{	weapon=new Weapon("x", 15);
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(5, strategy);
		boolean isbreached=attacker.attack(wall);
		Assert.assertTrue(isbreached);
	}
	
	@Test
	public void shouldNotBeAbleToAttack() throws IllegalHeightException, StrategyNotFoundException, WeaponStrenghtNotValid, WeaponNotFoundException
	{	weapon=new Weapon("x", 1);
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(5, strategy);
		boolean isbreached=attacker.attack(wall);
		Assert.assertFalse(isbreached);
	}
	
	@Test(expected=WeaponNotFoundException.class)
	public void shouldNotBeAbleToAttackWhenWeaponIsNull() throws IllegalHeightException, StrategyNotFoundException, WeaponStrenghtNotValid, WeaponNotFoundException
	{	
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(5, strategy);
		boolean isbreached=attacker.attack(wall);
		Assert.assertFalse(isbreached);
	}

}
