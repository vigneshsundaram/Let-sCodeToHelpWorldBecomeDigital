package com.thoughtworks.parkingmanagerapp.slot;

import com.thoughtworks.parkingmanagerapp.slot.exception.SlotNotOccupied;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotOccupied;
import com.thoughtworks.parkingmanagerapp.vehicle.Vehicle;

public class Slot {
	private SlotStatus status;
	private SlotType type;
	private int number;
	private Vehicle vehicle;
	
	
	public Slot(int number,SlotType slotType)
	{
		this.number=number;
		this.type=slotType;
		this.status=SlotStatus.FREE;
	}
	
	public String getSlotNumber()
	{
		return String.valueOf(this.number);
	}
	public String getDetails() {
		return "SlotNumber "+ this.number+" Slot Stauts "+this.status;
	}
	
	public void occupyVehicle(Vehicle vehicle) throws SlotOccupied
	{	if(!isFreeSlot())
			throw new SlotOccupied();
		this.vehicle=vehicle;
		status=status.changeStatus();
		
	}
	
	public void freeSlot() throws SlotNotOccupied{
		if(isFreeSlot())
			throw new SlotNotOccupied();
		this.vehicle=null;
		this.status=this.status.changeStatus();
	}

	private boolean isFreeSlot() {
		return (this.status.equals(SlotStatus.FREE));
		
	}
	
	public String getStatus()
	{
		return this.status.toString();
	}
	
	public String getType()
	{
		return this.type.toString();
	}
}
