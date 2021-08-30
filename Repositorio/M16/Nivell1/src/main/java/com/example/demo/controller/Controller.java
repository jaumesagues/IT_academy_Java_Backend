package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.*;
import com.example.demo.model.*;

@RestController
@RequestMapping("/players")
public class Controller {
	
	@Autowired
	private UsuarisDAO usuarisDAO;
	
	@PostMapping // Crear jugador
	public ResponseEntity<Usuari> crearUsuari(@RequestBody Usuari usuari) {
		Usuari nouUsuari=usuarisDAO.save(usuari);
		return ResponseEntity.ok(nouUsuari);
	}

}
