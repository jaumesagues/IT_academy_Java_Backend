import java.util.ArrayList;

public class Rocket {
	
	public Rocket(String nom, int[] pot_max_propulsors) throws Exception {
		if (nom.length()!=8) throw new Exception("El nom del coet ha de tenir 6 caràcters");
		
		this.nom=nom;
		this.propulsors= new ArrayList<Propulsor>(pot_max_propulsors.length);
		for(int i=0; i<pot_max_propulsors.length;i++) {
			Propulsor prop=new Propulsor(this.nom+"-"+(i+1),pot_max_propulsors[i]);
			this.propulsors.add(i, prop);
		}
	}
	
	public synchronized void setPotencia(int potencia) throws Exception {
		int i;
		int potencia_max_tot=0;
		int potencia_obj_tot;
		int resto_potencia_obj;
		int potencia_disp_prop;
		int[] pot_objectiu=new int[propulsors.size()];
		for (Propulsor prop:propulsors) {
			potencia_max_tot+=prop.getPotencia_maxima();
		}
		
		wait();
		
		if (potencia>potencia_max_tot) 
			throw new Exception("El coet no te prou potència als seus propulsors per obtenir la potencia demanada.");
		
		double frac_pot=(double)(potencia)/(double)(potencia_max_tot);
		
		potencia_obj_tot=0;
		for(i=0; i<propulsors.size(); i++) {
			pot_objectiu[i]=(int)(frac_pot*(double)propulsors.get(i).getPotencia_maxima());
			potencia_obj_tot+=pot_objectiu[i];
		}
		resto_potencia_obj=potencia-potencia_obj_tot;
		i=0;
		while(resto_potencia_obj>0) {
			potencia_disp_prop=propulsors.get(i).getPotencia_maxima()-pot_objectiu[i];
			if (potencia_disp_prop>0) {
				if (potencia_disp_prop>=resto_potencia_obj) {
					pot_objectiu[i]+=resto_potencia_obj;
					resto_potencia_obj=0;
				} else {
					pot_objectiu[i]+=potencia_disp_prop;
					resto_potencia_obj-=potencia_disp_prop;
				}
			}
			
			if (i<propulsors.size()-1) i++;
			else throw new Exception("No ha estat posible repartir la potencia als propulsors");
		}
		
		System.out.print("Coet " + this.nom + " potència objectiu " + potencia + " : ");
		for(i=0; i<propulsors.size(); i++) {
			((Propulsor)propulsors.get(i)).setPotencia_objectiu(pot_objectiu[i]);
			System.out.print((i+1)+" : "+pot_objectiu[i]+ " ; ");
		}
		System.out.print("\n");
		
		notifyAll();
		
		ActualitzaPotencia();
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
	private ArrayList<Propulsor> propulsors;
}
