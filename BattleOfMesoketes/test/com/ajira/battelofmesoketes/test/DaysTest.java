package com.ajira.battelofmesoketes.test;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ajira.battelofmesoketes.attack.Attack;
import com.ajira.battelofmesoketes.attack.Attacks;
import com.ajira.battelofmesoketes.day.Day;
import com.ajira.battelofmesoketes.day.Days;

public class DaysTest {
	Days days;
	Day day;
	@Test
	public void shouldBeAbleToCreateDays()
	{
		days=new Days();
	}
	
	@Test
	public void shouldBeAbleToDayIntoDays() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	day =new Day("",null);
		days=new Days();
		days.add(day);
		Class<Days> attacksClass=Days.class;
		Field daysField = attacksClass.getDeclaredField("days");
		daysField.setAccessible(true);
		List<Attack> actualdays = (List<Attack>) daysField.get(days);
		Assert.assertEquals(1,actualdays.size());
	}
}
