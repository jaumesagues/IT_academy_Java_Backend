import javax.swing.JOptionPane;
public class Nivell2_2App {

	public static void main(String[] args) {
		int num_nivells=Integer.parseInt(JOptionPane.showInputDialog("Introdueix el nombre de nivells:"));
		int num_estrelles=1+(num_nivells-1)*2;
		int num_blancs=0;
		for (int i=1; i<=num_nivells;i++) {
			for (int j=1;j<=num_blancs;j++) {
				System.out.print(" ");
			}
			for (int k=1;k<=num_estrelles;k++) {
				System.out.print("*");
			}
			System.out.print("\n");
			num_blancs++;
			num_estrelles-=2;
		}
	}

}
