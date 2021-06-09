
public class RocketApp {

	public static void main(String[] args) {
		Rocket rocket1, rocket2;
		double[] propulsors1= {10.0, 30.0, 80.0};
		double[] propulsors2= {30.0, 40.0, 50.0, 50.0, 30.0, 10.0};
		try {
			rocket1=new Rocket("32WESSDS", propulsors1);
			rocket2=new Rocket("LDSFJA32", propulsors2);
			System.out.println(rocket1.toString());
			System.out.println(rocket2.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
