
public class Nivell1Fase4App {

	public static void main(String[] args) {
		String nom="Jaume";
		String cognom1="Sagu�s";
		String cognom2="Rodas";
		int dia = 03;
		int mes = 02;
		int any = 1979;
		String nom_complet=nom+" "+ cognom1 + " "+cognom2;
		String data=dia+"/"+mes+"/"+any;
		boolean es_traspas=((any%4)==0);
		System.out.println("El meu nom �s "+nom_complet);
		System.out.println("Vaig n�ixer el "+data);
		if (es_traspas) {
			System.out.println("El meu any de naixement �s any de trasp�s.");
		} else {
			System.out.println("El meu any de naixement NO �s any de trasp�s.");
		}
	}

}
