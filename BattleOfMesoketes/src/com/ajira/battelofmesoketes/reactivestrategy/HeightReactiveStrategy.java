package com.ajira.battelofmesoketes.reactivestrategy;

public class HeightReactiveStrategy implements IReactiveStrategy {

	@Override
	public int execute(int heightOfWall, int heightToBeRaised) {
		
		if(heightOfWall<heightToBeRaised)
		{
		heightOfWall= heightToBeRaised;
		}
		
		return heightOfWall;
		
	}
}
