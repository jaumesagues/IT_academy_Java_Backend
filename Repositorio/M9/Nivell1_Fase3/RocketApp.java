
public class RocketApp {

	public static void main(String[] args) {
		Rocket rocket1, rocket2;
		int[] propulsors1= {10, 30, 80};
		int[] propulsors2= {30, 40, 50, 50, 30, 10};
		try {
			rocket1=new Rocket("32WESSDS", propulsors1);
			rocket1.setPotencia(50);		
			//System.out.println(rocket1.toString());
			rocket2=new Rocket("LDSFJA32", propulsors2);
			rocket2.setPotencia(70);
			rocket1.setPotencia(30);
			rocket2.setPotencia(10);
			//System.out.println(rocket2.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
