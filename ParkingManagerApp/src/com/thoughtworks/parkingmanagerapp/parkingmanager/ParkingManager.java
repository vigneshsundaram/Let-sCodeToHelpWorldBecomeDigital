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
		
			break;

		}
		return parkingStatus;

	}



	public String getSlotStatus(String slotNumber) throws SlotNotAvailable, invalidSlotType {
		String slotDetail = null;
		Set<String> keySet = this.parkingLots.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String parkingLotNumber = iterator.next();
			ParkingLot parkingLot = parkingLots.get(parkingLotNumber);
			if (!parkingLot.containsSlot(slotNumber))
				continue;
			slotDetail = parkingLot.getSlotStatus(slotNumber);
			break;

		}
		return slotDetail;

	}

	public void freeSlot(String slotNumber,String vehicleNumber) throws SlotNotAvailable, invalidSlotType, SlotNotOccupied {
		Slot slot = null;
		Set<String> keySet = this.parkingLots.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String parkingLotNumber = iterator.next();
			ParkingLot parkingLot = parkingLots.get(parkingLotNumber);
			if (!parkingLot.containsSlot(slotNumber))
				continue;
			parkingLot.deOccupyVehicel(slotNumber,vehicleNumber);
			break;

		}

	}

	public void getSlotDetailFromVehicleNumber(String vehicleNumber) {
		Set<String> keySet = this.parkingLots.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String parkingLotNumber = iterator.next();
			ParkingLot parkingLot = parkingLots.get(parkingLotNumber);
			if (!parkingLot.containsVehicle(vehicleNumber))
				continue;
			System.out.println(parkingLot.getSlotDetailFromVehicleNumber(vehicleNumber));
			break;

		}

	}
}
