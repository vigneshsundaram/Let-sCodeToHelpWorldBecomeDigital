package com.ajira.battelofmesoketes.test;

import org.junit.Assert;
import org.junit.Test;

import com.ajira.battelofmesoketes.exception.WeaponStrenghtNotValid;
import com.ajira.battelofmesoketes.weapon.IWeapon;
import com.ajira.battelofmesoketes.weapon.Weapon;

public class WeaponTest {
	
	IWeapon weapon;
	String name;
	int strength;
	
	@Test
	public void shouldbeAbleToCreateWeapon() throws WeaponStrenghtNotValid
	{	name="x";
	strength=5;
		weapon=new Weapon(name,strength);
		Assert.assertTrue(weapon instanceof Weapon);
	}
	
	@Test(expected=WeaponStrenghtNotValid.class)
	public void shouldbeNotAbleToCreateWeaponWhenStrengthIsZerooOrLessThanThat() throws WeaponStrenghtNotValid
	{
		name="x";
		strength=0;
		weapon=new Weapon(name,strength);
	}
}
