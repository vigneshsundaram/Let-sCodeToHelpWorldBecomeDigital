package com.thoughtworks.parkingmanagerapp.slot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.AllOf;

import com.thoughtworks.parkingmanagerapp.slot.exception.SlotNotOccupied;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotOccupied;
import com.thoughtworks.parkingmanagerapp.vehicle.Vehicle;
import com.thoughtworks.parkingmanagerapp.vehicle.VehicleType;

public class Slot {
	private SlotStatus status;
	private SlotType type;
	private int number;
	private Map<String,Vehicle> vehicles;
	
	
	public Slot(int slotNumber,SlotType slotType)
	{
		this.number=slotNumber;
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
	{	if(!isFreeSlot()&&!isPartiallyOccupiedSlot())
			throw new SlotOccupied();
		intializeVehicles();
		if(vehicle.getType().equals(VehicleType.TWOWHELLER))
		{
			allocateTwoWheler(vehicle);
			
		}
		else if(vehicle.getType().equals(VehicleType.FOURWHELLER))
		{
			allocateFourWheler(vehicle);
			
			
		}
		updateStatusAfterOccupyingVehicle(vehicle);
	}
	
	private void intializeVehicles() {
		this.vehicles=new HashMap<>(2);
		
	}

	private void allocateFourWheler(Vehicle vehicle) {
		if(!status.equals(SlotStatus.PARTIALLYOCCUPIED)){
			vehicles.put(vehicle.getVehicelNumber(),vehicle);
		
		
		}
	}

	private void allocateTwoWheler(Vehicle vehicle) {
		vehicles.put(vehicle.getVehicelNumber(),vehicle);
	
	}

	public Vehicle freeSlot(String vehicleNumber) throws SlotNotOccupied{
		if(isFreeSlot())
			throw new SlotNotOccupied();
		return freeVehicleFromSlot(vehicleNumber);
		
	}

	private Vehicle freeVehicleFromSlot(String vehicleNumber) {
		Vehicle vehicle = null ;
		if(vehicles.containsKey(vehicleNumber))
		{
			 vehicle = vehicles.get(vehicleNumber);
			vehicles.remove(vehicleNumber);
		}
		updateStatusAfterDeOccupyingVehicle(vehicle);
		return vehicle;
	}

	private void updateStatusAfterDeOccupyingVehicle(Vehicle vehicle) {
		if(vehicle.getType().equals(VehicleType.TWOWHELLER))
		{
			status.changeStatusAfterDeOccupying();
		}
		else if(vehicle.getType().equals(VehicleType.FOURWHELLER))
		{
			status.changeStatusAfterDeOccupying();
			status.changeStatusAfterDeOccupying();
		}
	}
	private void updateStatusAfterOccupyingVehicle(Vehicle vehicle) {
		if(vehicle.getType().equals(VehicleType.TWOWHELLER))
		{
			status.changeStatusAfterOccupying();
		}
		else if(vehicle.getType().equals(VehicleType.FOURWHELLER))
		{
			status.changeStatusAfterOccupying();
			status.changeStatusAfterOccupying();
		}
	}
	private boolean isFreeSlot() {
		return (this.status.equals(SlotStatus.FREE));
		
	}
	private boolean isPartiallyOccupiedSlot() {
		return (this.status.equals(SlotStatus.PARTIALLYOCCUPIED));
		
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
