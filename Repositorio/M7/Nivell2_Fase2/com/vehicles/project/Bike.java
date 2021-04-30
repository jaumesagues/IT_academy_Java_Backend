package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) throws Exception {
		super(plate, brand, color);
	}

	public void addWheels(Wheel frontWheel, Wheel backWheel) {
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}
}
