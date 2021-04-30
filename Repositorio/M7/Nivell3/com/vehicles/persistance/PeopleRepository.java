package com.vehicles.persistance;

import java.util.ArrayList;
import com.vehicles.domain.*;

public class PeopleRepository {
	
	private static ArrayList<Person> people=new ArrayList<Person>();
	
    public PeopleRepository(){
		
	}
    
    public ArrayList<Person> getAllPeople(){
		return new ArrayList<>(people);
	}
    
    public Owner getOwnerByFullName(String full_name) {
    	for (Person person:people) {
    		if (person.getType()==PersonType.OWNER) {
    			if (full_name.toLowerCase().equals(person.getFullName().toLowerCase())) {
    				return (Owner)person;
    			}
    		}
    	}
    	return null;
    }
    
    public Person getPersonByFullName(String full_name) {
		for (Person person : people) {
			if (full_name.toLowerCase().equals(person.getFullName().toLowerCase())) {
				return person;
			}
		}
    	return null;
    }
	
	public void addPerson(Person person) throws Exception{
		if(person==null) throw new Exception();
		people.add(person);
	}
}
