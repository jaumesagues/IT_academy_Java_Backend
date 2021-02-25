
import java.util.HashMap;
public class Nivell1Fase3App {

	public static void main(String[] args) {
		char nom[]= {'J','a','u','m','e','S','a','g','u','e','s'};
		int num_vegades=0;
		HashMap<Character,Integer> map_nom=new HashMap<Character,Integer>();
		for (char lletra:nom) {
			if (map_nom.containsKey(lletra)) {
				num_vegades=map_nom.get(lletra);
				num_vegades++;
				map_nom.put(lletra,num_vegades);
			} else {
				map_nom.put(lletra,1);
			}
		}
		System.out.print(map_nom);
	}

}
