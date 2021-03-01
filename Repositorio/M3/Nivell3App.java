import java.util.Scanner;
public class Nivell3App {

	public static void main(String[] args) {
		int[] ultims_fibonacci= {0,1};
		Scanner myObj = new Scanner(System.in);
		System.out.println("Introduir nombre:");
		int nombre=myObj.nextInt();
		int nou;
		if (nombre<0) System.out.println("El nombre ha de ser positiu.");
		System.out.print(ultims_fibonacci[0]+", ");
		if (nombre>0) System.out.print(ultims_fibonacci[1]+", ");
		if (nombre>1) {
			for(int i=1;i<=nombre-1;i++) {
				nou=ultims_fibonacci[1]+ultims_fibonacci[0];
				System.out.print(nou+", ");
				ultims_fibonacci[0]=ultims_fibonacci[1];
				ultims_fibonacci[1]=nou;
			}
		}
		myObj.close();
	}

}
