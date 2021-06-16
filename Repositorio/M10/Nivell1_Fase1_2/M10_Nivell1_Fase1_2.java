import java.util.ArrayList;
import java.util.function.Function;


public class M10_Nivell1_Fase1_2 {

	public static void main(String[] args) {
		ArrayList<Integer> llista_nombres=new ArrayList<>();
		String cadena_nombres;
		
		llista_nombres.add(3);
		llista_nombres.add(44);
		
		cadena_nombres=CadenaNombres(llista_nombres, (Integer i)->(i%2==0?'e'+Integer.toString(i):'o'+Integer.toString(i)));
		
		System.out.println(cadena_nombres);
	}
	
	public static String CadenaNombres(ArrayList<Integer> llista, Function<Integer, String> transformacio) {
		String llista_nombres="";
		
		boolean first=true;
		for(Integer num: llista) {
			if (!first) llista_nombres+=",";
			llista_nombres+=transformacio.apply(num);
			first=false;
		}
		
		return llista_nombres;
	}

}
