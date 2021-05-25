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
		menu_principal=new Menu("Trii una de les seg�ents opcions:", 3);
		menu_principal.addOptionMenu("Afegir nou usuari.");
		menu_principal.addOptionMenu("LListar usuaris.");
		menu_principal.addOptionMenu("Sortir");
		
		menu_videos=new Menu("Trii una de les seg�ents opcions:", 4);
		menu_videos.addOptionMenu("Pujar v�deo.");
		menu_videos.addOptionMenu("Llistar v�deos.");
		menu_videos.addOptionMenu("Reproducci�.");
		menu_videos.addOptionMenu("Tornar al men� principal.");
		
		menu_reproduccio=new Menu("Trii una de las seg�ents opcions: ",5);
		menu_reproduccio.addOptionMenu("Reproduir.");
		menu_reproduccio.addOptionMenu("Pausar.");
		menu_reproduccio.addOptionMenu("Aturar.");
		menu_reproduccio.addOptionMenu("Veure estat reproducci�");
		menu_reproduccio.addOptionMenu("Tornar al men� de v�deos");
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
			String titol = demanaDada("Pujada v�deo", "Introdueixi el t�tol del v�deo");
			if (titol==null) return;
			String url = demanaDada("Pujada v�deo", "Introdueixi la url del v�deo");
			if (url==null) return;
			String tags = demanaDada("Pujada v�deo", "Tags del video (separats per comes):");
			if (tags==null) return;
			int durada_segons=demanaInt("Pujada v�deo", "Durada (segons)", -1000);
			if (durada_segons==-1000) return;
			videos_controlador.addVideo(usuari, url, titol, tags, LocalDateTime.now(), durada_segons);
			System.out.println("El v�deo "+ titol + " est� pujant.");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	private void LlistarVideos(Usuari usuari) {
		String resposta;
		resposta=videos_controlador.getVideosListStr(usuari, LocalDateTime.now());
		if (resposta.isEmpty()) {
			resposta="L'usuari " + usuari.getNom()+" "+usuari.getCognom()+ " no te cap v�deo pujat.\n";
		} else {
			resposta ="Llista dels v�deos de l'usuari: "+usuari.getNom()+" "+usuari.getCognom()+"\n"
					+resposta+"\n";
		}
		System.out.println(resposta);
	}
	
	private void ReproduccioVideos(Usuari usuari) {
		Video video;
		LlistarVideos(usuari);
		String titol=demanaDada("Reproducci�", 
				"Introdueixi el t�tol del v�deo a reproduir");
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
					resposta="El v�deo " + video.getTitol() + " s'est� REPRODUINT";
					break;
				case 1:
					videos_controlador.PausarVideo(video, LocalDateTime.now());
					resposta="La reproducci� de " + video.getTitol() + " est� en PAUSA.";
					break;
				case 2:
					videos_controlador.AturarVideo(video, LocalDateTime.now());
					resposta="La reproducci� de " + video.getTitol() + " s'ha ATURAT.";
					break;
				case 3:
					resposta=videos_controlador.getEstatVideo_str(video, LocalDateTime.now());
					break;
				case 4:
					resposta="Has sortit del men� de reproducci�";
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
