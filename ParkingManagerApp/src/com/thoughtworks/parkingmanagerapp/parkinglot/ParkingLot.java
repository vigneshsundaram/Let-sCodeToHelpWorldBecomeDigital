package com.thoughtworks.parkingmanagerapp.parkinglot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.thoughtworks.parkingmanagerapp.parkinglot.excepton.SlotNotAvailable;
import com.thoughtworks.parkingmanagerapp.parkinglot.excepton.invalidSlotType;
import com.thoughtworks.parkingmanagerapp.slot.Slot;
import com.thoughtworks.parkingmanagerapp.slot.SlotStatus;
import com.thoughtworks.parkingmanagerapp.slot.SlotType;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotNotOccupied;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotOccupied;
import com.thoughtworks.parkingmanagerapp.vehicle.Vehicle;
import com.thoughtworks.parkingmanagerapp.vehicle.VehicleType;

public class ParkingLot {
	private Map<String, Slot> occupiedSlots;
	private int parkingLotNumber;
	private Queue<Slot> freeSlots;
	private Map<String, Slot> vehicleParkedSlot;

	public ParkingLot(int parkingLotNumber) {
		this.parkingLotNumber = parkingLotNumber;

	}

	public void addSlots(List<Slot> slots) throws invalidSlotType {
		iterateSlots(slots);

	}

	private void iterateSlots(List<Slot> slots) throws invalidSlotType {
		Iterator<Slot> iterator = slots.iterator();
		while (iterator.hasNext()) {
			Slot slot = iterator.next();
			this.addSlot(slot);
		}
	}

	public void addSlot(Slot slot) throws invalidSlotType {
		if (occupiedSlots == null)
			occupiedSlots = new HashMap<String, Slot>();
		this.occupiedSlots.put(slot.getSlotNumber(), slot);
		allocateFreeSlot(slot);
		

	}

	private void allocateFreeSlot(Slot slot) throws invalidSlotType {
		
			if (occupiedSlots == null){
				initalizeFreeSlots();
			freeSlots.add(slot);

	}
	}


	private void initalizeFreeSlots() {
		freeSlots = new LinkedList<Slot>();

	}

	public String getSlotStatus(String slotNumber) {
		return this.occupiedSlots.get(slotNumber).getStatus();
	}

	public Slot getFreeSlot(String vehicleType) throws SlotNotAvailable, invalidSlotType {
		Slot slot;
		switch (vehicleType) {
		case "TWOWHELLER": {
			slot = getFreeSlotForTwoWheler();
		}

			break;
		case "FOURWHELLER": {
			slot = getFreeSlotForFourWheler();

		}
			break;

		default: {
			throw new invalidSlotType();
		}

		}
		return slot;

	}


	public Slot getFreeSlotForTwoWheler() throws SlotNotAvailable {
		Slot slot = null ;
		if (freeSlots.peek() == null)
			throw new SlotNotAvailable();
		Iterator<Slot> iterator = freeSlots.iterator();
		while(iterator.hasNext()){
		 slot = iterator.next();
		if(!slot.getStatus().equals(SlotStatus.OCCUPIED))
		{
		break;
		}
		if(slot==null)
		{
		throw new SlotNotAvailable();	
		}
		}
		return slot;

	}
	
	public Slot getFreeSlotForFourWheler() throws SlotNotAvailable {
		Slot slot = null ;
		if (freeSlots.peek() == null)
			throw new SlotNotAvailable();
		Iterator<Slot> iterator = freeSlots.iterator();
		while(iterator.hasNext()){
		 slot = iterator.next();
		if(slot.getStatus().equals(SlotStatus.FREE))
		{
		break;
		}
		if(slot==null)
		{
		throw new SlotNotAvailable();	
		}
		}
		return slot;
	}

	public String getParkingLotNumber() {
		return String.valueOf(this.parkingLotNumber);
	}

	public boolean containsSlot(String slotNumber) {
		return this.occupiedSlots.containsKey(slotNumber);
	}
	public boolean containsVehicle(String number) {
		return this.vehicleParkedSlot.containsKey(number);
	}

	public void deOccupyVehicel(String slotNumber,String vehicleNumber) throws SlotNotOccupied, invalidSlotType {
		Slot slot = this.occupiedSlots.get(slotNumber);
		Vehicle vehicle = slot.freeSlot(vehicleNumber);
		if(vehicle.getType().equals(VehicleType.TWOWHELLER)&&(slot.getStatus().equals(SlotStatus.FREE)))
			this.occupiedSlots.remove(slotNumber);
		allocateFreeSlot(slot);
		
	}

	

	public  Slot occupyVehicle (Vehicle vehicle) throws SlotNotAvailable, invalidSlotType, SlotOccupied {
			Slot slot = this.getFreeSlot(vehicle.getType());
			slot.occupyVehicle(vehicle);
			initializeVehicleParkedSlot();
			vehicleParkedSlot.put(vehicle.getVehicelNumber(),slot);
			return slot;
		
	}
	private void initializeVehicleParkedSlot() {
		if (this.vehicleParkedSlot == null)
			this.vehicleParkedSlot = new HashMap<String, Slot>();

	}
	
	public String getSlotDetailFromVehicleNumber(String vehicleNumber) {
		return this.vehicleParkedSlot.get(vehicleNumber).getDetails();
	}
}
