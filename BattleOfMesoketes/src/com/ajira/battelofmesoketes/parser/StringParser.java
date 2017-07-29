package com.ajira.battelofmesoketes.parser;

import com.ajira.battelofmesoketes.attack.Attack;
import com.ajira.battelofmesoketes.attack.Attacks;
import com.ajira.battelofmesoketes.attackers.IAttacker;
import com.ajira.battelofmesoketes.attackers.Tribe;
import com.ajira.battelofmesoketes.day.Day;
import com.ajira.battelofmesoketes.day.Days;
import com.ajira.battelofmesoketes.directions.Direction;
import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.StrategyNotFoundException;
import com.ajira.battelofmesoketes.exception.TribeNotFoundException;
import com.ajira.battelofmesoketes.exception.WallNotFoundException;
import com.ajira.battelofmesoketes.exception.WeaponStrenghtNotValid;
import com.ajira.battelofmesoketes.reactivestrategy.IReactiveStrategy;
import com.ajira.battelofmesoketes.reactivestrategy.ReativeStrategy;
import com.ajira.battelofmesoketes.wall.IWall;
import com.ajira.battelofmesoketes.weapon.IWeapon;
import com.ajira.battelofmesoketes.weapon.Weapon;

public class StringParser implements IParser {
	private String input;

	@Override
	public Days parse(String input) {
		String[] daysData = input.split(";");
		Days days = null;
		if (daysData.length > 0) {
			days = new Days();
			for (int day = 0; day < daysData.length; day++) {
				days.add(createDay(daysData[day]));
			}
		}
		return days;
	}

	private Day createDay(String string) {
		String[] dayData = string.split("[$]");
		String dayName = dayData[0].trim();
		String dataOfAttacks = dayData[1].trim();
		Attacks attacks = createAttacks(dataOfAttacks);
		Day day = new Day(dayName, attacks);
		return day;
	}

	private Attacks createAttacks(String dataOfAttacks) {
		Attacks attacks = new Attacks();
		String[] attackData = dataOfAttacks.split(":");
		for (int dataId = 0; dataId < attackData.length; dataId++) {
			String details = attackData[dataId];
			attacks.add(createAttack(details));

		}
		return attacks;

	}

	private Attack createAttack(String string) {
		Attack attack = null;
		String[] attackData = string.split("-");
		String weaponName = attackData[2].trim();
		int weaponStrength = Integer.parseInt(attackData[3].trim());
		IWeapon weapon = createWeapon(weaponName, weaponStrength);
		String attackerName = attackData[0].trim();
		IAttacker attcker = createTribe(attackerName, weapon);
		String direction = attackData[1].trim();
		IWall wall = createWall(direction, 0, ReativeStrategy.HeightReactiveStrategy);
		try {
			attack = new Attack(attcker, wall);
		} catch (TribeNotFoundException | WallNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attack;
	}

	private IWall createWall(String direction, int height, ReativeStrategy strategy) {

		IWall wall = null;
		IReactiveStrategy reactiveStrategy;
		ReativeStrategy.valueOf(strategy.name());
		reactiveStrategy = strategy.getInstance();
		Direction.valueOf(direction);
		try {
			wall = Direction.valueOf(direction).getInstance(height, reactiveStrategy);
		} catch (IllegalHeightException | StrategyNotFoundException e) {
			e.printStackTrace();
		}

		return wall;
	}

	private IWeapon createWeapon(String name, int strenght) {
		IWeapon weapon = null;
		try {
			weapon = new Weapon(name, strenght);
		} catch (WeaponStrenghtNotValid e) {
			e.printStackTrace();
		}
		return weapon;
	}

	private IAttacker createTribe(String name, IWeapon weapon) {
		return new Tribe(name, weapon);
	}

}
