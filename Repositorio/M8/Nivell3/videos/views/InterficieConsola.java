package videos.views;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import videos.controller.VideosController;
import videos.model.domini.Usuari;
import videos.model.domini.Video;

public class InterficieConsola {

	private static VideosController videos_controlador;
	private static Menu menu_principal;
	private static Menu menu_videos;
	private static Menu menu_reproduccio;
	
	public InterficieConsola() {
		videos_controlador=new VideosController();
	}
	
	public void Execute() {
		int menu_principal_opcio;
		Usuari usuari;
		creacioMenus();
		
		do {
			menu_principal_opcio=menu_principal.showMenu();
			switch (menu_principal_opcio) {
			case 0:
				usuari=AfegirUsuari();
				if (usuari!=null) GestionarVideos(usuari);
				break;
			case 1:
				LlistarUsuaris();
				break;
			}
		} while (menu_principal_opcio!=2);
		System.out.println("El programa ha finalitzat.");
	}
	
	private void creacioMenus() {
		menu_principal=new Menu("Trii una de les següents opcions:", 3);
		menu_principal.addOptionMenu("Afegir nou usuari.");
		menu_principal.addOptionMenu("LListar usuaris.");
		menu_principal.addOptionMenu("Sortir");
		
		menu_videos=new Menu("Trii una de les següents opcions:", 4);
		menu_videos.addOptionMenu("Pujar vídeo.");
		menu_videos.addOptionMenu("Llistar vídeos.");
		menu_videos.addOptionMenu("Reproducció.");
		menu_videos.addOptionMenu("Tornar al menú principal.");
		
		menu_reproduccio=new Menu("Trii una de las següents opcions: ",5);
		menu_reproduccio.addOptionMenu("Reproduir.");
		menu_reproduccio.addOptionMenu("Pausar.");
		menu_reproduccio.addOptionMenu("Aturar.");
		menu_reproduccio.addOptionMenu("Veure estat reproducció");
		menu_reproduccio.addOptionMenu("Tornar al menú de vídeos");
	}
	
	private Usuari AfegirUsuari() {
		Usuari usuari = null;
		try {
			// Demanem les dades de l'periodista
			String nom = demanaDada("Alta usuari", "Introdueixi el nom del usuari");
			if (nom==null) return null;
			String cognoms = demanaDada("Alta usuari", "Introdueixi els cognoms del usuari");
			if (cognoms==null) return null;
			String password = demanaDada("Alta usuari", "Introdueixi el password del usuari");
			if (password==null) return null;

			usuari = videos_controlador.addUsuari(nom,cognoms,password,LocalDate.now());
			System.out.println("L'usuari "+nom+" "+cognoms+" ha estat donat d'alta.");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return usuari;
	}
	
	private void LlistarUsuaris() {
		String resposta;
		resposta=videos_controlador.getUsuarisListStr();
		if (resposta.isEmpty()) {
			resposta= "No hi ha usuaris registrats.\n";
		} else {
			resposta="Llista d'usuaris registrats:\n"+resposta+"\n";
		}
		System.out.println(resposta);
	}
	
	private void GestionarVideos(Usuari usuari) {
		int menu_videos_opt;
		do {
			menu_videos_opt=menu_videos.showMenu();
			switch (menu_videos_opt) {
			case 0:
				PujarVideos(usuari);
				break;
			case 1:
				LlistarVideos(usuari);
				break;
			case 2:
				ReproduccioVideos(usuari);
				break;
			}
		} while (menu_videos_opt!=3);
	}
	
	private void PujarVideos(Usuari usuari) {
		try {
			// Demanem les dades del podcast
			String titol = demanaDada("Pujada vídeo", "Introdueixi el títol del vídeo");
			if (titol==null) return;
			String url = demanaDada("Pujada vídeo", "Introdueixi la url del vídeo");
			if (url==null) return;
			String tags = demanaDada("Pujada vídeo", "Tags del video (separats per comes):");
			if (tags==null) return;
			int durada_segons=demanaInt("Pujada vídeo", "Durada (segons)", -1000);
			if (durada_segons==-1000) return;
			videos_controlador.addVideo(usuari, url, titol, tags, LocalDateTime.now(), durada_segons);
			System.out.println("El vídeo "+ titol + " està pujant.");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	private void LlistarVideos(Usuari usuari) {
		String resposta;
		resposta=videos_controlador.getVideosListStr(usuari, LocalDateTime.now());
		if (resposta.isEmpty()) {
			resposta="L'usuari " + usuari.getNom()+" "+usuari.getCognom()+ " no te cap vídeo pujat.\n";
		} else {
			resposta ="Llista dels vídeos de l'usuari: "+usuari.getNom()+" "+usuari.getCognom()+"\n"
					+resposta+"\n";
		}
		System.out.println(resposta);
	}
	
	private void ReproduccioVideos(Usuari usuari) {
		Video video;
		LlistarVideos(usuari);
		String titol=demanaDada("Reproducció", 
				"Introdueixi el títol del vídeo a reproduir");
		if (titol==null) return;
		try {
			video=videos_controlador.getVideoPerTitol(usuari, titol);
			ManageReproduccio(video);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	private void ManageReproduccio(Video video) {
		int menu_reproduccio_opt;
		String resposta="";
		do {
			menu_reproduccio_opt = menu_reproduccio.showMenu();
			try {
				switch (menu_reproduccio_opt) {
				case 0:
					videos_controlador.ReproduirVideo(video, LocalDateTime.now());
					resposta="El vídeo " + video.getTitol() + " s'està REPRODUINT";
					break;
				case 1:
					videos_controlador.PausarVideo(video, LocalDateTime.now());
					resposta="La reproducció de " + video.getTitol() + " està en PAUSA.";
					break;
				case 2:
					videos_controlador.AturarVideo(video, LocalDateTime.now());
					resposta="La reproducció de " + video.getTitol() + " s'ha ATURAT.";
					break;
				case 3:
					resposta=videos_controlador.getEstatVideo_str(video, LocalDateTime.now());
					break;
				case 4:
					resposta="Has sortit del menú de reproducció";
					break;
				}
				System.out.println(resposta);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		} while (menu_reproduccio_opt != 4);
	}
	
	private String demanaDada(String titol, String textSobreLaDadaAdemanar) {
		String dada = JOptionPane.showInputDialog(null, textSobreLaDadaAdemanar, titol, JOptionPane.QUESTION_MESSAGE);
		return dada;
	}
	
	public int demanaInt(String titol, String textSobreLaDadaAdemanar, int nullnumber) throws Exception {
		String answer_str;
		int answer;
		answer_str=JOptionPane.showInputDialog(null, textSobreLaDadaAdemanar, titol, JOptionPane.QUESTION_MESSAGE);
		if (answer_str==null) {
			answer=nullnumber;
		} else {
			answer=Integer.parseInt(answer_str);
		}
		return answer;
	}
}
