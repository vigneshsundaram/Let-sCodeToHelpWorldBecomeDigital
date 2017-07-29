package com.ajira.battelofmesoketes.reactivestrategy;

public enum ReativeStrategy {
	HeightReactiveStrategy {
		@Override
		public IReactiveStrategy getInstance() {
			// TODO Auto-generated method stub
			return new HeightReactiveStrategy();
		}
	};

	public abstract IReactiveStrategy getInstance();
}
