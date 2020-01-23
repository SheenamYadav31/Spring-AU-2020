package com.springau.composite;

import java.util.ArrayList;
import java.util.List;

class Resident implements person{
	
	private String name;
	private int id;
	private Apartment aprt;
	
	public Resident(int id, String name, Apartment aprt) {
		this.id = id;
		this.name = name;
		this.aprt = aprt;
	}
	
	@Override
	public String toString() {
		return "Resident [name=" + name + ", id=" + id +" ,Door No = "+ this.aprt.getname() +"]";
	}

	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Apartment getApartment() {
		return this.aprt;
	}
}

class ServiceStaff implements person{
	
	private String name;
	private int serviceId;
	private String serviceType;
	private int serviceYears;
	
	public ServiceStaff(String name, int serviceId, String serviceType, int years) {
		this.name = name;
		this.serviceId = serviceId;
		this.serviceType = serviceType;
		this.serviceYears = years;
	}
	 
	@Override
	public String toString() {
		return "ServiceStaff [name=" + name + ", serviceId=" + serviceId + ", serviceType=" + serviceType
				+ ", serviceYears=" + serviceYears + "]";
	}

	public String getName() {
		return this.name;
	}
	 
	public int getId() {
		
		return this.serviceId;
	}
	
	public String getServiceType() {
		return this.serviceType;
	}
	
	public int getServiceYears() {
		return this.getServiceYears();
	}
	
}


class Building implements structure{
	
	private int size;
	private int floors;
	private String name;
	
	private List<Apartment> apartments = new ArrayList<Apartment>();
	private List<Resident> residents = new ArrayList<Resident>();
	private List<ServiceStaff> staff = new ArrayList<ServiceStaff>();
	
	public Building(String name, int size, int floors,List<Apartment> apartments,  List<Resident> residents,  List<ServiceStaff> staff ){
		this.size = size;
		this.floors = floors;
		this.name = name;
		this.apartments = apartments;
		this.residents = residents;
		this.staff = staff;
	}

	public String toString() {
		return "Building [size=" + this.size + ", floors=" + this.floors + ", name=" + this.name + ", apartments=" + this.apartments
				+ ", residents=" + this.residents + ", staff=" + this.staff + "]";
	}
	
	public void displayDetails() {
		System.out.println("-------------------------------------------------");
		System.out.println(this.name+" has "+ this.floors+ " floors and covers area of "+this.size+".");
		System.out.println("-------------------------------------------------");
		System.out.println("Apartments: ");
		for(Apartment A : this.apartments) {	
			System.out.println(A);
			System.out.println("..........");
		}
		System.out.println("-------------------------------------------------");
		System.out.println("Residents: ");
		for(Resident R : this.residents) {
			System.out.println(R);
			System.out.println("..........");
		}
		System.out.println("-------------------------------------------------");
		System.out.println("Service Staff Members: ");
		for(ServiceStaff S : this.staff) {
			System.out.println(S);
			System.out.println("..........");
		}
		System.out.println("==================================================");
		
	}

	public int getsize() {
		return this.size;
	}

	public int getfloor() {
		return this.floors;
	}

	public String getname() {
		return this.name;
	}
	
	public List<Apartment> getAllApartments(){
		return this.apartments;
	}
	
}


class Apartment implements structure{
	
	int size;
	int floornum;
	String doornum;
	
	private List<Room> rooms = new ArrayList<Room>();
	
	public Apartment(String doornum, int size, int floornum) {
		this.doornum = doornum;
		this.size = size;
		this.floornum = floornum;
	}
	
	public void addRoom(Room room) {
		this.rooms.add(room);
	}

	public int getsize() {
		return this.size;
	}

	public int getfloornum() {
		return this.floornum;
	}

	public String getname() {
		return this.doornum;
	}
	
	public List<Room> getAllRooms(){
		return this.rooms;
	}

	public int getfloor() {
		// TODO Auto-generated method stub
		return this.floornum;
	}
	
	public void ROOMS() {
		System.out.println("Apartment [size=" + this.size + ", floornum=" + this.floornum + ", doornum=" + this.doornum+" .");
		for(Room r : this.rooms) System.out.println(r);
	}

	public String toString() {
		this.ROOMS();
		return "";
	}
}


class Room implements structure{
	
	private int size;
	private String roomType;
	boolean balcony;
	
	public Room(String roomType, int size, boolean balcony) {
		this.roomType = roomType;
		this.size = size;
		this.balcony = balcony;
	}

	public int getsize() {
		return this.size;
	}

	@Override
	public String toString() {
		return "Room [size=" + size + ", roomType=" + roomType + ", balcony=" + balcony + "]";
	}

	public int getfloor() {
		// TODO Auto-generated method stub
		return -1;
	}

	public String getname() {
		return this.roomType;
	}
	
	public boolean hasBalcony() {
		return this.balcony;
	}
	
}