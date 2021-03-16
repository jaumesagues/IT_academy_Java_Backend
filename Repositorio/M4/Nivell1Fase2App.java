import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Nivell1Fase2App {

	public static void main(String[] args) {
		int num_billets_5;
		int num_billets_10;
		int num_billets_20;
		int num_billets_50;
		int num_billets_100;
		int num_billets_200;
		int num_billets_500;
		float preu_total;
		String nom_plat;
		Float preu;
		HashMap<String,Float> menu=new HashMap<String,Float>();
		ArrayList<String> comanda=new ArrayList<String>();
		int num_plats_menu=3;
		int continuar_demanant=1;
		for (int i=0;i<num_plats_menu;i++) {
			nom_plat=JOptionPane.showInputDialog("Introduir el nom del plat num " + (i+1));
			preu=Float.valueOf(JOptionPane.showInputDialog("Introduir el preu del plat num " + (i+1)));
			menu.put(nom_plat, preu);
		}
		preu_total=0;
		while (continuar_demanant==1) {
			nom_plat=JOptionPane.showInputDialog("Introduir el nom del plat desitjat:");
			comanda.add(nom_plat);
			continuar_demanant=Integer.valueOf(JOptionPane.showInputDialog("Desitjeu continuar demanant? 1: Sí 0: No"));
		}
		System.out.print(comanda);
	}

}
