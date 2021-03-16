import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Nivell1Fase3App {
	
	static void elaboracioMenu(HashMap<String,Float> menu, int num_plats_menu) 
	{
		String nom_plat;
		Float preu;
		int preu_ok;
		for (int i=0;i<num_plats_menu;i++) {
			nom_plat=JOptionPane.showInputDialog("Introduir el nom del plat num " + (i+1));
			preu_ok=0;
			while (preu_ok == 0) {
				try {
					preu = Float.valueOf(JOptionPane.showInputDialog("Introduir el preu del plat num " + (i + 1)));
					if (preu<=0) throw new NumberFormatException();
					menu.put(nom_plat, preu);
					preu_ok=1;
				} catch (NumberFormatException e) {
					System.out.println("El preu del plat ha de ser un nombre real superior a 0.");
					preu_ok=0;
				}
			}
		}
	}
	
	static void crearComanda(ArrayList<String> comanda)
	{
		int continuar_demanant=1;
		int cont_demanant_ok;
		String nom_plat;
		while (continuar_demanant == 1) {
			nom_plat = JOptionPane.showInputDialog("Introduir el nom del plat desitjat:");
			comanda.add(nom_plat);
			cont_demanant_ok=0;
			while (cont_demanant_ok == 0) {
				try {
					continuar_demanant = Integer
							.valueOf(JOptionPane.showInputDialog("Desitjeu continuar demanant? 1: Sí 0: No"));
					cont_demanant_ok=1;
				} catch (NumberFormatException e) {
					System.out.println("La resposta no és correcta, ha de ser o 0 o 1");
					cont_demanant_ok=0;
				}
			}
		}
	}
	
	static float calcularPreuTotal(HashMap<String,Float> menu, ArrayList<String> comanda) 
	{
		float preu;
		float preu_total=0;
		for(String nom_plat_demanat:comanda) {
			preu=menu.get(nom_plat_demanat);
			preu_total=preu_total+preu;
		}
		return preu_total;
	}

	public static void main(String[] args) {
		int num_billets_5;
		int num_billets_10;
		int num_billets_20;
		int num_billets_50;
		int num_billets_100;
		int num_billets_200;
		int num_billets_500;
		float preu_total;
		int num_plats_menu=3;
		HashMap<String,Float> menu=new HashMap<String,Float>();
		ArrayList<String> comanda=new ArrayList<String>();
		
		elaboracioMenu(menu, num_plats_menu);
		crearComanda(comanda);
		preu_total=calcularPreuTotal(menu,comanda);
		System.out.print("Preu total de la comanda:" + preu_total);
	}
}


