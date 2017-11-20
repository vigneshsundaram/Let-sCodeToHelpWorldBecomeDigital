package com.thoughtworks.parkingmanagerapp.slot;

public enum SlotStatus {
	
	FREE{
		@Override
		public SlotStatus changeStatus() {
			// TODO Auto-generated method stub
			return SlotStatus.OCCUPIED;
		}
	},
	
	OCCUPIED{
		@Override
		public SlotStatus changeStatus() {
			// TODO Auto-generated method stub
			return SlotStatus.FREE;
		}
	};
	
	public abstract SlotStatus changeStatus(); 
}
