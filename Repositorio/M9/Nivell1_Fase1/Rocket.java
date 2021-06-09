
public class Rocket {
	
	public Rocket(String nom, int num_propulsors) throws Exception {
		if (nom.length()!=8) throw new Exception("El nom del coet ha de tenir 6 caràcters");
		
		this.nom=nom;
		this.num_propulsors=num_propulsors;
	}
	
	@Override
	public String toString() {
		return "Rocket id=" + nom + ": Te " + num_propulsors + " propulsors";
	}

	private String nom;
	private int num_propulsors;	
}
