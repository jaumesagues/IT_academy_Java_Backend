import java.util.ArrayList;
import java.util.function.Consumer;

public class M10_Nivell1_Fase1_5_6 {

	public static void main(String[] args) {
		ArrayList<String> mesos = new ArrayList<>();
		
		mesos.add("Gener");
		mesos.add("Febrer");
		mesos.add("Mar�");
		mesos.add("Abril");
		mesos.add("Maig");
		mesos.add("Juny");
		mesos.add("Juliol");
		mesos.add("Agost");
		mesos.add("Setembre");
		mesos.add("Octubre");
		mesos.add("Novembre");
		mesos.add("Desembre");
		
		System.out.println("Llista de mesos amb expresi� lambda:");
		Consumer<ArrayList<String>> printList=list -> list.forEach(mes->System.out.println(mes)); 	
		printList.accept(mesos);

		System.out.println("\nLlista de mesos amb refer�ncia a m�tode:");
		Consumer<ArrayList<String>> printList2=System.out::println;
		printList2.accept(mesos);
		
	}

}
