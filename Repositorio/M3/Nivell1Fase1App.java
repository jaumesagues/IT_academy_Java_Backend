import java.util.Scanner;
public class Nivell1Fase1App {

	public static void main(String[] args) {
		// Enlloc de crear 6 variables he creat un array per fer l'exercici més interessant
		int num_ciutats=6;
		String[] nom_ciutats=new String[num_ciutats];
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		for (int i=0;i<num_ciutats;i++) {
			System.out.println("Introduir nom de ciutat:");
			String nom_ciutat=myObj.nextLine();
			nom_ciutats[i]=nom_ciutat;
		}
		System.out.println("Les ciutats introduïdes:");
		for(String nom_ciutat:nom_ciutats) {
			System.out.println(nom_ciutat);
		}
		myObj.close();
	}

}
