package com.vehicles.project;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	
	enum VehicleType {
		CAR(1),
		BIKE(2);
		VehicleType(int i){
			
		};
	}

	public static void main(String[] args) throws Exception {
		VehicleType veh_type=ChooseTypeVehicle();
		
		switch (veh_type) {
		case CAR:
			Car car=CreateCar();
		    AddWheels(car);
			System.out.println("Cotxe amb matrícula "+car.getPlate()+" ha estat creat correctament.\n");
			break;
		case BIKE:
			Bike bike=CreateBike();
			AddWheels(bike);
			System.out.println("Bicicleta amb matrícula "+bike.getPlate()+" ha estat creat correctament.\n");
			break;
		default:
			 throw new Exception("Tipus de vehicle incorrecte.");	
		}
		
	}
	
	public static VehicleType ChooseTypeVehicle() throws Exception {
		int input=Integer.parseInt(JOptionPane.showInputDialog("Escolliu tipus de vehicle: 1=cotxe, 2=bicicleta"));
		if (input==1) return VehicleType.CAR;
		else if (input==2) return VehicleType.BIKE;
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
			position_str = "posteriors";
		}
		
		bike.addWheels(Wheels[0], Wheels[1]);
	}

}
