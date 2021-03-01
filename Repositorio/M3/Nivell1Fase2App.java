import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Nivell1Fase2App {

	public static void main(String[] args) {
		int num_ciutats=6;
		ArrayList<String> nom_ciutats=new ArrayList<String>();
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		for (int i=0;i<num_ciutats;i++) {
			System.out.println("Introduir nom de ciutat:");
			String nom_ciutat=myObj.nextLine();
			nom_ciutats.add(nom_ciutat);
		}
		System.out.println("Les ciutats ordenades alfabéticament:");
		Collections.sort(nom_ciutats);
		for(String nom_ciutat:nom_ciutats) {
			System.out.println(nom_ciutat);
		}
		myObj.close();
	}

}
