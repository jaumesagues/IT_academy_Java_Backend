
public class Propulsor {
	
	public Propulsor(double max_potencia) {
		maxima_potencia=max_potencia;
	}
	
	@Override
	public String toString() {
		return Double.toString(maxima_potencia) ;
	}

	private double maxima_potencia;
}
