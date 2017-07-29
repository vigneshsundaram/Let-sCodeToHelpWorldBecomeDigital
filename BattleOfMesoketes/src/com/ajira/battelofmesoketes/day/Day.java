package com.ajira.battelofmesoketes.day;

import java.util.Iterator;

import com.ajira.battelofmesoketes.attack.Attack;
import com.ajira.battelofmesoketes.attack.Attacks;

public class Day {

	private String name;
	private Attacks attacks;
	private int demageCount;

	public Day(String name, Attacks attacks) {
		this.name = name;
		this.attacks = attacks;
	}

	public int caluclateDemage() {
		iterateAttacks();

		return demageCount;

	}

	private void iterateAttacks() {
		Iterator<Attack> attacksIterator = attacks.iterator();
		while (attacksIterator.hasNext()) {
			Attack attack = attacksIterator.next();
			performAttack(attack);

		}
		repel(attacks);

	}

	private void performAttack(Attack attack) {
		if (attack.checkIsAttackSucessfull()) {
			demageCount++;
		}
	}

	private void repel(Attacks attacks) {

		Iterator<Attack> attacksIterator = attacks.iterator();
		while (attacksIterator.hasNext()) {
			Attack attack = attacksIterator.next();
			performRepel(attack);

		}

	}

	private void performRepel(Attack attack) {
		attack.repel();

	}
}
