import java.util.ArrayList;
import java.util.Comparator;

public class M10_Nivell2_1 {

	public static void main(String[] args) {
		ArrayList<String> list_strings=new ArrayList<>();
		
		list_strings.add("Hola");
		list_strings.add("Jaume");
		list_strings.add("Verd");
		list_strings.add("100");
		list_strings.add("3.1415");
		
		// Ordenar de menor a major longitud
		Comparator<String> menor_longitud;
		menor_longitud=(a,b)->a.length()-b.length();
		list_strings.sort(menor_longitud);
		
		System.out.println("Ordenació de menor a major longitud:");
		list_strings.forEach(cadena->System.out.println(cadena));
		
		// Ordenar de major a menor longitud
		Comparator<String> major_longitud;
		major_longitud=(a,b)->b.length()-a.length();
		list_strings.sort(major_longitud);
		
		System.out.println("\nOrdenació de major a menor longitud:");
		list_strings.forEach(cadena->System.out.println(cadena));
		
		// Ordenar per ordre alfabètic del primer caràcter
		Comparator<String> primer_caracter;
		primer_caracter=(a,b)->a.charAt(0)-b.charAt(0);
		list_strings.sort(primer_caracter);
		
		System.out.println("\nOrdenació per ordre alfabètic del primer caràcter:");
		list_strings.forEach(cadena->System.out.println(cadena));
		
		// Ordenar en primer lloc les paraules que contenen e
		Comparator<String> conte_e;
		conte_e=(a,b)->{
			if (a.contains("e") && !b.contains("e")) return -1;
			else if (!a.contains("e") && b.contains("e")) return 1;
			else return 0;
		};
		list_strings.sort(conte_e);
		
		System.out.println("\nOrdenació en primer lloc les paraules que contenen 'e':");
		list_strings.forEach(cadena->System.out.println(cadena));
		
		list_strings.replaceAll(cadena->cadena.replaceAll("a", "4"));
		System.out.println("\nSubstituir 'a' per '4':");
		list_strings.forEach(cadena->System.out.println(cadena));
		
		// Ordenar per ordre alfabètic del primer caràcter
		Comparator<String> numeric_primer;
		numeric_primer=(a,b)->{
			if (a.matches("[-+]?\\d*\\.?\\d+") && !b.matches("[-+]?\\d*\\.?\\d+")) return -1;
			else if (!a.matches("[-+]?\\d*\\.?\\d+") && b.matches("[-+]?\\d*\\.?\\d+")) return 1;
			else return 0;
		};
		list_strings.sort(numeric_primer);
		
		System.out.println("\nOrdenació en primer lloc els números:");
		list_strings.forEach(cadena->System.out.println(cadena));
	}

}
