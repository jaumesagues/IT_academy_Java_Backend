package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 9000.0);
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 1000.0);
		controller.createJunior("Laura Junior", "Dirección molona 3", "625266666", 1000.0);
		controller.createMid("Jaume Mid", "Dirección molona 3", "625266666", 2000.0);
		controller.createSenior("Jordi Senior", "Dirección molona 3", "625266666", 3000.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666",300);
		controller.createManagerEmployee("Pedro Manager", "Dirección molona 2", "665226666", 4000.0);
		
		controller.payAllEmployeers();
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
	}

}
