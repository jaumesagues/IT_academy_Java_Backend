package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	private String description;
	
	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		
		this.description=description;
	}

	
	@Override
	public void pay() {
		totalPaidMonth=0.0;
	}

	@Override
	public String toString() {
		return "Volunteer [name = " + super.name + " address: " + super.address + " phone: " + super.phone + " description: " + description + " total paid/month: " + super.totalPaidMonth + "]\n";
	}
}
