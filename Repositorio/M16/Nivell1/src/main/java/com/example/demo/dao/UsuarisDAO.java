package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;

public interface UsuarisDAO extends JpaRepository<Usuari,Integer>{
	
	/*
	 * public List<Producte> getProductes(); public Producte
	 * getProductePerNom(String nom); public void salvaProducte(Producte producte);
	 * public void modificaProducte(Producte producte); public void
	 * borraProductePerNom(String nom);
	 */
}
