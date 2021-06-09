package rockets.views;
import javax.swing.JFrame;
import rockets.domain.Rocket;

public class RocketApp {

	public static void main(String[] args) {
		
		int [] propulsores1 = { 10, 30, 80};
		int [] propulsores2 = { 30, 40, 50, 50, 30, 10};		
		
		Rocket coet1=null;
		Rocket coet2=null;
		JFrame marc;
		try {
			coet1 = new Rocket("32WESSDS", propulsores1);
			coet2 = new Rocket("LDSFJA32", propulsores2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		if (coet1!=null && coet2!=null) {
			marc = new PantallaPrincipal(coet1, coet2);
			marc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marc.setVisible(true);
		}
	}
	
}
