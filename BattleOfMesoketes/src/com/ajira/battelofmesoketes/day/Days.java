package com.ajira.battelofmesoketes.day;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Days implements Iterable<Day> {

	Collection<Day> days = new ArrayList<Day>();

	@Override
	public Iterator<Day> iterator() {
		Iterator<Day> daysiterator = days.iterator();
		// TODO Auto-generated method stub
		return new Iterator<Day>() {
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return daysiterator.hasNext();
			}

			@Override
			public Day next() {
				// TODO Auto-generated method stub
				return daysiterator.next();
			}
		};
	}

	public void add(Day day) {
		days.add(day);

	}

}
