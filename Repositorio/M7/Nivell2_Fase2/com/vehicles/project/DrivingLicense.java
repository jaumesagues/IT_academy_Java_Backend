package com.vehicles.project;

import java.util.Date;

enum VehicleType {
	CAR(1),
	BIKE(2),
	LORRY(3);
	VehicleType(int i){
		
	};
}

public class DrivingLicense {
	private static int last_id=0;
	private int id;
	private VehicleType type;
	private String fullname;
	private Date expiry_date;
	
	public DrivingLicense(VehicleType type, String fullname, Date expiry_date) {
		this.id=++last_id;
		this.type=type;
		this.fullname=fullname;
		this.expiry_date=expiry_date;
	}
	
	public VehicleType getType() { return type; }
}
