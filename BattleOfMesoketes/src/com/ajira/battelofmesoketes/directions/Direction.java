package com.ajira.battelofmesoketes.directions;

import com.ajira.battelofmesoketes.exception.IllegalHeightException;
import com.ajira.battelofmesoketes.exception.StrategyNotFoundException;
import com.ajira.battelofmesoketes.reactivestrategy.IReactiveStrategy;
import com.ajira.battelofmesoketes.wall.EastWall;
import com.ajira.battelofmesoketes.wall.IWall;
import com.ajira.battelofmesoketes.wall.NorthWall;
import com.ajira.battelofmesoketes.wall.SouthWall;
import com.ajira.battelofmesoketes.wall.WestWall;

public enum Direction {
	N {
		IWall wall;

		@Override
		public IWall getInstance(int height, IReactiveStrategy strategy)
				throws IllegalHeightException, StrategyNotFoundException {
			if (wall == null) {
				wall = new NorthWall(height, strategy);
			}

			return wall;
		}
	},
	S {
		IWall wall;

		@Override
		public IWall getInstance(int height, IReactiveStrategy strategy)
				throws IllegalHeightException, StrategyNotFoundException {
			if (wall == null) {
				wall = new SouthWall(height, strategy);
			}

			return wall;
		}
	},
	E {
		IWall wall;

		@Override
		public IWall getInstance(int height, IReactiveStrategy strategy)
				throws IllegalHeightException, StrategyNotFoundException {
			if (wall == null) {
				wall = new EastWall(height, strategy);
			}

			return wall;
		}
	},
	W {
		IWall wall;

		@Override
		public IWall getInstance(int height, IReactiveStrategy strategy)
				throws IllegalHeightException, StrategyNotFoundException {
			if (wall == null) {
				wall = new WestWall(height, strategy);
			}

			return wall;
		}
	};
	public abstract IWall getInstance(int height, IReactiveStrategy strategy)
			throws IllegalHeightException, StrategyNotFoundException;
}
