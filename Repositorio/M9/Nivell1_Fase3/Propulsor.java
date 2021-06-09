
public class Propulsor implements Runnable {
	
	public Propulsor(String id, int max_potencia) {
		this.id=id;
		potencia_maxima=max_potencia;
		potencia_actual=0;
		potencia_objectiu=0;
	}
	
	public int getPotencia_objectiu() {
		return potencia_objectiu;
	}

	public void setPotencia_objectiu(int potencia_objectiu) {
		this.potencia_objectiu = potencia_objectiu;
	}
	
	public int getPotencia_maxima() {
		return potencia_maxima;
	}

	public void setPotenciaObjectiu(int potencia) throws Exception {
		if (potencia>potencia_maxima || potencia_maxima<0) {
			throw new Exception("La potencia objectiu ha de ser un número positiu no superior a la potencia máxima");
		}
		potencia_objectiu=potencia;
	}
	
	public void run () {
		while (potencia_actual!=potencia_objectiu) {
			ActualitzaPotencia();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void ActualitzaPotencia() {
		if (potencia_actual<potencia_objectiu) potencia_actual++;
		else if (potencia_actual>potencia_objectiu) potencia_actual--;
		
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return id+" Potencia conseguida: " + 
				Double.toString(potencia_actual) + " " +
				Double.toString(potencia_objectiu) + " "+
				Double.toString(potencia_maxima) ;
	}
	
	private int potencia_maxima;
	private int potencia_actual;
	private int potencia_objectiu;

	private String id;
}
