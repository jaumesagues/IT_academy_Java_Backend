import java.util.ArrayList;

public class Rocket {
	
	public Rocket(String nom, double[] pot_max_propulsors) throws Exception {
		if (nom.length()!=8) throw new Exception("El nom del coet ha de tenir 6 caràcters");
		
		this.nom=nom;
		this.propulsors= new ArrayList<Propulsor>(pot_max_propulsors.length);
		for(int i=0; i<pot_max_propulsors.length;i++) {
			Propulsor prop=new Propulsor(pot_max_propulsors[i]);
			this.propulsors.add(i, prop);
		}
	}
	
	public String toString() {
		String resposta="Rocket id=" + nom + "\nPotència Màxima propulsors: [ ";
		for (Propulsor prop:propulsors) {
			resposta+=prop.toString()+" ";
		}
		resposta+="]";
		return resposta;
	}

	private String nom;
	private ArrayList<Propulsor> propulsors;
}
