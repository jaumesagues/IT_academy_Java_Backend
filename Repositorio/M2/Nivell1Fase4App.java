import java.awt.List;
import java.util.ArrayList;

public class Nivell1Fase4App {

	public static void main(String[] args) {
		ArrayList<Character> nom=new ArrayList<Character>(5);
		ArrayList<Character> cognom=new ArrayList<Character>(6);
		ArrayList<Character> nom_complet=new ArrayList<Character>();
		nom.add('J');
		nom.add('a');
		nom.add('u');
		nom.add('m');
		nom.add('e');
		cognom.add('S');
		cognom.add('a');
		cognom.add('g');
		cognom.add('u');
		cognom.add('e');
		cognom.add('s');
		
		for (int i=0; i<nom.size(); i++) {
			nom_complet.add(nom.get(i));
		}
		nom_complet.add(' ');
		for (int i=0; i<cognom.size(); i++) {
			nom_complet.add(cognom.get(i));
		}
		for (int i=0; i<nom_complet.size();i++) {
		 System.out.print(nom_complet.get(i));
		}

	}

}
