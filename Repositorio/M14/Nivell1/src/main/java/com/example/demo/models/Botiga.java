package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="botigues")
public class Botiga {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom",nullable=false,length=45)
	private String nom;
	
	@Column(name="capacitat", nullable=false)
	private int capacitat;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCapacitat() {
		return capacitat;
	}
	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}
	
	
}
