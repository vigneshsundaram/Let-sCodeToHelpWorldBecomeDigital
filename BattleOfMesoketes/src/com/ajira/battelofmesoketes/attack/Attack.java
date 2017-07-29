package com.ajira.battelofmesoketes.attack;

import com.ajira.battelofmesoketes.attackers.IAttacker;
import com.ajira.battelofmesoketes.attackers.Tribe;
import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.TribeNotFoundException;
import com.ajira.battelofmesoketes.exception.WallNotFoundException;
import com.ajira.battelofmesoketes.exception.WeaponNotFoundException;
import com.ajira.battelofmesoketes.wall.IWall;

public class Attack {
	IAttacker attacker;
	IWall wall;

	public Attack(IAttacker attacker, IWall wall) throws TribeNotFoundException, WallNotFoundException {
		if (attacker == null) {
			throw new TribeNotFoundException("Tribe should present in order to attack");
		}
		if (wall == null) {
			throw new WallNotFoundException("Weapon should be present to attack");
		}
		this.attacker = attacker;
		this.wall = wall;

	}

	public boolean checkIsAttackSucessfull() {
		boolean attack = false;
		try {
			attack = attacker.attack(wall);
		} catch (WeaponNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return attack;
	}

	public void repel() {
		try {
			wall.repelAttacks();
		} catch (IllegalHeightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
