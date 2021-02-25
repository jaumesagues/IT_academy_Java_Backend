
import javax.swing.JOptionPane;
public class Nivell2App {

	public static void main(String[] args) {
		int num=Integer.parseInt(JOptionPane.showInputDialog("Introdueix un nombre enter:"));
		for (int i=1; i<=num;i++) {
			for (int j=1;j<=i;j++) {
				System.out.print(j+" ");
			}
			System.out.print("\n");
		}
	}

}
