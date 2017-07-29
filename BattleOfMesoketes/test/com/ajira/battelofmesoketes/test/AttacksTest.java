package com.ajira.battelofmesoketes.test;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.management.InstanceAlreadyExistsException;

import org.junit.Assert;
import org.junit.Test;

import com.ajira.battelofmesoketes.attack.Attack;
import com.ajira.battelofmesoketes.attack.Attacks;
import com.ajira.battelofmesoketes.attackers.IAttacker;
import com.ajira.battelofmesoketes.attackers.Tribe;
import com.ajira.battelofmesoketes.attackers.IAttacker;
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

public class AttacksTest {
	Attacks attacks;
	Attack attack;
	IWeapon weapon;
	IAttacker attacker;
	IWall wall;
	IReactiveStrategy  strategy;
	@Test
	public void ShouldBeAbleToAddAttackIntoAttacks() throws WeaponStrenghtNotValid, IllegalHeightException, StrategyNotFoundException, TribeNotFoundException, WallNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	 weapon = new Weapon("x", 10);
		 attacker=new Tribe("vignesh", weapon);
		 strategy=new HeightReactiveStrategy();
		 wall=new NorthWall(5, strategy);
		 attack=new Attack(attacker, wall);
		 attacks= new Attacks();
		 attacks.add(attack);
		 Class<Attacks> attacksClass=Attacks.class;
		 Field attacksField = attacksClass.getDeclaredField("attacks");
		 attacksField.setAccessible(true);
		 List<Attack> actualAttacks = (List<Attack>) attacksField.get(attacks);
		 Assert.assertEquals(1,actualAttacks.size());
	}
	
	
}
