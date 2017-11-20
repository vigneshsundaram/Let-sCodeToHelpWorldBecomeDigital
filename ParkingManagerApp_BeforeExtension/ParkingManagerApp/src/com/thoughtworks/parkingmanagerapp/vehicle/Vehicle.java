package com.thoughtworks.parkingmanagerapp.vehicle;

import com.thoughtworks.parkingmanagerapp.slot.Slot;

public class Vehicle {
	private String number;
	private VehicleType type;
	

	public Vehicle(String number,VehicleType type) {
		this.number=number;
		this.type=type;
	}


	public String getType() {
		// TODO Auto-generated method stub
		return this.type.toString();
	}
	
	public String getVehicelNumber()
	{
		return this.number;
	}

}
