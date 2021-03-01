import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Nivell1Fase4App {

	public static void main(String[] args) {
		int num_ciutats=6;
		ArrayList<String> nom_ciutats=new ArrayList<String>();
		char[][] nom_ciutats_deletrejats=new char[num_ciutats][];
		char[] lletres_ciutat;
		int idx_ciutat_deletrejada;
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		for (int i=0;i<num_ciutats;i++) {
			System.out.println("Introduir nom de ciutat:");
			String nom_ciutat=myObj.nextLine();
			nom_ciutats.add(nom_ciutat);
		}
		idx_ciutat_deletrejada=0;
		for(String nom_ciutat:nom_ciutats) {
			lletres_ciutat=new char[nom_ciutat.length()];
			for (int i=0;i<nom_ciutat.length();i++) {
				lletres_ciutat[i]=nom_ciutat.charAt(i);
			}
			nom_ciutats_deletrejats[idx_ciutat_deletrejada++]=lletres_ciutat;
		}
		
		System.out.println("Les ciutats invertides:");
		for (int i=0;i<num_ciutats;i++) {
			lletres_ciutat=nom_ciutats_deletrejats[i];
			for (int j=lletres_ciutat.length-1; j>=0; j--) {
				System.out.print(lletres_ciutat[j]);
			}
			System.out.print("\n");
		}
		myObj.close();
	}

}
