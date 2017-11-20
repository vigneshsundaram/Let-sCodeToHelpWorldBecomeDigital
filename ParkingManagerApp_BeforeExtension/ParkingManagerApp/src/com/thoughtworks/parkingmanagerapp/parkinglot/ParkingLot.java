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
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotNotOccupied;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotOccupied;
import com.thoughtworks.parkingmanagerapp.vehicle.Vehicle;
import com.thoughtworks.parkingmanagerapp.vehicle.VehicleType;

public class ParkingLot {
	private Map<String, Slot> slots;
	private int parkingLotNumber;
	private Queue<Slot> twoWhelerSlots;
	private Queue<Slot> fourWhelerSlots;

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
		if (slots == null)
			slots = new HashMap<String, Slot>();
		this.slots.put(slot.getSlotNumber(), slot);
		allocateSlotBasedOnType(slot);

	}

	private void allocateSlotBasedOnType(Slot slot) throws invalidSlotType {
		switch (slot.getType()) {
		case "TWOWHELLER": {
			if (twoWhelerSlots == null)
				initalizetTwoWhelerSlots();
			twoWhelerSlots.add(slot);
		}

			break;
		case "FOURWHELLER": {
			if (fourWhelerSlots == null)
				initalizeFourWhelerSlots();
			fourWhelerSlots.add(slot);

		}
			break;

		default: {
			throw new invalidSlotType();
		}

		}

	}

	private void initalizetTwoWhelerSlots() {
		twoWhelerSlots = new LinkedList<Slot>();

	}

	private void initalizeFourWhelerSlots() {
		fourWhelerSlots = new LinkedList<Slot>();

	}

	public String getSlotStatus(String slotNumber) {
		return this.slots.get(slotNumber).getStatus();
	}

	public Slot getFreeSlot(String vehicleType) throws SlotNotAvailable, invalidSlotType {
		Slot slot;
		switch (vehicleType) {
		case "TWOWHELLER": {
			slot = getTwoWhelerFreeSlot();
		}

			break;
		case "FOURWHELLER": {
			slot = getFourWhelerFreeSlot();

		}
			break;

		default: {
			throw new invalidSlotType();
		}

		}
		return slot;

	}

	public Slot getTwoWhelerFreeSlot() throws SlotNotAvailable {
		if (twoWhelerSlots.peek() == null)
			throw new SlotNotAvailable();
		return twoWhelerSlots.poll();

	}

	public Slot getFourWhelerFreeSlot() throws SlotNotAvailable {
		if (fourWhelerSlots.peek() == null)
			throw new SlotNotAvailable();
		return fourWhelerSlots.poll();

	}

	public String getParkingLotNumber() {
		return String.valueOf(this.parkingLotNumber);
	}

	public boolean contains(String number) {
		return this.slots.containsKey(number);
	}

	public void deOccupyVehicel(String number) throws SlotNotOccupied {
		this.slots.get(number).freeSlot();
	}

	public  Slot occupyVehicle (Vehicle vehicle) throws SlotNotAvailable, invalidSlotType, SlotOccupied {
			Slot freeSlot = this.getFreeSlot(vehicle.getType());
			freeSlot.occupyVehicle(vehicle);
			return freeSlot;
		
	}
}
