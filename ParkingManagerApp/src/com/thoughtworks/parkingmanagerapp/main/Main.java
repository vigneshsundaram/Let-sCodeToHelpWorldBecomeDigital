package com.thoughtworks.parkingmanagerapp.main;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.parkingmanagerapp.parkinglot.ParkingLot;
import com.thoughtworks.parkingmanagerapp.parkinglot.excepton.SlotNotAvailable;
import com.thoughtworks.parkingmanagerapp.parkinglot.excepton.invalidSlotType;
import com.thoughtworks.parkingmanagerapp.parkingmanager.ParkingManager;
import com.thoughtworks.parkingmanagerapp.slot.Slot;
import com.thoughtworks.parkingmanagerapp.slot.SlotType;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotNotOccupied;
import com.thoughtworks.parkingmanagerapp.slot.exception.SlotOccupied;
import com.thoughtworks.parkingmanagerapp.vehicle.Vehicle;
import com.thoughtworks.parkingmanagerapp.vehicle.VehicleType;

public class Main {

	public static void main(String[] args) throws SlotNotOccupied {
		ParkingManager parkingManager;
		ParkingLot parkingLotOne = new ParkingLot(1);

		List<Slot> parkingLotOneSlots = new ArrayList<Slot>() {
			{
				add(new Slot(1, SlotType.FOURWHELLER));
				add(new Slot(2, SlotType.FOURWHELLER));
				add(new Slot(3, SlotType.TWOWHELLER));
				add(new Slot(4, SlotType.TWOWHELLER));
			}
		};
		ParkingLot parkingLotTwo = new ParkingLot(2);

		List<Slot> parkingLotTwoSlots = new ArrayList<Slot>() {
			{
				add(new Slot(5, SlotType.FOURWHELLER));
				add(new Slot(6, SlotType.FOURWHELLER));
				add(new Slot(7, SlotType.TWOWHELLER));
				add(new Slot(8, SlotType.TWOWHELLER));
			}
		};
		ParkingLot parkingLotThree = new ParkingLot(3);

		List<Slot> parkingLotThreeSlots = new ArrayList<Slot>() {
			{
				add(new Slot(9, SlotType.FOURWHELLER));
				add(new Slot(10, SlotType.FOURWHELLER));
				add(new Slot(11, SlotType.TWOWHELLER));
				add(new Slot(12, SlotType.TWOWHELLER));
			}
		};
		try {
			parkingLotOne.addSlots(parkingLotOneSlots);
			parkingLotTwo.addSlots(parkingLotTwoSlots);
			parkingLotThree.addSlots(parkingLotThreeSlots);
			parkingManager = new ParkingManager();
			parkingManager.addParkingLot(parkingLotOne);
			parkingManager.addParkingLot(parkingLotTwo);
			parkingManager.addParkingLot(parkingLotThree);
			Vehicle vehicle = new Vehicle("TN38BJ8508", VehicleType.TWOWHELLER);
			System.out.println(parkingManager.parkVehicle(vehicle));
			vehicle = new Vehicle("TN38BJ8509", VehicleType.FOURWHELLER);
			System.out.println(parkingManager.parkVehicle(vehicle));

		} catch (invalidSlotType | SlotOccupied e) {
			// TODO Auto-generated catch block
			e.toString();
		}

	}

}
