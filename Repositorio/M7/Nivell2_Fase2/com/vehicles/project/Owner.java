package com.vehicles.project;

import java.util.Date;

public class Owner extends Person {
	private boolean has_insurance;
	private boolean has_parking;
	
	public Owner(String name, String surname, Date birth_date, boolean has_insurance, boolean has_parking) {
		super(name, surname, birth_date);
		this.has_insurance=has_insurance;
		this.has_parking=has_parking;
	}

}
