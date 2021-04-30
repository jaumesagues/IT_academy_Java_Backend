package com.vehicles.project;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws Exception {
		Car car=CreateCar();
	    AddWheels(car);
		System.out.println("Cotxe amb matricula "+car.getPlate()+" ha estat creat correctament.\n");
	}
	
	public static Car CreateCar() {
		String plate;
		String brand;
		String color;
		Car car;
		
		plate=JOptionPane.showInputDialog("Introduir matricula:");
		brand=JOptionPane.showInputDialog("Introduir marca:");
		color=JOptionPane.showInputDialog("Introduir color:");
		
		car=new Car(plate,brand,color);
		
		return car;
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
					JOptionPane.showInputDialog("Introduir el diametre de les rodes " + position_str + ":"));

			for (int j = 0; j < 2; j++) {
				wheel=new Wheel(brand, diameter+j);
				Wheels[i].add(wheel);
			}
			position_str = "posteriors";
		}
		
		car.addWheels(Wheels[0], Wheels[1]);
	}

}
