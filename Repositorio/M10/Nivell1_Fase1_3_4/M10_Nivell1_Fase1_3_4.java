
import java.util.ArrayList;
import java.util.function.Predicate;

public class M10_Nivell1_Fase1_3_4 {

	public static void main(String[] args) {
		ArrayList<String> llista_paraules=new ArrayList<>();
		ArrayList<String> subllista_paraules;
		
		llista_paraules.add("Alfons");
		llista_paraules.add("Jaume");
		llista_paraules.add("Ada");
		llista_paraules.add("Alf");
		llista_paraules.add("Elo");
		
		// Punt 3 del M�dul 10, Nivell 1, Fase1
		// Tenint una llista de Strings, escriu un m�tode que retorne una 
		// llista de totes les cadenes que continguen la lletra �o� i imprimeix el resultat.
		
		subllista_paraules=filtrar(llista_paraules,(String paraula)->(paraula.contains("o")));
		
		System.out.println("Paraules que continguin la lletra 'o'");
		subllista_paraules.forEach(paraula->System.out.println(paraula));
		
		// Punt 4 del M�dul 10, Nivell 1, Fase1
		// Has de fer el mateix que en el punt anterior, per� retornant una 
		// llista que incloga els elements amb m�s de 5 lletres. Imprimeix el resultat.
		
		subllista_paraules=filtrar(llista_paraules,(String paraula)->(paraula.length()>5));
		
		System.out.println("Paraules que tenen m�s de 5 lletres");
		subllista_paraules.forEach(paraula->System.out.println(paraula));
	}
	
	public static ArrayList<String> filtrar(ArrayList<String> llista, Predicate<String> criteri) {
		ArrayList<String> subllista=new ArrayList<>();
		
		for(String nom: llista) {
			if (criteri.test(nom)) {
				subllista.add(nom);
			}
		}
		
		return subllista;
	}

}
