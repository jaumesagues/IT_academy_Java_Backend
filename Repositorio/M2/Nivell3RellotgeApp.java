import java.time.LocalDateTime;
public class Nivell3RellotgeApp {

	public static void main(String[] args) throws InterruptedException {
		
		int hora=0;
		int minut=0;
		int segon=0;
		String rellotge_str;
		while (true) {
			LocalDateTime locaDate = LocalDateTime.now();
			hora  = locaDate.getHour();
			minut = locaDate.getMinute();
			segon = locaDate.getSecond();
			rellotge_str="";
			if (hora<10) rellotge_str+="0";
			rellotge_str+=String.valueOf(hora);
			rellotge_str+=":";
			if(minut<10) rellotge_str+="0";
			rellotge_str+=String.valueOf(minut);
			rellotge_str+=":";
			if(segon<10) rellotge_str+="0";
			rellotge_str+=String.valueOf(segon);
			System.out.println(rellotge_str);
			Thread.sleep(1000);
		}
	}

}
