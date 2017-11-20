package com.thoughtworks.parkingmanagerapp.parkingmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.parkingmanagerapp.parkinglot.ParkingLot;
import com.thoughtworks.parkingmanagerapp.parkinglot.excepton.SlotNotAvailable;
import com.thoughtworks.parkingmanagerapp.parkinglot.excepton.invalidSlotType;
import com.thoughtworks.parkingmanagerapp.slot.Slot;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotNotOccupied;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotOccupied;
import com.thoughtworks.parkingmanagerapp.vehicle.Vehicle;

public class ParkingManager {

	private Map<String, ParkingLot> parkingLots;
	private Map<String, Slot> vehicleParkedSlot;

	public void addParkingLots(List<ParkingLot> parkinglots) {

		Iterator<ParkingLot> iterator = parkinglots.iterator();
		while (iterator.hasNext()) {
			ParkingLot parkinglot = iterator.next();
			addParkingLot(parkinglot);
		}

	}

	public void addParkingLot(ParkingLot parkinglot) {
		initializeParkingLots();
		this.parkingLots.put(parkinglot.getParkingLotNumber(), parkinglot);

	}

	private void initializeParkingLots() {
		if (this.parkingLots == null)
			this.parkingLots = new HashMap<String, ParkingLot>();
	}

	public String parkVehicle(Vehicle vehicle) throws invalidSlotType, SlotOccupied {
		Slot slot = null;
		String parkingStatus = "Parking full";
		Set<String> keySet = this.parkingLots.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String parkingLotNumber = iterator.next();
			ParkingLot parkingLot = parkingLots.get(parkingLotNumber);
			try {
				slot=parkingLot.occupyVehicle(vehicle);
				parkingStatus=slot.getDetails();
			} catch (SlotNotAvailable e) {
				continue;
			}
			initializeVehicleParkedSlot();
			vehicleParkedSlot.put(vehicle.getVehicelNumber(),slot);
			break;

		}
		return parkingStatus;

	}

	private void initializeVehicleParkedSlot() {
		if (this.vehicleParkedSlot == null)
			this.vehicleParkedSlot = new HashMap<String, Slot>();

	}

	public String getSlotStatus(String number) throws SlotNotAvailable, invalidSlotType {
		String slotDetail = null;
		Set<String> keySet = this.parkingLots.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String parkingLotNumber = iterator.next();
			ParkingLot parkingLot = parkingLots.get(parkingLotNumber);
			if (!parkingLot.contains(number))
				continue;
			slotDetail = parkingLot.getSlotStatus(number);
			break;

		}
		return slotDetail;

	}

	public void freeSlot(String number) throws SlotNotAvailable, invalidSlotType, SlotNotOccupied {
		Slot slot = null;
		Set<String> keySet = this.parkingLots.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String parkingLotNumber = iterator.next();
			ParkingLot parkingLot = parkingLots.get(parkingLotNumber);
			if (!parkingLot.contains(number))
				continue;
			parkingLot.deOccupyVehicel(number);
			break;

		}

	}

	public String getSlotDetailFromVehicleNumber(String vehicleNumber) {
		return this.vehicleParkedSlot.get(vehicleNumber).getDetails();
	}
}
