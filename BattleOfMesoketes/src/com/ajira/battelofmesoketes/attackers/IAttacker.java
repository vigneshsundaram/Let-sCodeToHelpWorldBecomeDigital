package com.ajira.battelofmesoketes.attackers;

import com.ajira.battelofmesoketes.exception.WeaponNotFoundException;
import com.ajira.battelofmesoketes.wall.IWall;

public interface IAttacker {
	public boolean attack(IWall wall) throws WeaponNotFoundException;
}
