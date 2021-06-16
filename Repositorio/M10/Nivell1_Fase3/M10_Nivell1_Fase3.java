
public class M10_Nivell1_Fase3 {

	public static void main(String[] args) {
		IString istring=(cadena)-> {
			String reversed_cadena="";
			for(int i=cadena.length()-1; i>=0;i--) {
				reversed_cadena+=cadena.charAt(i);
			}
			return reversed_cadena;
		};
		
		String cadena_to_reverse="Hola";
		System.out.println(istring.reverse(cadena_to_reverse));
	}

}
