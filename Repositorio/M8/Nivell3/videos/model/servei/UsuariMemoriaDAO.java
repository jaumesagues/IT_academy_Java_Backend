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
	public ArrayList<Usuari> getAllUsuaris() {
		return this.list_usuaris;
	}

	@Override
	public void addVideo(Usuari usuari, String url, String titol, String tags_list,
			LocalDateTime data_pujada, int segons_durada) throws Exception {
		
		if (esBuit(url)) throw new Exception("La url del video no pot estar buida.");
		if (esBuit(titol)) throw new Exception("El titol del video no pot estar buida.");
		if (data_pujada==null) throw new Exception("La data de pujada no pot estar buida");
		if (segons_durada<=0) throw new Exception("La durada (en segons) ha de ser un número superior a 0.");
		
		Video video =new Video(url, titol, data_pujada, segons_durada);
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
	
	@Override
	public Video getVideoPerTitol(Usuari usuari, String titol) throws Exception {
		ArrayList<Video> list_videos;
		Video video_trobat=null;
		
		if (esBuit(titol)) throw new Exception("El títol no pot estar buit.");
		if (usuari==null) throw new Exception("Usuari és null");
		
		list_videos=usuari.getAllVideos();
		
		for (Video video:list_videos) {
			if (titol.equalsIgnoreCase(video.getTitol())) {
				video_trobat=video;
				break;
			}
		}
		
		if (video_trobat==null) throw new Exception("No s´ha trobat cap vídeo amb aquest títol.");
		
		return video_trobat;
	}
	
	private boolean esBuit(String valor) {
		boolean resultat = false;
		if (valor == null || valor.isBlank() || valor.isEmpty()) {
			resultat = true;
		}
		return resultat;
	}

}
