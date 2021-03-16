
import java.awt.*;
import java.util.ArrayList;
public class Nivell1Fase2App {

	public static void main(String[] args) {
		ArrayList<Character> nom=new ArrayList<Character>();
		nom.add('J');
		nom.add('a');
		nom.add('u');
		nom.add('1');
		nom.add('e');
		
		for (int i=0; i<nom.size(); i++) {
			Character lletra=nom.get(i);
			
			System.out.print(lletra);
			if (Character.toLowerCase(lletra)=='a' || 
					Character.toLowerCase(lletra)=='e' ||
					Character.toLowerCase(lletra)=='i' ||
					Character.toLowerCase(lletra)=='o' ||
					Character.toLowerCase(lletra)=='u') {
				System.out.print(" VOCAL");
			} else System.out.print(" CONSONANT");
			
			if (Character.isDigit(lletra)) {
				System.out.print(" Els noms de persona no contenen números\n");
			} else System.out.print("\n");
		}

	}

}
