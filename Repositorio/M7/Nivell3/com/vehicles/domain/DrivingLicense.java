package com.vehicles.domain;

import java.util.Date;

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
