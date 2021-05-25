package videos.model.domini;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;

import videos.model.domini.EstatPujada.TipusEstatPujada;

public class Video {
	private String url;
	private String titol;
	private ArrayList<String> tags_list;
	private LocalDateTime data_pujada;
	
	public Video(String url, String titol, LocalDateTime data_pujada) {
		this.url=url;
		this.titol=titol;
		this.tags_list=new ArrayList<String>();
		this.data_pujada=data_pujada;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public ArrayList<String> getTags_list() {
		return tags_list;
	}
	
	public void addTag(String tag) {
		tags_list.add(tag);
	}
	
	public TipusEstatPujada getEstatPujada(LocalDateTime datatime) {
		TipusEstatPujada estat_pujada;
		long minutes=this.data_pujada.until(datatime, ChronoUnit.MINUTES);
		if (minutes<=1) estat_pujada=TipusEstatPujada.UPLOADING;
		else if (minutes<=3) estat_pujada=TipusEstatPujada.VERIFYING;
		else estat_pujada=TipusEstatPujada.PUBLIC;
		return estat_pujada;
	}
	
	@Override
	public String toString() {
		return titol + " url: " + url;
	}
}
