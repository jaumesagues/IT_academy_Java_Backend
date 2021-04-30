package com.vehicles.domain;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) throws Exception {
		super(plate, brand, color);
	}
	
	public VehicleType getType() {return VehicleType.BIKE;}
	
	public String getTypeToString() { return "Bicicleta";}
	
	public void addWheels(Wheel frontWheel, Wheel backWheel) {
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}
}
