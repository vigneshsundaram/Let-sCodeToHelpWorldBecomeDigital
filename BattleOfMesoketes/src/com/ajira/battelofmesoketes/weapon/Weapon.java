package com.ajira.battelofmesoketes.weapon;

import com.ajira.battelofmesoketes.exception.WeaponStrenghtNotValid;

public class Weapon implements IWeapon {

	private int strength;
	private String name;

	public Weapon(String name, int strength) throws WeaponStrenghtNotValid {
		if (strength <= 0) {
			throw new WeaponStrenghtNotValid("Strentg of the weapon should be more than zero");
		}
		this.name = name;
		this.strength = strength;
	}

	public int getWeaponStrength() {
		return strength;
	}

}
