package com.vehicles.project;

import java.util.ArrayList;

public class Lorry extends Vehicle {
	
	private int num_axle;
	
	public Lorry(String plate, String brand, String color, int num_axle) throws Exception {
		super(plate, brand, color);
		if (num_axle<2 || num_axle>6) throw new Exception("El camió ha de tenir 2 eixos com a mínim i 6 com a màxim");
		this.num_axle=num_axle;
	}
	
	public int getNumAxle() {return num_axle;}
	
	public void addWheels(ArrayList<ArrayList<Wheel>> wheels) throws Exception {
		Wheel rightWheel;
		Wheel leftWheel;
		int num_axle=wheels.size();
		
		if (num_axle!=this.num_axle) throw new Exception("El número d'eixos presents al set de rodes introduït (" +
		num_axle + ") no coincideix amb el número d'aixos del camió " + this.num_axle);
		
		for (int i=0; i<num_axle;i++) {
			if (wheels.get(i).size()!=2)  throw new Exception("El número de rodes per eix ha de ser de 2");
			leftWheel=wheels.get(i).get(0);
			rightWheel=wheels.get(i).get(1);
			if (!rightWheel.equals(leftWheel))
				throw new Exception("Les rodes als dos costats han de ser iguals.");
			this.wheels.add(leftWheel);
			this.wheels.add(rightWheel);
		}
	}

}
