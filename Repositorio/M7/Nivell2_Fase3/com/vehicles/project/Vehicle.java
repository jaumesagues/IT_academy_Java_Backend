package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) throws Exception {
		if (checkPlate(plate)) {
			this.plate = plate;
		} else {
			throw new Exception("La matrícula no és correcte.");
		}
		this.brand = brand;
		this.color = color;
	}
	
	public String getPlate() {
		return plate;
	}
	
	public abstract VehicleType getType();
	
	private static boolean checkPlate(String plate) {
		int num_int_allowed=4;
		int num_char_min=2;
		int num_char_max=3;
		int num_char=0;
		int num_int=0;
		char c;
		
		for (int i=0; i<plate.length();i++) {
			c=plate.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
				return false;
			} else if(Character.isAlphabetic(c)) {
				num_char++;
			} else if (Character.isDigit(c)) {
				num_int++;
			}
			
			if (num_char>num_char_max || num_int>num_int_allowed) return false;
		}
		
		if (num_char<num_char_min || num_int<num_int_allowed) return false;
		
		return true;
	}
}
