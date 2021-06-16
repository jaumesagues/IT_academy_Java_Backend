import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class M10_Nivell3 {

	public static void main(String[] args) {
		Alumne alumne;
		ArrayList<Alumne> list_alumnes=new ArrayList<>();
		ArrayList<Alumne> list_alumnes_a;
		ArrayList<Alumne> list_alumnes_aprobats;
		ArrayList<Alumne> list_alumnes_aprobats_noPHP;
		ArrayList<Alumne> list_alumnes_18_java;
		
		alumne=new Alumne("Jaume", 42, "JAVA", 6);
		list_alumnes.add(alumne);
		alumne=new Alumne("Alba", 16, "PHP", 3);
		list_alumnes.add(alumne);
		alumne=new Alumne("Alfons", 18, "FONAMENTS", 6);
		list_alumnes.add(alumne);
		alumne=new Alumne("Shery", 15, "JAVA", 2);
		list_alumnes.add(alumne);
		alumne=new Alumne("Laila", 20, "PHP", 5);
		list_alumnes.add(alumne);
		alumne=new Alumne("Mariano", 15, "JAVA", 4);
		list_alumnes.add(alumne);
		alumne=new Alumne("Sonia", 25, "FONAMENTS", 8);
		list_alumnes.add(alumne);
		alumne=new Alumne("Albert", 30, "PHP", 3);
		list_alumnes.add(alumne);
		alumne=new Alumne("Alf", 18, "PHP", 6);
		list_alumnes.add(alumne);
		alumne=new Alumne("Pedro", 20, "JAVA", 5);
		list_alumnes.add(alumne);
		
		System.out.println("Llista alumnes i edat:");
		Consumer<Alumne> c=(Alumne a)->System.out.println(a.getNom()+ " "+a.getEdat());
		list_alumnes.forEach(c);
		
		System.out.println("\nLlista alumnes comencen per 'A':");
		list_alumnes_a=filtrar(list_alumnes, (a)->a.getNom().charAt(0)=='A');
		list_alumnes_a.forEach(c);
		
		System.out.println("\nLlista alumnes aprobats:");
		c=(Alumne a)->System.out.println(a.getNom()+ " "+a.getEdat()+ " nota: "+a.getNota());
		list_alumnes_aprobats=filtrar(list_alumnes, (a)->a.getNota()>=5);
		list_alumnes_aprobats.forEach(c);
		
		System.out.println("\nLlista alumnes aprobats que no fan PHP:");
		c=(Alumne a)->System.out.println(a.getNom()+ " "+a.getEdat()+ " curs: "+a.getCurs()+ " nota: "+a.getNota());
		list_alumnes_aprobats_noPHP=filtrar(list_alumnes, (a)->(a.getNota()>=5 && !a.getCurs().equalsIgnoreCase("PHP")));
		list_alumnes_aprobats_noPHP.forEach(c);
		
		System.out.println("\nLlista alumnes majors d'edat que fan JAVA:");
		c=(Alumne a)->System.out.println(a.getNom()+ " "+a.getEdat()+ " curs: "+a.getCurs());
		list_alumnes_18_java=filtrar(list_alumnes, (a)->(a.getEdat()>=18 && a.getCurs().equalsIgnoreCase("JAVA")));
		list_alumnes_18_java.forEach(c);
		
		
	}
	
	public static ArrayList<Alumne> filtrar(ArrayList<Alumne> llista, Predicate<Alumne> criteri) {
		ArrayList<Alumne> subllista=new ArrayList<>();
		
		for(Alumne alumne: llista) {
			if (criteri.test(alumne)) {
				subllista.add(alumne);
			}
		}
		
		return subllista;
	}

}
