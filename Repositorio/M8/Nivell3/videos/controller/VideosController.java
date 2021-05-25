package videos.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import videos.model.domini.*;
import videos.model.servei.*;

public class VideosController {
	
	public IUsuariDAO getDAO() {
		IUsuariDAO dao=UsuariMemoriaDAO.getUsuariMemoriaDAO();
		return dao;
	}
	
	public Usuari addUsuari(String nom,String cognom,String password, LocalDate data_registre) throws Exception {
		return getDAO().addUsuari(nom, cognom, password, data_registre);
	}
	
	public String getUsuarisListStr() {
		String list_usuaris_str;
		ArrayList<Usuari> usuaris_list=getDAO().getAllUsuaris();
		
		list_usuaris_str="";
		for (Usuari usuari:usuaris_list) {
			list_usuaris_str+=usuari.toString()+ "\n";
		}
		
		return list_usuaris_str;
	}
	
	public void addVideo(Usuari usuari, String url, String titol, String tags_list, 
			LocalDateTime data_pujada, int segons_durada) throws Exception {
		getDAO().addVideo(usuari, url, titol, tags_list, data_pujada, segons_durada);
	}
	
	public String getVideosListStr(Usuari usuari, LocalDateTime time) {
		String list_videos_str;
		ArrayList<Video> videos_list=getDAO().getAllVideos(usuari);
		
		list_videos_str="";
		for (Video video:videos_list) {
			list_videos_str+=video.toString() + " estat: " + video.getEstatPujada(time).toString() + "\n";
		}
		
		return list_videos_str;
	}
	
	public Video getVideoPerTitol(Usuari usuari, String titol) throws Exception {
		Video video=getDAO().getVideoPerTitol(usuari, titol);
		return video;
	}
	
	public void ReproduirVideo(Video video, LocalDateTime time) throws Exception {
		video.Reprodueix(time);
	}
	
	public void PausarVideo(Video video, LocalDateTime time) throws Exception {
		video.Pausa(time);
	}
	
	public void AturarVideo(Video video, LocalDateTime time) throws Exception {
		video.Atura(time);
	}
	
	public String getEstatVideo_str(Video video, LocalDateTime time) {
		return video.getEstatReproduccio_str(time);
	}
	
}
