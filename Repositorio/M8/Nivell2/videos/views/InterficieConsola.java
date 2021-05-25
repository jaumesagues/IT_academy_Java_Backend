package videos.views;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import videos.controller.VideosController;
import videos.model.domini.Usuari;

public class InterficieConsola {

	private static VideosController videos_controlador;
	private static Menu menu_principal;
	private static Menu menu_videos;
	
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
		
		menu_videos=new Menu("Trii una de les següents opcions:", 3);
		menu_videos.addOptionMenu("Pujar vídeo.");
		menu_videos.addOptionMenu("Llistar vídeos.");
		menu_videos.addOptionMenu("Tornar al menú principal.");
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
			}
		} while (menu_videos_opt!=2);
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
			videos_controlador.addVideo(usuari, url, titol, tags, LocalDateTime.now());
			System.out.println("El vídeo "+ titol + " ha estat pujat.");
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
	
	private String demanaDada(String titol, String textSobreLaDadaAdemanar) {
		String dada = JOptionPane.showInputDialog(null, textSobreLaDadaAdemanar, titol, JOptionPane.QUESTION_MESSAGE);
		return dada;
	}
}
