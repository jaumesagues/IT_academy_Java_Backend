import java.awt.List;

public class Nivell1Fase4App {

	public static void main(String[] args) {
		List nom=new List(5);
		List cognom=new List(6);
		List nom_complet=new List();
		nom.add("J");
		nom.add("a");
		nom.add("u");
		nom.add("m");
		nom.add("e");
		cognom.add("S");
		cognom.add("a");
		cognom.add("g");
		cognom.add("u");
		cognom.add("e");
		cognom.add("s");
		
		for (int i=0; i<nom.getItemCount(); i++) {
			nom_complet.add(nom.getItem(i));
		}
		nom_complet.add(" ");
		for (int i=0; i<cognom.getItemCount(); i++) {
			nom_complet.add(cognom.getItem(i));
		}
		for (int i=0; i<nom_complet.getItemCount();i++) {
		 System.out.print(nom_complet.getItem(i));
		}

	}

}
