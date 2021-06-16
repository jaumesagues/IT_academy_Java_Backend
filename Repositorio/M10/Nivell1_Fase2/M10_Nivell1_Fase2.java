
public class M10_Nivell1_Fase2 {

	public static void main(String[] args) {
		PiInterface pi_interface = () -> 3.1415;
		
		System.out.print("Pi: ");
		System.out.println(pi_interface.getPiValue());
	}

}
