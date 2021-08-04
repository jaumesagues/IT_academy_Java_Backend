package com.example.demo.bean;

import com.example.demo.bean.TipusTreball.TipusTreballEnum;

public class Treballador {
	private int id;
	private String nom;
	private TipusTreballEnum treball;
	double sou;
	
	public Treballador(int id, String nom, String treball) {
		this.id=id;
		this.nom=nom;
		this.treball=TipusTreballEnum.GetTipusTreball(treball);
		this.sou=this.treball.Sou();
	}
	
	public int getId() {
		return this.id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTreball() {
		return TipusTreballEnum.GetTipusTreballNom(treball);
	}
	public void setTreball(String treball) {
		this.treball = TipusTreballEnum.GetTipusTreball(treball);;
		this.sou=this.treball.Sou();
	}
	
	public double getSou() {
		return this.sou;
	}

}
