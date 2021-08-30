package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuaris")
public class Usuari {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="usuari",nullable=false,length=45)
	private String usuari;
	
	@Column(name="password",nullable=false,length=16)
	private String pwd;
	
	@Column(name="token",length=45)
	private String token;
	
	public String getUsuari() {
		return usuari;
	}
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
