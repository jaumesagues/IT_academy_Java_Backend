package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	private String description;
	private double aidPerMonth;
	
	public Volunteer(String name, String address, String phone, String description, double aidPerMonth) throws Exception {
		super(name, address, phone);
		this.description=description;
		this.aidPerMonth=aidPerMonth;
	}

	
	@Override
	public void pay() {
		totalPaidGrossMonth=aidPerMonth;
		totalPaidGrossAnnual=totalPaidGrossMonth*14;
		totalPaidNetMonth=aidPerMonth;
		totalPaidNetAnnual=totalPaidNetMonth*14;
	}


	@Override
	public String toString() {
		return "Volunteer [name=" + name + ", address=" + address + ", phone=" + phone + ", totalPaidGrossAnnual="
				+ totalPaidGrossAnnual + ", totalPaidGrossMonth=" + totalPaidGrossMonth + ", description=" + description
				+ "]";
	}
	
}
