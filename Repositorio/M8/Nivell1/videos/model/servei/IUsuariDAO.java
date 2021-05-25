package videos.model.servei;

import java.time.LocalDate;
import java.util.ArrayList;

import videos.model.domini.*;

public interface IUsuariDAO {
	Usuari addUsuari(String nom, String cognom, String password, LocalDate data_registre) throws Exception;
	void addVideo(Usuari usuari, String url, String titol, String tags_list) throws Exception;
	ArrayList<Video> getAllVideos(Usuari usuari);
	ArrayList<Usuari> getAllUsuaris();
}
