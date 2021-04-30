package com.vehicles.project;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) throws Exception {
		boolean owner_is_driver;
		Driver driver;
		Owner owner=CreateOwner();
		System.out.println("El titular " + owner.getFullName() + " ha estat donat d'alta correctament.");
		
		if (!owner.hasDrivingLicense()) 
			throw new Exception("Error: El titular no te llicència i no pot tenir cotxe.");
		Vehicle vehicle=CreateVehicle(owner);
		System.out.println("El vehicle amb matrícula "+vehicle.getPlate()+" ha estat creat correctament");
		
		owner_is_driver=AskYesNo("El titular és el conductor del vehicle? 1=Si 0=No");
		if (!owner_is_driver) {
			driver=createDriver(vehicle);
			System.out.println("El conductor " + driver.getFullName() + " ha estat donat d'alta correctament.");
		}
		
	}
	
	public static Owner CreateOwner() throws Exception {
		String name;
		String surname;
		Date birth_date;
		Owner owner;
		boolean has_parking;
		boolean has_insurance;
		boolean has_license;
		Date license_expire_date;
		VehicleType type_license;
		
		name= JOptionPane.showInputDialog("Introduir el nom del titular del vehicle:");
		surname=JOptionPane.showInputDialog("Introduir el cognom del titular del vehicle:");
		birth_date=AskDate("Introduir la data de naixement del titular del vehicle:");
		has_parking= AskYesNo("Disposa de parking? 1=Si 0=No");
		has_insurance=AskYesNo("Disposa d'assegurança? 1=Si 0=No");
		
		owner=new Owner(name,surname,birth_date,has_insurance, has_parking);
		
		has_license= AskYesNo("Disposa de llicència? 1=Si 0=No");
		if (has_license) {
			type_license=ChooseTypeVehicle("Escolliu tipus de vehicle: 1=cotxe, 2=bicicleta, 3=camió");
			license_expire_date=AskDate("Introduir la data de caducitat de la llicència:");
			owner.createDrivingLicense(type_license, license_expire_date);
		}
		return owner;
	}
	
	public static boolean AskYesNo(String message) throws Exception {
		int answer_int;
		boolean answer;
		
		answer_int=Integer.parseInt(JOptionPane.showInputDialog(message));
		if (answer_int==1) answer=true;
		else if (answer_int==0) answer=false;
		else throw new Exception("Error: La resposta només pot ser 1:Si 0:No");
		
		return answer;
	}
	
	public static Date AskDate(String message) throws Exception {
		String date_str;
		Date date;
		date_str=JOptionPane.showInputDialog(message);
		date=new Date(Date.parse(date_str));
		return date;
	}
	
	public static Vehicle CreateVehicle(Owner owner) throws Exception {
		Vehicle vehicle;
		VehicleType veh_type_chosen = ChooseTypeVehicle("Escolliu tipus de vehicle: 1=cotxe, 2=bicicleta, 3=camió");
		
		if (owner.getDrivingLicense().getType()!=veh_type_chosen)
			throw new Exception("El titular no pot crear un vehicle del tipus seleccionat perquè no te la llicència adecuada");
		
		switch (veh_type_chosen) {
		case CAR:
			vehicle = CreateCar();
			AddWheels((Car)vehicle);
			break;
		case BIKE:
			vehicle = CreateBike();
			AddWheels((Bike)vehicle);
			break;
		case LORRY:
			vehicle = CreateLorry();
			AddWheels((Lorry)vehicle);
			break;
		default:
			throw new Exception("Tipus de vehicle incorrecte.");
		}
		
		return vehicle;
	}
	
	public static VehicleType ChooseTypeVehicle(String message) throws Exception {
		int input=Integer.parseInt(JOptionPane.showInputDialog(message));
		if (input==1) return VehicleType.CAR;
		else if (input==2) return VehicleType.BIKE;
		else if (input==3) return VehicleType.LORRY;
		else throw new Exception("Tipus de vehicle incorrecte.");
	}
	
	public static Car CreateCar() throws Exception {
		String plate;
		String brand;
		String color;
		Car car;
		
		plate=JOptionPane.showInputDialog("Introduir matrícula:");
		brand=JOptionPane.showInputDialog("Introduir marca:");
		color=JOptionPane.showInputDialog("Introduir color:");
		
		car=new Car(plate,brand,color);
		
		return car;
	}
	
	public static Bike CreateBike() throws Exception {
		String plate;
		String brand;
		String color;
		Bike bike;
		
		plate=JOptionPane.showInputDialog("Introduir matrícula:");
		brand=JOptionPane.showInputDialog("Introduir marca:");
		color=JOptionPane.showInputDialog("Introduir color:");
		
		bike=new Bike(plate,brand,color);
		
		return bike;
	}
	
	public static Lorry CreateLorry() throws Exception {
		String plate;
		String brand;
		String color;
		int num_axle;
		Lorry lorry;
		
		plate=JOptionPane.showInputDialog("Introduir matrícula:");
		brand=JOptionPane.showInputDialog("Introduir marca:");
		color=JOptionPane.showInputDialog("Introduir color:");
		num_axle=Integer.parseInt(JOptionPane.showInputDialog("Introduir el número de eixos [2, 6]"));
		
		lorry=new Lorry(plate,brand,color,num_axle);
		
		return lorry;
	}
	
	public static void AddWheels(Car car) throws Exception {
		String position_str;
		String brand;
		double diameter;
		Wheel wheel;
		List<Wheel>[] Wheels=new ArrayList[2];
		
		position_str = "davanteres";
		for (int i = 0; i < 2; i++) {
			Wheels[i]=new ArrayList<Wheel>();
			brand = JOptionPane.showInputDialog("Introduir marca de les rodes " + position_str + ":");
			diameter = Double.parseDouble(
					JOptionPane.showInputDialog("Introduir el diámetre de les rodes " + position_str + ":"));

			for (int j = 0; j < 2; j++) {
				wheel=new Wheel(brand, diameter);
				Wheels[i].add(wheel);
			}
			position_str = "posteriors";
		}
		
		car.addWheels(Wheels[0], Wheels[1]);
	}
	
	public static void AddWheels(Bike bike) throws Exception {
		String position_str;
		String brand;
		double diameter;
		Wheel[] Wheels=new Wheel[2];
		
		position_str = "davantera";
		for (int i = 0; i < 2; i++) {
			brand = JOptionPane.showInputDialog("Introduir marca de la roda " + position_str + ":");
			diameter = Double.parseDouble(
					JOptionPane.showInputDialog("Introduir el diámetre de les roda " + position_str + ":"));
			Wheels[i]=new Wheel(brand,diameter);
			position_str = "posterior";
		}
		
		bike.addWheels(Wheels[0], Wheels[1]);
	}
	
	public static void AddWheels(Lorry lorry) throws Exception {
		String brand;
		double diameter;
		Wheel wheel;
		int num_axle=lorry.getNumAxle();
		ArrayList<ArrayList<Wheel>> wheels= new ArrayList<ArrayList<Wheel>>(num_axle);
		ArrayList<Wheel> wheels_axle;
		
		for (int i = 0; i < num_axle; i++) {
			wheels_axle=new ArrayList<Wheel>(2);
			brand = JOptionPane.showInputDialog("Introduir marca de les rodes de l' eix num " + (i+1) + ":");
			diameter = Double.parseDouble(
					JOptionPane.showInputDialog("Introduir el diámetre de les rodes de l' eix num " + (i+1) + ":"));

			for (int j = 0; j < 2; j++) {
				wheel=new Wheel(brand, diameter);
				wheels_axle.add(wheel);
			}
			wheels.add(wheels_axle);
		}
		
		lorry.addWheels(wheels);
	}
	
	public static Driver createDriver(Vehicle vehicle) throws Exception {
		String name;
		String surname;
		Date birth_date;
		Date license_expire_date;
		VehicleType type_license;
		Driver driver;
		
		name= JOptionPane.showInputDialog("Introduir el nom del conductor del vehicle:");
		surname=JOptionPane.showInputDialog("Introduir el cognom del conductor del vehicle:");
		birth_date=AskDate("Introduir la data de naixement del conductor del vehicle:");		
		type_license=ChooseTypeVehicle("Escolliu tipus de vehicle de la llicència del conductor: 1=cotxe, 2=bicicleta, 3=camió");	
		if (type_license!=vehicle.getType()) 
			throw new Exception("La llicència del conductor no coincideix amb el tipus de vehicle.");
	
		license_expire_date=AskDate("Introduir la data de caducitat del carnet de conduir:");
		
		driver=new Driver(name,surname,birth_date);
		driver.createDrivingLicense(type_license, license_expire_date);
		
		return driver;
	}
}
