
public class M10_Nivell2_2 {

	public static void main(String[] args) {
		MathOperationI suma=(a,b)->(a+b);
		MathOperationI resta=(a,b)->(a-b);
		MathOperationI mult=(a,b)->(a*b);
		MathOperationI div=(a,b)->(a/b);
		
		double a=6;
		double b=2;
		
		double c=suma.Calc(a, b);
		double d=resta.Calc(a, b);
		double e=mult.Calc(a, b);
		double f=div.Calc(a, b);
		
		System.out.println("Suma: "+c);
		System.out.println("Resta: "+d);
		System.out.println("Multiplicación: "+e);
		System.out.println("División: " + f);
	}

}
