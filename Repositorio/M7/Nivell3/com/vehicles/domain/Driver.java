package com.vehicles.domain;

import java.util.Date;

public class Driver extends Person {
	
	public Driver(String name, String surname, Date birth_date) {
		super(name, surname, birth_date);
	}

	public String getTypeToString() {
		return "conductor";
	}
	
	public PersonType getType() {
		return PersonType.DRIVER;
	}
}
