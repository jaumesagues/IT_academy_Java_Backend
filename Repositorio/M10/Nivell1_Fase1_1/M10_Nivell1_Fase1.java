
import java.util.ArrayList;
import java.util.function.Predicate;

public class M10_Nivell1_Fase1 {

	public static void main(String[] args) {
		ArrayList<String> llista_noms=new ArrayList<>();
		ArrayList<String> subllista_noms;
		
		llista_noms.add("Alfons");
		llista_noms.add("Jaume");
		llista_noms.add("Ada");
		llista_noms.add("Alf");
		llista_noms.add("Elo");
		
		subllista_noms=filtrar(llista_noms,(String nom)->(nom.charAt(0)=='A' && nom.length()==3));
		
		subllista_noms.forEach(nom->System.out.println(nom));
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
