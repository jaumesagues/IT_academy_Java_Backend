
public class RocketApp {

	public static void main(String[] args) {
		Rocket rocket1, rocket2;

		try {
			rocket1=new Rocket("32WESSDS", 3);
			rocket2=new Rocket("LDSFJA32", 6);
			System.out.println(rocket1.toString());
			System.out.println(rocket2.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
