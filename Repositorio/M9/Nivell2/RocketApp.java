import javax.swing.JOptionPane;

public class RocketApp {

	public static void main(String[] args) {
		Rocket rocket1, rocket2;
		int[] propulsors1= {10, 30, 80};
		int[] propulsors2= {30, 40, 50, 50, 30, 10};
		double velocitat_ini=0.0;
		double velocitat_fin;
		try {
			rocket1=new Rocket("32WESSDS", propulsors1);
			velocitat_fin=demanaDouble("Velocitat final", "Introduir velocitat desitjada", -1000.0);		
			while (velocitat_fin>=0.0) {
				System.out.println("Velocitat final: "+ velocitat_fin);
				rocket1.setPotencia(velocitat_ini, velocitat_fin);
				rocket1.ActualitzaPotencia();
				velocitat_ini=velocitat_fin;
				velocitat_fin=demanaDouble("Velocitat final", "Introduir velocitat desitjada", -1000.0);
			}
			System.out.println("Has sortit del programa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	public static double demanaDouble(String titol, String textSobreLaDadaAdemanar, double nullnumber) throws Exception {
		String answer_str;
		double answer;
		answer_str=JOptionPane.showInputDialog(null, textSobreLaDadaAdemanar, titol, JOptionPane.QUESTION_MESSAGE);
		if (answer_str==null) {
			answer=nullnumber;
		} else {
			answer=Double.parseDouble(answer_str);
		}
		return answer;
	}

}
