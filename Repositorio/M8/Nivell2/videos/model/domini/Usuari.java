package videos.model.domini;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuari {
	private String nom;
	private String cognom;
	private String password;
	private LocalDate data_registre;
	private ArrayList<Video> list_videos;
	
	public Usuari(String nom, String cognom, String password, LocalDate data_registre) {
		this.nom=nom;
		this.cognom=cognom;
		this.password=password;
		this.data_registre=data_registre;
		list_videos=new ArrayList<Video>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public LocalDate getData_registre() {
		return data_registre;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public void addVideo(Video video) {
		this.list_videos.add(video);
	}
	
	public ArrayList<Video> getAllVideos() {
		return this.list_videos;
	}
	
	@Override
	public String toString() {
		return nom + " " + cognom + " alta: " + data_registre;
	}
}
