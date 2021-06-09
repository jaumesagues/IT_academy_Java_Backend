package rockets.domain;

import rockets.domain.Operacio.TipusOperacio;

public class Propulsor implements Runnable {
	
	public Propulsor(String id, int max_potencia) {
		this.id=id;
		potencia_maxima=max_potencia;
		potencia_actual=0;
		increment_potencia=1;
		operacio=TipusOperacio.MANTENIR;
	}
	
	public int getPotenciaActual() {
		return potencia_actual;
	}
	
	public int getPotenciaMaxima() {
		return potencia_maxima;
	}
	
	public int getIncrementPotencia() {
		return increment_potencia;
	}
	
	public void setIncrementPotencia(int incr_pot) throws Exception {
		if (incr_pot>=0 && incr_pot<=5) {
			increment_potencia=incr_pot;
		} else {
			throw new Exception("L'increment de potència ha de ser un valor entre 0 i 5");
		}
	}
	
	public TipusOperacio getOperacio() {
		return operacio;
	}
	
	public void setOperacio(TipusOperacio oper) {
		operacio=oper;
	}
	
	public void run () {
		while (true) {
			ActualitzaPotencia();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void ActualitzaPotencia() {
		if (operacio==TipusOperacio.ACCELERAR) {
			potencia_actual+=increment_potencia;
			if (potencia_actual>potencia_maxima) potencia_actual=potencia_maxima;
		} else if (operacio==TipusOperacio.FRENAR) {
			potencia_actual-=increment_potencia;
			if (potencia_actual<0) potencia_actual=0;
		}
	}
	
	@Override
	public String toString() {
		return id+" Potencia conseguida: " + 
				Integer.toString(potencia_actual) + " " +
				Integer.toString(potencia_maxima);
	}
	
	private int increment_potencia;
	private int potencia_maxima;
	private int potencia_actual;
	private TipusOperacio operacio;
	private String id;
}
