package com.ajira.battelofmesoketes.test;

import org.junit.Assert;
import org.junit.Test;

import com.ajira.battelofmesoketes.attack.Attack;
import com.ajira.battelofmesoketes.attackers.IAttacker;
import com.ajira.battelofmesoketes.attackers.Tribe;
import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.StrategyNotFoundException;
import com.ajira.battelofmesoketes.exception.TribeNotFoundException;
import com.ajira.battelofmesoketes.exception.WallNotFoundException;
import com.ajira.battelofmesoketes.exception.WeaponStrenghtNotValid;
import com.ajira.battelofmesoketes.reactivestrategy.HeightReactiveStrategy;
import com.ajira.battelofmesoketes.reactivestrategy.IReactiveStrategy;
import com.ajira.battelofmesoketes.wall.IWall;
import com.ajira.battelofmesoketes.wall.NorthWall;
import com.ajira.battelofmesoketes.weapon.IWeapon;
import com.ajira.battelofmesoketes.weapon.Weapon;

public class AttackTest {
	Attack attack;
	IAttacker attacker;
	IWeapon weapon;
	IWall wall;
	IReactiveStrategy strategy;
	
	
	@Test
	public void shouldBeAbleToCreateAttack() throws WeaponStrenghtNotValid, IllegalHeightException, StrategyNotFoundException, TribeNotFoundException, WallNotFoundException
	{	weapon=new Weapon("x", 5);
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(5, strategy);
		attack=new Attack(attacker,wall);
		Assert.assertTrue(attack instanceof Attack);
	}
	
	@Test(expected=TribeNotFoundException.class)
	public void shouldNotBeAbleToCreateAttackWhenTribeIsNull() throws WeaponStrenghtNotValid, IllegalHeightException, StrategyNotFoundException, TribeNotFoundException, WallNotFoundException
	{	
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(5, strategy);
		attack=new Attack(attacker,wall);
	}
	
	@Test(expected=WallNotFoundException.class)
	public void shouldNotBeAbleToCreateAttackWhenWallIsNull() throws WeaponStrenghtNotValid, IllegalHeightException, StrategyNotFoundException, TribeNotFoundException, WallNotFoundException
	{	
		weapon=new Weapon("x", 5);
		attacker=new Tribe("vignesh", weapon);
		attack=new Attack(attacker,wall);
	}
	
	@Test
	public void shouldBeAbleToAttackSucessfully() throws WeaponStrenghtNotValid, IllegalHeightException, StrategyNotFoundException, TribeNotFoundException, WallNotFoundException
	{	
		weapon=new Weapon("x", 6);
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(5, strategy);
		attack=new Attack(attacker, wall);
		boolean isSucessfull=attack.checkIsAttackSucessfull();
		Assert.assertTrue(isSucessfull);
	}
	
	@Test
	public void shouldNotBeAbleToAttackSucessfully() throws WeaponStrenghtNotValid, IllegalHeightException, StrategyNotFoundException, TribeNotFoundException, WallNotFoundException
	{	
		weapon=new Weapon("x", 3);
		attacker=new Tribe("vignesh", weapon);
		strategy=new HeightReactiveStrategy();
		wall=new NorthWall(5, strategy);
		attack=new Attack(attacker, wall);
		boolean isSucessfull=attack.checkIsAttackSucessfull();
		Assert.assertFalse(isSucessfull);
	}
	
	
}
