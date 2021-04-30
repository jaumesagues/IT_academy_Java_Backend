package com.vehicles.persistance;

import java.util.ArrayList;
import com.vehicles.domain.Vehicle;

public class VehiclesRepository {
	
	private static ArrayList<Vehicle> vehicles=new ArrayList<Vehicle>();
	
    public VehiclesRepository(){
		
	}
    
    public ArrayList<Vehicle> getAllVehicles(){
		return new ArrayList<>(vehicles);
	}
	
	
	public void addVehicle(Vehicle vehicle) throws Exception{
		if(vehicle==null) throw new Exception();
		vehicles.add(vehicle);
	}
}
