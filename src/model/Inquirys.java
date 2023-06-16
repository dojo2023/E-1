package model;

import java.io.Serializable;

public class Inquirys implements Serializable{

	private String id;
	private String genre;
	private String text;

	public Inquirys(String id, String genre, String text) {
		super();
		this.id = id;
		this.genre = genre;
		this.text = text;
	}

	public Inquirys() {
		super();
		this.id = "";
		this.genre = "";
		this.text = "";
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



}