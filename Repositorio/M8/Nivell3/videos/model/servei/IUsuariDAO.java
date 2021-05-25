package videos.model.servei;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import videos.model.domini.*;

public interface IUsuariDAO {
	Usuari addUsuari(String nom, String cognom, String password, LocalDate data_registre) throws Exception;
	ArrayList<Usuari> getAllUsuaris();
	
	void addVideo(Usuari usuari, String url, String titol, String tags_list, 
			LocalDateTime data_pujada, int segons_durada) throws Exception;
	/*
	void ReproduirVideo (Video video, LocalDateTime data_reproduccio) throws Exception;
	void PausarVideo (Video video, LocalDateTime data_reproduccio) throws Exception;
	void AturarVideo (Video video, LocalDateTime data_reproduccio) throws Exception;*/
	ArrayList<Video> getAllVideos(Usuari usuari);
	Video getVideoPerTitol(Usuari usuari, String titol) throws Exception;
}
