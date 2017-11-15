package com.thoughtworks.parkingmanagerapp.slot;

public enum SlotStatus {
	
	FREE{
		@Override
		public SlotStatus changeStatusAfterOccupying() {
			// TODO Auto-generated method stub
			return SlotStatus.PARTIALLYOCCUPIED;
		}

		@Override
		public SlotStatus changeStatusAfterDeOccupying() {
			// TODO Auto-generated method stub
			return  SlotStatus.FREE;
		}
	},
	PARTIALLYOCCUPIED{
		@Override
		public SlotStatus changeStatusAfterOccupying() {
			// TODO Auto-generated method stub
			return SlotStatus.OCCUPIED;
		}

		@Override
		public SlotStatus changeStatusAfterDeOccupying() {
			// TODO Auto-generated method stub
			return SlotStatus.FREE;
		}
	},
	
	OCCUPIED{
		@Override
		public SlotStatus changeStatusAfterOccupying() {
			// TODO Auto-generated method stub
			return SlotStatus.OCCUPIED;
		}

		@Override
		public SlotStatus changeStatusAfterDeOccupying() {
			// TODO Auto-generated method stub
			return SlotStatus.PARTIALLYOCCUPIED;
		}
	};
	
	public abstract SlotStatus changeStatusAfterOccupying();
	public abstract SlotStatus changeStatusAfterDeOccupying();
}
