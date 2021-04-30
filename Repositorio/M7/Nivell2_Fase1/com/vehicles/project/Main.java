package com.vehicles.project;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	
	enum VehicleType {
		CAR(1),
		BIKE(2),
		LORRY(3);
		VehicleType(int i){
			
		};
	}

	public static void main(String[] args) throws Exception {
		VehicleType veh_type=ChooseTypeVehicle();
		
		switch (veh_type) {
		case CAR:
			Car car=CreateCar();
		    AddWheels(car);
			System.out.println("Cotxe amb matr�cula "+car.getPlate()+" ha estat creat correctament.\n");
			break;
		case BIKE:
			Bike bike=CreateBike();
			AddWheels(bike);
			System.out.println("Bicicleta amb matr�cula "+bike.getPlate()+" ha estat creat correctament.\n");
			break;
		case LORRY:
			Lorry lorry=CreateLorry();
			AddWheels(lorry);
			System.out.println("Cami� amb matr�cula "+lorry.getPlate()+" ha estat creat correctament.\n");
			break;
		default:
			 throw new Exception("Tipus de vehicle incorrecte.");	
		}
		
	}
	
	public static VehicleType ChooseTypeVehicle() throws Exception {
		int input=Integer.parseInt(JOptionPane.showInputDialog("Escolliu tipus de vehicle: 1=cotxe, 2=bicicleta, 3=cami�"));
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
		
		plate=JOptionPane.showInputDialog("Introduir matr�cula:");
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
		
		plate=JOptionPane.showInputDialog("Introduir matr�cula:");
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
		
		plate=JOptionPane.showInputDialog("Introduir matr�cula:");
		brand=JOptionPane.showInputDialog("Introduir marca:");
		color=JOptionPane.showInputDialog("Introduir color:");
		num_axle=Integer.parseInt(JOptionPane.showInputDialog("Introduir el n�mero de eixos [2, 6]"));
		
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
					JOptionPane.showInputDialog("Introduir el di�metre de les rodes " + position_str + ":"));

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
					JOptionPane.showInputDialog("Introduir el di�metre de les roda " + position_str + ":"));
			Wheels[i]=new Wheel(brand,diameter);
			position_str = "posteriors";
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
					JOptionPane.showInputDialog("Introduir el di�metre de les rodes de l' eix num " + (i+1) + ":"));

			for (int j = 0; j < 2; j++) {
				wheel=new Wheel(brand, diameter);
				wheels_axle.add(wheel);
			}
			wheels.add(wheels_axle);
		}
		
		lorry.addWheels(wheels);
	}
}
