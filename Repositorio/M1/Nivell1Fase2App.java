import javax.swing.JOptionPane;

public class Nivell1Fase2App {

	public static void main(String[] args) {
		String any_str=JOptionPane.showInputDialog("Introdueix un any");
		int any=Integer.parseInt(any_str);
		int anys_traspas=(int)((any-1948)/4)+1;
		System.out.print("N�mero d'anys de trasp�s entre 1948 i "+any_str+" : "+anys_traspas);
	}

}
