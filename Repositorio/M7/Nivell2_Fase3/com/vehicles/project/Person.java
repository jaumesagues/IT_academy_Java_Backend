package com.vehicles.project;

import java.util.Date;

public class Person {
	protected String name;
	protected String surname;
	protected Date birth_date;
	protected DrivingLicense driving_license;
	
	Person(String name, String surname, Date birth_date) {
		this.name=name;
		this.surname=surname;
		this.birth_date=birth_date;
		driving_license=null;
	}
	
	public String getFullName() {
		return this.name + " " + this.surname;
	}
	
	public DrivingLicense getDrivingLicense() { return driving_license;}
	
	public boolean hasDrivingLicense() {
		return (driving_license!=null);
	}
	
	public void createDrivingLicense(VehicleType type, Date expiry_date) {
		String fullname=this.name+" "+this.surname;
		driving_license=new DrivingLicense(type,fullname,expiry_date);
	}	
	
}
