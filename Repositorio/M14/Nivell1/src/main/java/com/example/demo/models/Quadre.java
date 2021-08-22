package com.example.demo.models;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quadres")
public class Quadre {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom",nullable=false,length=45)
	private String nom;
	
	@Column(name="autor",length=45)
	private String autor;
	
	@Column(name="preu",nullable=false)
	private float preu;
	
	@Column(name="data_entrada",nullable=false)
	private LocalDate data_entrada;
	
	@Column(name="Botigues_id",nullable=false)
	private long botiga;
	
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public float getPreu() {
		return preu;
	}
	public void setPreu(float preu) {
		this.preu = preu;
	}
	public LocalDate getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(LocalDate data_entrada) {
		this.data_entrada = data_entrada;
	}
	public long getBotigues_id() {
		return botiga;
	}
	public void setBotigues_id(long Botigues_id) {
		this.botiga = Botigues_id;
	}
}
