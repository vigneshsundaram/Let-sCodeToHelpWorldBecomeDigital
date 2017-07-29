package com.ajira.battelofmesoketes.wall;

import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.StrategyNotFoundException;
import com.ajira.battelofmesoketes.reactivestrategy.IReactiveStrategy;

public interface IWall {

	void repelAttacks() throws IllegalHeightException;

	boolean isBreached(int strength);

	default void checkIsValidHeight(int height) throws IllegalHeightException {
		if (height < 0) {
			throw new IllegalHeightException("Height Of the wall should be greater than zero");
		}

	}

	default void checkStrategyIsAvaialbel(IReactiveStrategy strategy) throws StrategyNotFoundException {
		if (strategy == null) {
			throw new StrategyNotFoundException("Strategy should not be null");
		}
	}
}
