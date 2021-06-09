package rockets.domain;
import java.util.ArrayList;

import rockets.domain.Operacio.TipusOperacio;

public class Rocket {
	
	public Rocket(String nom, int[] pot_max_propulsors) throws Exception {
		if (nom.length()!=8) throw new Exception("El nom del coet ha de tenir 6 caràcters");
		
		this.nom=nom;
		this.propulsors= new ArrayList<Propulsor>(pot_max_propulsors.length);
		this.velocitat_inicial=0.0;
		for(int i=0; i<pot_max_propulsors.length;i++) {
			Propulsor prop=new Propulsor(this.nom+"-"+(i+1),pot_max_propulsors[i]);
			this.propulsors.add(i, prop);
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getNumPropulsors() {
		return this.propulsors.size();
	}
	
	public int getPotenciaActual() {
		int sum_potencia_actual=0;
		for (Propulsor prop:propulsors) {
			sum_potencia_actual+=prop.getPotenciaActual();
		}
		return sum_potencia_actual;
	}
	
	public int getPotenciaActual(int idx_propulsor) {
		return this.propulsors.get(idx_propulsor).getPotenciaActual();
	}
	
	public int getPotenciaMaxima(int idx_propulsor) {
		return this.propulsors.get(idx_propulsor).getPotenciaMaxima();
	}
	
	public double getVelocitatActual() {
		int potencia_actual=getPotenciaActual();
		double velocitat_actual=this.velocitat_inicial+100*Math.sqrt((double)potencia_actual);
		return velocitat_actual;
	}
	
	public void setOperacio(TipusOperacio oper) {
		for (Propulsor prop:propulsors) {
			prop.setOperacio(oper);
		}
	}
	
	public void setIncrementPotencia(int i) throws Exception {
		for (Propulsor prop: propulsors) {
			prop.setIncrementPotencia(i);
		}
	}
	
	public void ActualitzaPotencia() {
			
			for (Propulsor prop: propulsors) {
				Thread thread=new Thread(prop);
				thread.start();
			}
	}
	
	public String toString() {
		String resposta="";
		for (Propulsor prop:propulsors) {
			resposta+=prop.toString()+"\n";
		}
		return resposta;
	}

	private String nom;
	private double velocitat_inicial;
	private ArrayList<Propulsor> propulsors;
}
