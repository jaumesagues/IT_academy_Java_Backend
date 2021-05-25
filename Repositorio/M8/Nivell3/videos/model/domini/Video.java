package videos.model.domini;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;

import videos.model.domini.EstatPujada.TipusEstatPujada;
import videos.model.domini.EstatReproduccio.TipusEstatReproduccio;

public class Video {
	private String url;
	private String titol;
	private ArrayList<String> tags_list;
	private LocalDateTime data_pujada;
	private LocalDateTime data_reproduccio;
	private TipusEstatReproduccio estat_reproduccio;
	private int segons_durada;
	private long segons_reproduits_fins_pausa;
	private static int limit_pujada=1;
	private static int limit_verificacio=1;
	
	public Video(String url, String titol, LocalDateTime data_pujada, int segons_durada) {
		this.url=url;
		this.titol=titol;
		this.tags_list=new ArrayList<String>();
		this.data_pujada=data_pujada;
		this.segons_durada=segons_durada;
		this.data_reproduccio=null;
		this.estat_reproduccio=TipusEstatReproduccio.STOP;
		this.segons_reproduits_fins_pausa=0; // Segons reproduïts fins estar en PAUSA
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
		if (minutes<=limit_pujada) estat_pujada=TipusEstatPujada.UPLOADING;
		else if (minutes<=limit_verificacio) estat_pujada=TipusEstatPujada.VERIFYING;
		else estat_pujada=TipusEstatPujada.PUBLIC;
		return estat_pujada;
	}
	
	public TipusEstatReproduccio getEstatReproduccio(LocalDateTime datatime) {
		long segons_reproduits;
		if (this.estat_reproduccio==TipusEstatReproduccio.PLAY) {
			segons_reproduits=getSegonsReproduits(datatime);
			if (segons_reproduits>=this.segons_durada) {
				doAtura();
			}
		}
		
		return this.estat_reproduccio;
	}
	
	public long getSegonsReproduits(LocalDateTime datatime) {
		long segons_reproduits=0;
		if (this.estat_reproduccio==TipusEstatReproduccio.PLAY) {
			segons_reproduits=this.data_reproduccio.until(datatime,ChronoUnit.SECONDS)+this.segons_reproduits_fins_pausa;
		} else {
			segons_reproduits+=this.segons_reproduits_fins_pausa;
		}
		return segons_reproduits;
	}
	
	public void Reprodueix(LocalDateTime datatime) throws Exception {
		TipusEstatReproduccio estat_reproduccio;
		if (getEstatPujada(datatime)!=TipusEstatPujada.PUBLIC)
			throw new Exception("No es pot reproduir el vídeo perquè encara no és public.");
		
		estat_reproduccio=getEstatReproduccio(datatime);
		
		if (estat_reproduccio==TipusEstatReproduccio.PLAY)
			throw new Exception("El vídeo ja està en reproducció.");
		
		doReprodueix(datatime);
	}
	
	private void doReprodueix(LocalDateTime datatime) {
		this.data_reproduccio=datatime;
		this.estat_reproduccio=TipusEstatReproduccio.PLAY;
	}
	
	public void Pausa(LocalDateTime datatime) throws Exception {
		TipusEstatReproduccio estat_reproduccio;
		
		if (getEstatPujada(datatime)!=TipusEstatPujada.PUBLIC)
			throw new Exception("No es pot pausar el vídeo perquè encara no és public.");
		
		estat_reproduccio=getEstatReproduccio(datatime);
		
		if (estat_reproduccio!=TipusEstatReproduccio.PLAY)
			throw new Exception("El vídeo no es pot pausar perquè NO està en reproducció.");
		
		doPausa(datatime);
	}
	
	private void doPausa(LocalDateTime datatime) {
		this.segons_reproduits_fins_pausa+=getSegonsReproduits(datatime);
		this.data_reproduccio=null;
		this.estat_reproduccio=TipusEstatReproduccio.PAUSE;	
	}
	
	public void Atura(LocalDateTime datatime) throws Exception {
		TipusEstatReproduccio estat_reproduccio;
		
		if (getEstatPujada(datatime)!=TipusEstatPujada.PUBLIC)
			throw new Exception("No es pot aturar el vídeo perquè encara no és public.");
		
		estat_reproduccio=getEstatReproduccio(datatime);
		
		if (estat_reproduccio==TipusEstatReproduccio.STOP)
			throw new Exception("El vído no es pot aturar perquè ja ho està.");
		
		doAtura();
	}
	
	private void doAtura() {
		this.data_reproduccio=null;
		this.estat_reproduccio=TipusEstatReproduccio.STOP;
		this.segons_reproduits_fins_pausa=0;
	}
	
	public String getEstatReproduccio_str(LocalDateTime datatime) {
		TipusEstatReproduccio estat_reproduccio;
		double percent_reproduit;
		String estat_str="";
		TipusEstatPujada estat_pujada;
		
		estat_pujada=this.getEstatPujada(datatime);
		if (estat_pujada == TipusEstatPujada.PUBLIC) {
			estat_reproduccio = getEstatReproduccio(datatime);
			if (estat_reproduccio == TipusEstatReproduccio.STOP) {
				estat_str = estat_reproduccio.toString();
			} else {
				percent_reproduit = (double) (this.getSegonsReproduits(datatime)) / (double) (this.segons_durada)
						* 100.0;
				estat_str = estat_reproduccio.toString() + " % reproduit: " + percent_reproduit;
			}
		} else {
			estat_str=estat_pujada.toString();
		}
		
		return estat_str;
	}
	
	@Override
	public String toString() {
		return titol + " url: " + url + " durada: " + this.segons_durada + " s";
	}
}
