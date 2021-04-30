package com.vehicles.controller;

import java.util.Date;

import com.vehicles.domain.*;
import com.vehicles.persistance.PeopleRepository;

public class PeopleController {

private PeopleRepository list_people;
	
	public PeopleController() {
		list_people = new PeopleRepository();
	}
	
	public void createOwner(String name, String surname, Date birth_date, 
			boolean has_insurance, boolean has_parking, VehicleType type_license, 
			Date expiry_date_license) throws Exception {
		Owner owner=new Owner(name,surname,birth_date, has_insurance, has_parking);
		owner.createDrivingLicense(type_license, expiry_date_license);
		list_people.addPerson(owner);
	}
	
	public void createDriver(String name, String surname, Date birth_date, 
			VehicleType type_license, Date expiry_date_license) throws Exception {
		Driver driver=new Driver(name,surname,birth_date);
		driver.createDrivingLicense(type_license, expiry_date_license);
		list_people.addPerson(driver);
	}
	
	public String getAllPeople() {
		String all_people_str="";
		
		for (Person person:list_people.getAllPeople()) {
			all_people_str+=person.getFullName()+" ";
			all_people_str+=person.getTypeToString()+"\n";
		}
		all_people_str += "El número d'usuaris presents al registre és de: ";
		all_people_str += list_people.getAllPeople().size(); 
		
		return all_people_str;
	}
	
	public Owner getOwnerByFullName(String name, String surname) {
		String full_name=name+" "+surname;
		return list_people.getOwnerByFullName(full_name);
	}
	
	public Person getPersonByFullName(String name, String surname) {
		String full_name=name+" "+surname;
		return list_people.getPersonByFullName(full_name);
	}
	
	public int getNumPeople() {
		return list_people.getAllPeople().size();
	}
}
