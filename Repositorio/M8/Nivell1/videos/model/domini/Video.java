package videos.model.domini;

import java.util.ArrayList;

public class Video {
	private String url;
	private String titol;
	private ArrayList<String> tags_list;
	
	public Video(String url, String titol) {
		this.url=url;
		this.titol=titol;
		tags_list=new ArrayList<String>();
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

	@Override
	public String toString() {
		return titol + " url: " + url;
	}
}
