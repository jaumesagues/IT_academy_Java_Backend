package videos.model.servei;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import videos.model.domini.Usuari;
import videos.model.domini.Video;

public class UsuariMemoriaDAO implements IUsuariDAO{
	
	private ArrayList<Usuari> list_usuaris;
	
	// Singleton
	private static UsuariMemoriaDAO instancia;
	
	public static UsuariMemoriaDAO getUsuariMemoriaDAO() {
		if (instancia == null) {
			instancia = new UsuariMemoriaDAO();
		}
		return instancia;
	}
	
	public UsuariMemoriaDAO() {
		list_usuaris = new ArrayList<Usuari>();
	}
    // Fi Singleton

	@Override
	public Usuari addUsuari(String nom, String cognom, String password, LocalDate data_registre) throws Exception {
		
		if (esBuit(nom)) throw new Exception("El nom del usuari no pot estar buit.");
		if (esBuit(cognom)) throw new Exception("El cognom del usuari no pot estar buit.");
		if (esBuit(password)) throw new Exception("El password no pot estar buit.");
		if (data_registre==null) throw new Exception("La data de registre no pot estar buida.");
		
		Usuari usuari=new Usuari(nom,cognom,password,data_registre);
		list_usuaris.add(usuari);
		
		return usuari;
	}

	@Override
	public void addVideo(Usuari usuari, String url, String titol, String tags_list,
			LocalDateTime data_pujada) throws Exception {
		
		if (esBuit(url)) throw new Exception("La url del video no pot estar buida.");
		if (esBuit(titol)) throw new Exception("El titol del video no pot estar buida.");
		if (data_pujada==null) throw new Exception("La data de pujada no pot estar buida");
		
		Video video =new Video(url, titol, data_pujada);
		if (!this.esBuit(tags_list)) {
			String[] tagsArray = tags_list.split(",");
			if (tagsArray != null && tagsArray.length > 0) {
				for (String tag : tagsArray) {
					video.addTag(tag);
				}
			}
		}
		usuari.addVideo(video);
	}
	
	@Override
	public ArrayList<Video> getAllVideos(Usuari usuari) {
		return usuari.getAllVideos();
	}
	
	public ArrayList<Usuari> getAllUsuaris() {
		return this.list_usuaris;
	}
	
	private boolean esBuit(String valor) {
		boolean resultat = false;
		if (valor == null || valor.isBlank() || valor.isEmpty()) {
			resultat = true;
		}
		return resultat;
	}
	
	

}
