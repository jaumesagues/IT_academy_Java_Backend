package com.vehicles.controller;

import com.vehicles.persistance.VehiclesRepository;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.domain.*;

public class VehiclesController {
	
	private VehiclesRepository list_vehicles;
	
	public VehiclesController() {
		list_vehicles = new VehiclesRepository();
	}
	
	public void createCar(String plate, String brand, String color, Owner owner, 
			ArrayList<Person> list_drivers, List<Wheel>[] wheels) throws Exception {
		Car car=new Car(plate, brand, color);
		car.setOwner(owner);
		car.setListDrivers(list_drivers);
		car.addWheels(wheels[0], wheels[1]);
		list_vehicles.addVehicle(car);
	}
	
	public void createBike(String plate, String brand, String color, Owner owner, 
			ArrayList<Person> list_drivers, Wheel[] wheels) throws Exception {
		Bike bike=new Bike(plate, brand, color);
		bike.setOwner(owner);
		bike.setListDrivers(list_drivers);
		bike.addWheels(wheels[0], wheels[1]);
		list_vehicles.addVehicle(bike);
	}
	
	public void createLorry(String plate, String brand, String color, int num_axle, 
			Owner owner, ArrayList<Person> list_drivers, ArrayList<ArrayList<Wheel>> wheels) throws Exception {
		Lorry lorry=new Lorry(plate, brand, color, num_axle);
		lorry.setOwner(owner);
		lorry.setListDrivers(list_drivers);
		lorry.addWheels(wheels);
		list_vehicles.addVehicle(lorry);
	}
	
	public String getAllVehicles() {
		String all_vehicles_str="";
		
		for (Vehicle veh:list_vehicles.getAllVehicles()) {
			all_vehicles_str+=veh.getPlate() + " ";
			all_vehicles_str+=veh.getTypeToString() + " ";
			all_vehicles_str+=veh.getBrand() + "\n";
		}
		all_vehicles_str+="El número de vehicles presents al registre és: ";
		all_vehicles_str+=list_vehicles.getAllVehicles().size();
		
		return all_vehicles_str;
	}
	
	public int getNumVehicles() {
		return list_vehicles.getAllVehicles().size();
	}

}
