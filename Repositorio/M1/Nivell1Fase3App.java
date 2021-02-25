import javax.swing.JOptionPane;

public class Nivell1Fase3App {
	public static void main(String[] args) {
		String naixement_str=JOptionPane.showInputDialog("Introdueix el teu any de naixement");
		int naixement=Integer.parseInt(naixement_str);
		for (int i=1948; i<=naixement; i++) {
			if ((i%4)==0) {
				System.out.println(i);
			}
		}
		boolean es_traspas=((naixement%4)==0) ;
		if (es_traspas) {
			System.out.println("El teu any de naixement és any de traspàs.");
		} else {
			System.out.println("El teu any de naixement NO és any de traspàs.");
		}
		
	}
}
