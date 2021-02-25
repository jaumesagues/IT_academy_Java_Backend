
import java.awt.*;
public class Nivell1Fase2App {

	public static void main(String[] args) {
		List nom=new List(5);
		nom.add("J");
		nom.add("a");
		nom.add("u");
		nom.add("m");
		nom.add("e");
		
		for (int i=0; i<nom.getItemCount(); i++) {
			String lletra=nom.getItem(i);
			
			System.out.print(lletra);
			if (lletra.toLowerCase().matches("[aeiou]")) {
				System.out.print(" VOCAL");
			} else System.out.print(" CONSONANT");
			
			if (lletra.matches("^\\d+(\\.\\d+)?")) {
				System.out.print(" Els noms de persona no contenen números\n");
			} else System.out.print("\n");
		}

	}

}
