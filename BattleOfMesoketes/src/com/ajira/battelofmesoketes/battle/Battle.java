package com.ajira.battelofmesoketes.battle;

import java.util.Iterator;

import com.ajira.battelofmesoketes.day.Day;
import com.ajira.battelofmesoketes.day.Days;
import com.ajira.battelofmesoketes.parser.IParser;
import com.ajira.battelofmesoketes.parser.StringParser;

public class Battle {
	public void start(String battleData)

	{
		IParser parser = new StringParser();
		Days days = parser.parse(battleData);

		calculateTotalDemage(days);

	}

	private void calculateTotalDemage(Days days) {
		int demage = 0;
		Iterator<Day> daysIterator = days.iterator();
		while (daysIterator.hasNext()) {
			Day day = daysIterator.next();
			demage = demage + day.caluclateDemage();

		}

		System.out.println(demage);

	}

}
