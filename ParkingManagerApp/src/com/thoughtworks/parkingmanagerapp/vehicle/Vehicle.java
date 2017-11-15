package com.thoughtworks.parkingmanagerapp.vehicle;

import com.thoughtworks.parkingmanagerapp.slot.Slot;

public class Vehicle {
	private String number;
	private VehicleType type;
	

	public Vehicle(String vehicleNumber,VehicleType type) {
		this.number=vehicleNumber;
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
