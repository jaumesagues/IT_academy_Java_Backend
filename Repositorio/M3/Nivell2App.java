import java.util.Scanner;
public class Nivell2App {

	public static void main(String[] args) {
		int num_alumnes=5;
		int num_notes_alumne=3;
		int[][] notes=new int[num_alumnes][num_notes_alumne];
		double mitjana;
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		for (int i=0;i<num_alumnes; i++) {
			for (int j=0;j<num_notes_alumne;j++) {
				System.out.println("Introduir la nota num " + (j+1)+ " del alumne " + (i+1) + ":");
				notes[i][j]=myObj.nextInt();
			}
		}
		System.out.println("Notes mitjanes:");
		for (int i=0;i<num_alumnes; i++) {
			mitjana=0.0;
			for (int j=0;j<num_notes_alumne;j++) {
				mitjana+=notes[i][j];
			}
			mitjana/=num_notes_alumne;
			System.out.print("Alumne num ");
			System.out.print(i+1);
			System.out.print(" : ");
			System.out.print(mitjana);
			if (mitjana>=5) System.out.println(" Aprobat");
			else System.out.println(" Suspés");
		}
		myObj.close();
	}

}
