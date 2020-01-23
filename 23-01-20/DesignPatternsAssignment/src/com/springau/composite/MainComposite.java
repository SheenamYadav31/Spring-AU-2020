package com.springau.composite;

import java.util.ArrayList;
import java.util.List;

public class MainComposite {
	public static void main(String[] args) {
		Room R1 = new Room("BedRoom", 800, true);
		Room R2 = new Room("BedRoom", 600, true);
		Room R3 = new Room("BedRoom", 700, false);
		Room R4 = new Room("Bathroom", 100, false);
		Room R5 = new Room("Kitchen", 100, true);
		Room R6 = new Room("Kitchen", 100, false);
		Room R7 = new Room("LivingRoom", 400, false);
		
		Apartment A1 = new Apartment("101-A", 1500, 5);
		Apartment A2 = new Apartment("202-A", 1000, 10);
		Apartment A3 = new Apartment("103-B", 1000, 8);
		
		A1.addRoom(R1);A1.addRoom(R2);A1.addRoom(R4);A1.addRoom(R5);A1.addRoom(R7);
		A2.addRoom(R2);A2.addRoom(R2);A2.addRoom(R6);A2.addRoom(R7);A3.addRoom(R4);
		A3.addRoom(R2);A3.addRoom(R3);A3.addRoom(R5);A3.addRoom(R7);A3.addRoom(R4);
		
		Resident resident1 = new Resident(100, "Sheenam", A1);
		Resident resident2 = new Resident(102, "Accolite", A2);
		Resident resident3 = new Resident(130, "Peacock", A3);
		
		ServiceStaff S1 = new ServiceStaff("TREDO",433, "Security", 10);
		ServiceStaff S2 = new ServiceStaff("GETSD",436, "Security", 7);
		
		 List<Apartment> aprts = new ArrayList<Apartment>();
		 aprts.add(A1);aprts.add(A2);aprts.add(A3);
		 
		 List<Resident> resident = new ArrayList<Resident>();
		 resident.add(resident1);resident.add(resident2);resident.add(resident3);
		 
		 List<ServiceStaff> staff = new ArrayList<ServiceStaff>();
		 staff.add(S1);staff.add(S2);
		 
		
		System.out.println("---------------------MY BUILDING-----------------------------");
		Building building = new Building("TheHeights",10000, 10, aprts, resident, staff); 
		building.displayDetails();
	}
}
