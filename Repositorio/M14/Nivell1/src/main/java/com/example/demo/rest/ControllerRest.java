package com.example.demo.rest;

import com.example.demo.dao.BotiguesDAO;
import com.example.demo.dao.QuadresDAO;
import com.example.demo.models.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ControllerRest {
	
	@Autowired
	private BotiguesDAO botiguesDAO;
	
	@Autowired
	private QuadresDAO quadresDAO;
	
	@PostMapping // Crear botiga
	public ResponseEntity<Botiga> crearBotiga(@RequestBody Botiga botiga) {
		Botiga novaBotiga=botiguesDAO.save(botiga);
		return ResponseEntity.ok(novaBotiga);
	}
	
	@GetMapping //Llista botigues
	public ResponseEntity<List<Botiga>> getBotigues() {
		List<Botiga> botigues=botiguesDAO.findAll();
		return ResponseEntity.ok(botigues);
	}
	
	@PostMapping(value = "/picture") // Afegir quadre
	public ResponseEntity<Quadre> afegirQuadre(@RequestBody Quadre quadre){
		long Botiga_id=quadre.getBotigues_id();
		quadre.setData_entrada(LocalDate.now());
		if (botiguesDAO.existsById(Botiga_id)) {
			Quadre nouQuadre=quadresDAO.save(quadre);
			return ResponseEntity.ok(nouQuadre);
		}
		return ResponseEntity.ok(null);
	}
	
	@GetMapping(value = "/{botigaId}/pictures") //Llista quadres d'una botiga
	public ResponseEntity<List<Quadre>> getQuadresBotiga(@PathVariable("botigaId") Long botigaId) {
		List<Quadre> quadres=quadresDAO.findByBotiga(botigaId);
		return ResponseEntity.ok(quadres);
	}
	
	@Transactional
	@DeleteMapping(value = "/{botigaId}/pictures") //Esborrar quadres d'una botiga
	public ResponseEntity<List<Quadre>> deleteQuadresBotiga(@PathVariable("botigaId") Long botigaId) {
		long resp=quadresDAO.deleteByBotiga(botigaId);
		return ResponseEntity.ok(null);
	}
}
