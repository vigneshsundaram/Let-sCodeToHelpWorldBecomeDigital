package com.ajira.battelofmesoketes.parser;

import com.ajira.battelofmesoketes.attack.Attack;
import com.ajira.battelofmesoketes.attackers.IAttacker;
import com.ajira.battelofmesoketes.day.Day;
import com.ajira.battelofmesoketes.day.Days;
import com.ajira.battelofmesoketes.directions.Direction;
import com.ajira.battelofmesoketes.exception.WeaponStrenghtNotValid;
import com.ajira.battelofmesoketes.reactivestrategy.IReactiveStrategy;
import com.ajira.battelofmesoketes.reactivestrategy.ReativeStrategy;
import com.ajira.battelofmesoketes.wall.IWall;
import com.ajira.battelofmesoketes.weapon.IWeapon;

public interface IParser {

	Days parse(String input);

}
