package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Jugades")
public class Jugada {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="tirada", nullable=false)
	private int tirada;
	
	@Column(name="UsuariId", nullable=false)
	private int UsuariId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTirada() {
		return tirada;
	}
	public void setTirada(int tirada) {
		this.tirada = tirada;
	}
	public int getUsuariId() {
		return UsuariId;
	}
	public void setUsuariId(int usuariId) {
		UsuariId = usuariId;
	}
	
	public int Jugar() {
		int valor_jugada=0;
		int dau1, dau2;
		
		dau1 = 1 + (int)(Math.random() * 6);
		dau2 = 1 + (int)(Math.random() * 6);
		valor_jugada=dau1+dau2;
		
		return valor_jugada;
	}
	
	public static boolean JugadaGuanyadora(int valor_jugada) {
		return (valor_jugada==7);
	}

}
