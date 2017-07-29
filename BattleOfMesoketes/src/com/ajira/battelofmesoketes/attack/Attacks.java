package com.ajira.battelofmesoketes.attack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Attacks implements Iterable<Attack> {

	Collection<Attack> attacks = new ArrayList<Attack>();

	@Override
	public Iterator<Attack> iterator() {
		Iterator<Attack> attacksIterator = attacks.iterator();
		return new Iterator<Attack>() {

			@Override
			public Attack next() {
				// TODO Auto-generated method stub
				return attacksIterator.next();
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return attacksIterator.hasNext();
			}
		};
	}

	public void add(Attack attack) {
		attacks.add(attack);
	}
}
