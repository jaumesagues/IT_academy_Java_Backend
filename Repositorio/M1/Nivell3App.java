
public class Nivell3App {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int idx = 0;
		int aux;
		while (idx < array.length - idx - 1) {
			aux=array[idx];
			array[idx]=array[array.length - idx - 1];
			array[array.length - idx - 1]=aux;
			idx++;
		}
		for(idx=0;idx<array.length;idx++) {
			System.out.println(array[idx]);
		}
	}
}
