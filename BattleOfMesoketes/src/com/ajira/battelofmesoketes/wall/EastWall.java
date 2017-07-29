package com.ajira.battelofmesoketes.wall;

import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.StrategyNotFoundException;
import com.ajira.battelofmesoketes.reactivestrategy.IReactiveStrategy;

public class EastWall implements IWall {
	IReactiveStrategy reactiveStrategy;
	private int heightOfWall;
	private int heightToBeRaised;

	public EastWall(int height, IReactiveStrategy strategy) throws IllegalHeightException, StrategyNotFoundException {
		checkIsValidHeight(height);
		checkStrategyIsAvaialbel(strategy);
		heightOfWall = height;
		reactiveStrategy = strategy;

	}

	@Override
	public void repelAttacks() throws IllegalHeightException {
		checkIsValidHeight(heightToBeRaised);
		heightOfWall = reactiveStrategy.execute(heightOfWall, heightToBeRaised);
	}

	@Override
	public boolean isBreached(int strength) {
		boolean isBreached = false;
		if (heightOfWall < strength) {
			isBreached = true;
			heightToBeRaised = strength;
		}
		return isBreached;
	}

}
