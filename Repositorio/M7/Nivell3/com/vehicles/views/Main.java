package com.vehicles.views;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.vehicles.controller.*;
import com.vehicles.domain.*;

public class Main {
	
	private static Menu main_menu;
	private static Menu people_menu;
	private static Menu vehicles_menu;
	private static Menu people_creation_menu;
	
	private static PeopleController users_controller;
	private static VehiclesController vehicles_controller;
	
	public static void main(String[] args) throws Exception {
		int main_menu_option;
		creationMenus();
		users_controller=new PeopleController();
		vehicles_controller=new VehiclesController();
		
		do {
			main_menu_option=main_menu.showMenu();
			
			switch (main_menu_option) {
			case 0:
				manageUsers();
				break;
			case 1:
				manageVehicles();
				break;
			}
			
		} while (main_menu_option!=2);
		System.out.println("S'han introduït " + users_controller.getNumPeople() + " usuaris.");
		System.out.println("S'han introduït " + vehicles_controller.getNumVehicles() + " vehicles.");
		System.out.println("El programa ha finalitzat.");
	}
	
	public static void creationMenus() {
		main_menu = new Menu("Menú principal: trii una opció de les següents", 3);
		main_menu.addOptionMenu("Usuaris");
		main_menu.addOptionMenu("Vehicles");
		main_menu.addOptionMenu("Sortir");
		
		people_menu = new Menu("Menú usuaris: trii una opció de les següents", 3);
		people_menu.addOptionMenu("Alta nou usuari");
		people_menu.addOptionMenu("Llistar usuaris");
		people_menu.addOptionMenu("Tornar al menú principal");
		
		vehicles_menu = new Menu("Menú vehicles: trii una opció de les següents", 3);
		vehicles_menu.addOptionMenu("Alta nou vehicle");
		vehicles_menu.addOptionMenu("Llistar vehicles");
		vehicles_menu.addOptionMenu("Tornar al menú principal");
		
		people_creation_menu = new Menu("Menú creació usuari: trii una opció de les següents", 3);
		people_creation_menu.addOptionMenu("Alta nou titular");
		people_creation_menu.addOptionMenu("Alta nou conductor");
		people_creation_menu.addOptionMenu("Tornar al menú anterior");
	}
	
	public static void manageUsers() throws Exception {
		int menu_users_option;
		
		do {
			menu_users_option=people_menu.showMenu();
			
			switch (menu_users_option) {
			case 0:
				createPerson();
				break;
			case 1:
				listPeople();
				break;
			}
			
		} while (menu_users_option!=2);
		
	}
	
	public static void manageVehicles() throws Exception {
		int menu_vehicles_option;
		
		do {
			menu_vehicles_option=vehicles_menu.showMenu();
			
			switch (menu_vehicles_option) {
			case 0:
				CreateVehicle();
				break;
			case 1:
				listVehicles();
				break;
			}
			
		} while (menu_vehicles_option!=2);
		
	}
	
	public static void createPerson() throws Exception {
		int menu_person_creation_option;
		
		do {
			menu_person_creation_option=people_creation_menu.showMenu();
			
			switch (menu_person_creation_option) {
			case 0:
				createOwner();
				break;
			case 1:
				createDriver();
				break;
			}
			
		} while (menu_person_creation_option!=2);
	}
	
	public static void listPeople() {
		String list_people_str="Llista d'usuaris:\n";
		list_people_str+=users_controller.getAllPeople()+"\n";
		System.out.println(list_people_str);
	}
	
	public static void createOwner() throws Exception {
		String name;
		String surname;
		Date birth_date;
		int has_parking_int;
		int has_insurance_int;
		int has_license_int;
		boolean has_parking;
		boolean has_insurance;
		
		Date license_expire_date;
		VehicleType type_license;
		
		name= JOptionPane.showInputDialog("Introduir el nom del titular:");
		if (name==null) return;
		surname=JOptionPane.showInputDialog("Introduir el cognom del titular:");
		if (surname==null) return;
		birth_date=AskDate("Introduir la data de naixement del titular:");
		if (birth_date==null) return;		
		has_parking_int= AskYesNo("Disposa de parking? 1=Si 0=No");
		if (has_parking_int==-1000) return;
		has_insurance_int=AskYesNo("Disposa d'assegurança? 1=Si 0=No");
		if (has_insurance_int==-1000) return;
		
		has_license_int= AskYesNo("Disposa de llicència? 1=Si 0=No");
		if (has_license_int==-1000) return;
		if (has_license_int==1) {
			type_license=ChooseTypeVehicle("Escolliu tipus de vehicle: 1=cotxe, 2=bicicleta, 3=camió");
			if (type_license==null) return;
			license_expire_date=AskDate("Introduir la data de caducitat de la llicència:");
			if (license_expire_date==null) return;
		} else {
			System.out.println("El titular ha de disposar de llicència.");
			return;
		}
		has_insurance=(has_insurance_int==1);
		has_parking=(has_parking_int==1);
		users_controller.createOwner(name, surname, birth_date, has_insurance, 
				has_parking, type_license, license_expire_date);
		
		System.out.println("El titular " + name + " " + surname + " ha estat donat d'alta correctament.\n");
	}
	
	public static void createDriver() throws Exception {
		String name;
		String surname;
		Date birth_date;
		int has_license_int;
		Date license_expire_date;
		VehicleType type_license;
		
		name= JOptionPane.showInputDialog("Introduir el nom del conductor:");
		if (name==null) return;
		surname=JOptionPane.showInputDialog("Introduir el cognom del conductor:");
		if (surname==null) return;
		birth_date=AskDate("Introduir la data de naixement del conductor:");
		if (birth_date==null) return;
		has_license_int= AskYesNo("Disposa de llicència? 1=Si 0=No");
		if (has_license_int==-1000) return;
		if (has_license_int==1) {
			type_license=ChooseTypeVehicle("Escolliu tipus de vehicle: 1=cotxe, 2=bicicleta, 3=camió");
			if (type_license==null) return;
			license_expire_date=AskDate("Introduir la data de caducitat de la llicència:");
			if (license_expire_date==null) return;
		} else {
			System.out.println("El conductor ha de disposar de llicència.");
			return;
		}
		users_controller.createDriver(name, surname, birth_date, type_license, license_expire_date);
		System.out.println("El conductor " + name + " " + surname + " ha estat donat d'alta correctament.\n");
	}
	
	public static void CreateVehicle() throws Exception {
		VehicleType veh_type_chosen;
		String plate;
		String brand;
		String color;
		int num_axle=0;
		Owner owner;
		ArrayList<Person> list_drivers;
		
		plate=JOptionPane.showInputDialog("Introduir matrícula:");
		if (plate==null) return;
		brand=JOptionPane.showInputDialog("Introduir marca:");
		if (brand==null) return;
		color=JOptionPane.showInputDialog("Introduir color:");
		if (color==null) return;
		
		veh_type_chosen= ChooseTypeVehicle("Escolliu tipus de vehicle: 1=cotxe, 2=bicicleta, 3=camió");
		if (veh_type_chosen==null) return;
		
		if (veh_type_chosen==VehicleType.LORRY) {
			num_axle=AskInt("Introduir el número de eixos [2, 6]",-1000);
			if (num_axle==-1000) return;
		}
		
		owner=getOwner(veh_type_chosen);
		if (owner==null) {
			System.out.println("No s'ha seleccionat un titular per al vehicle.\n");
			return;
		}
		System.out.println("El titular del vehicle és: " + owner.getFullName());
		
		list_drivers=getListDrivers(veh_type_chosen);
		if (list_drivers.size()==0) {
			System.out.println("No s'ha introduit una llista de conductors per al vehicle.\n");
			return;
		}

		try {
			switch (veh_type_chosen) {

			case CAR:
				List<Wheel>[] car_wheels=defineCarWheels();
				vehicles_controller.createCar(plate, brand, color, 
						owner, list_drivers, car_wheels);
				break;
			case BIKE:
				Wheel[] bike_wheels=defineBikeWheels();
				vehicles_controller.createBike(plate, brand, color, 
						owner, list_drivers, bike_wheels);
				break;
			case LORRY:
				ArrayList<ArrayList<Wheel>> lorry_wheels=defineLorryWheels(num_axle);
				vehicles_controller.createLorry(plate, brand, color, num_axle, 
						owner, list_drivers, lorry_wheels);
				break;
			default:
				throw new Exception("Tipus de vehicle incorrecte.");
			}
			System.out.println("El vehicle amb matrícula " + plate + " ha estat donat d'alta correctament.\n");
		} catch (Exception e) {
			System.out.println("El vehicle amb matrícula " + plate + " no ha estat donat d'alta perquè:\n"
					+e.getMessage());
		}
		
	}
	
	public static void listVehicles() {
		String list_vehicles_str="Llista de vehicles:\n";
		list_vehicles_str+=vehicles_controller.getAllVehicles()+"\n";
		
		System.out.println(list_vehicles_str);
	}
	
	public static Owner getOwner(VehicleType vehicle_type) {
		String owner_name;
		String owner_surname;
		Owner owner_found=null;
		
		do {
			owner_name = JOptionPane.showInputDialog("Introduir nom del titular del vehicle:");
			if (owner_name == null)
				return null;
			owner_surname = JOptionPane.showInputDialog("Introduir cognom del titular del vehicle:");
			if (owner_surname == null)
				return null;
			owner_found=users_controller.getOwnerByFullName(owner_name, owner_surname);
			if (owner_found==null) {
				System.out.println("No s'ha trobat cap titular amb aquest nom."
						+ " Será necessari introduir un altre nom o premer 'Cancelar'");
			} else {
				if (owner_found.getDrivingLicense().getType()!=vehicle_type) {
					System.out.println("El titular seleccionat no disposa d'una llicència adequada per aquest vehicle."
							+ " Será necessari introduir un altre nom o premer 'Cancelar'");
					owner_found=null;
				}
			}
		} while (owner_found == null);
		
		return owner_found;
	}
	
	public static ArrayList<Person> getListDrivers(VehicleType vehicle_type) {
		String person_name;
		String person_surname;
		Person person_found=null;
		ArrayList<Person> list_drivers=new ArrayList<Person>();
		do {
			person_name=JOptionPane.showInputDialog("Introduir nom del conductor:");
			if (person_name==null) {
				break;
			}
			person_surname=JOptionPane.showInputDialog("Introduir cognom del conductor:");
			if (person_name==null) {
				break;
			}
			person_found=users_controller.getPersonByFullName(person_name, person_surname);
			if (person_found==null) {
				System.out.println("No s'ha trobat cap usuari amb aquest nom."
						+ " Será necessari introduir un altre nom o premer 'Cancelar'");
			} else {
				if (person_found.getDrivingLicense().getType()!=vehicle_type) {
					System.out.println("L'usuari seleccionat no disposa d'una llicència adequada per aquest vehicle."
							+ " Será necessari introduir un altre nom o premer 'Cancelar'");
					person_found=null;
				}
			}
			if (person_found!=null) {
				System.out.println("Conductor "+person_found.getFullName()+" afegit");
				list_drivers.add(person_found);
			}
		} while (true);

		return list_drivers;
	}
	
	public static List<Wheel>[] defineCarWheels() throws Exception {
		String position_str;
		String brand;
		double diameter;
		Wheel wheel;
		List<Wheel>[] Wheels=new ArrayList[2];
		
		position_str = "davanteres";
		for (int i = 0; i < 2; i++) {
			Wheels[i]=new ArrayList<Wheel>();
			brand = JOptionPane.showInputDialog("Introduir marca de les rodes " + position_str + ":");
			if (brand==null) return null;
			
			diameter = AskDouble("Introduir el diámetre de les rodes " + position_str + ":",-1000.0);
			if (diameter==-1000.0) return null;

			for (int j = 0; j < 2; j++) {
				wheel=new Wheel(brand, diameter);
				Wheels[i].add(wheel);
			}
			position_str = "posteriors";
		}
		
		return Wheels;
	}
	
	public static Wheel[] defineBikeWheels() throws Exception {
		String position_str;
		String brand;
		double diameter;
		Wheel[] Wheels=new Wheel[2];
		
		position_str = "davantera";
		for (int i = 0; i < 2; i++) {
			brand = JOptionPane.showInputDialog("Introduir marca de la roda " + position_str + ":");
			if (brand==null) return null;
			
			diameter = AskDouble("Introduir el diámetre de les roda " + position_str + ":",-1000.0);
			if (diameter==-1000.0) return null;
			
			Wheels[i]=new Wheel(brand,diameter);
			position_str = "posterior";
		}
		
		return Wheels;
	}
	
	public static ArrayList<ArrayList<Wheel>> defineLorryWheels(int num_axle) throws Exception {
		String brand;
		double diameter;
		Wheel wheel;
		ArrayList<ArrayList<Wheel>> wheels= new ArrayList<ArrayList<Wheel>>(num_axle);
		ArrayList<Wheel> wheels_axle;
		
		for (int i = 0; i < num_axle; i++) {
			wheels_axle=new ArrayList<Wheel>(2);
			brand = JOptionPane.showInputDialog("Introduir marca de les rodes de l' eix num " + (i+1) + ":");
			if (brand==null) return null;
			
			diameter = AskDouble("Introduir el diámetre de les rodes de l' eix num " + (i+1) + ":",-1000.0);
			if (diameter==-1000.0) return null;

			for (int j = 0; j < 2; j++) {
				wheel=new Wheel(brand, diameter);
				wheels_axle.add(wheel);
			}
			wheels.add(wheels_axle);
		}
		
		return wheels;
	}
	
	public static VehicleType ChooseTypeVehicle(String message) throws Exception {
		boolean input_ok=false;
		int input;
		
		while (!input_ok) {
			try {
				input = AskInt(message, -1000);
				if (input==-1000) return null;
				if (input == 1)
					return VehicleType.CAR;
				else if (input == 2)
					return VehicleType.BIKE;
				else if (input == 3)
					return VehicleType.LORRY;
				else
					System.out.println("La resposta correcta només pot ser 1, 2 o 3.\n"
							+ " Introdueixi un altre valor o premi 'Cancelar'");
			} catch (Exception e) {
				System.out.println("La resposta correcta només pot ser 1, 2 o 3.\n"
						+ " Introdueixi un altre valor o premi 'Cancelar'");
			}
		}
		return null;
	}
	
	public static int AskYesNo(String message) throws Exception {
		int answer_int=-1000;
		boolean answer_ok=false;
		
		while (!answer_ok) {
			try {
				answer_int=AskInt(message, -1000);
				if (answer_int==-1000) return -1000;
				if (answer_int==1 || answer_int==0) {
					answer_ok=true;
				} else {
					System.out.println("La resposta correcta només pot ser 1 o 0.\n"
							+ " Introdueixi un altre valor o premi 'Cancelar'");
				}
			} catch (Exception e) {
				System.out.println("La resposta correcta només pot ser 1 o 0.\n"
						+ " Introdueixi un altre valor o premi 'Cancelar'");
			}
		}
		return answer_int;
	}
	
	public static Date AskDate(String message) throws Exception {
		String date_str;
		Date date;
		boolean data_ok=false;
		date=null;
		while (!data_ok) {
			date_str=JOptionPane.showInputDialog(message);
			if (date_str==null) return null;
			try {
				date=new Date(Date.parse(date_str));
				data_ok=true;
			} catch (Exception e) {
				System.out.println("La data introduida és errónea. "
						+ "Haurà d'introduir una altra data o prèmer 'Cancelar'");
				data_ok=false;
			}
		}
		
		return date;
	}
	
	public static int AskInt(String message, int nullnumber) throws Exception {
		String answer_str;
		int answer;
		answer_str=JOptionPane.showInputDialog(message);
		if (answer_str==null) {
			answer=nullnumber;
		} else {
			answer=Integer.parseInt(answer_str);
		}
		return answer;
	}
	
	public static double AskDouble(String message, double nullnumber) throws Exception {
		String answer_str;
		double answer=nullnumber;
		boolean answer_ok=false;
		
		while (!answer_ok) {
			answer_str = JOptionPane.showInputDialog(message);
			if (answer_str == null) {
				return nullnumber;
			} else {
				try {
					answer = Double.parseDouble(answer_str);
					answer_ok = true;
				} catch (Exception e) {
					System.out.println("El valor introduït no és correcte."
							+ "Haurà d'introduir una altre valor o prèmer 'Cancelar'");
				}
			}
		}
		
		return answer;
	}
}
