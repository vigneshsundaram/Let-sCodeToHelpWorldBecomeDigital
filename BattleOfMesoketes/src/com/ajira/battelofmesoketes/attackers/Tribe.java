package com.ajira.battelofmesoketes.attackers;

import com.ajira.battelofmesoketes.exception.WeaponNotFoundException;
import com.ajira.battelofmesoketes.wall.IWall;
import com.ajira.battelofmesoketes.weapon.IWeapon;
import com.ajira.battelofmesoketes.weapon.Weapon;

public class Tribe implements IAttacker {

	private String name;
	private IWeapon weapon;

	public Tribe(String name, IWeapon weapon) {
		this.name = name;
		this.weapon = weapon;
	}

	public boolean attack(IWall wall) throws WeaponNotFoundException {
		if (weapon == null) {
			throw new WeaponNotFoundException("Weapon should be available inorder to perform attack");
		}
		return wall.isBreached(weapon.getWeaponStrength());
	}

}
