import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Nivell1Fase3App {

	public static void main(String[] args) {
		int num_ciutats=6;
		ArrayList<String> nom_ciutats=new ArrayList<String>();
		ArrayList<String> nom_ciutats_nous=new ArrayList<String>();
		String nom_ciutat_nou;
		char lletra;
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		for (int i=0;i<num_ciutats;i++) {
			System.out.println("Introduir nom de ciutat:");
			String nom_ciutat=myObj.nextLine();
			nom_ciutats.add(nom_ciutat);
		}
		for(String nom_ciutat:nom_ciutats) {
			nom_ciutat_nou="";
			for(int i=0; i<nom_ciutat.length();i++) {
				lletra=nom_ciutat.charAt(i);
				if (lletra=='a') lletra='4';
				nom_ciutat_nou+=lletra;
			}
			nom_ciutats_nous.add(nom_ciutat_nou);
		}
		System.out.println("Les ciutats ordenades alfabéticament:");
		Collections.sort(nom_ciutats_nous);
		for(String nom_ciutat:nom_ciutats_nous) {
			System.out.println(nom_ciutat);
		}
		myObj.close();
	}

}
