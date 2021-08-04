package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.*;
import com.example.demo.repository.*;

@Controller
@RequestMapping("")
public class Controlador {
	
	BaseDatos bd=new BaseDatos();
	//BaseDatos2 bd =new BaseDatos2();
	//@Autowired
	//Treballador usuario;

	@GetMapping("/")
	public String iniciar(Model model) {
		ArrayList<Treballador> treballadors=bd.getTreballadors();
		model.addAttribute("treballadors",treballadors);
		model.addAttribute("treballador", null);
		model.addAttribute("boton","Afegir treballador");
		model.addAttribute("action","/insertar");
		return "consulta";
	}
	
	@PostMapping("/insertar")
	public String insertar(Treballador treballador, Model model) {
		bd.inserta(treballador);
		ArrayList<Treballador> treballadors =bd.getTreballadors();
		model.addAttribute("treballadors", treballadors);
		model.addAttribute("treballador", null);
		model.addAttribute("boton","Inserta Libro");
		model.addAttribute("action","/insertar");
		return "consulta";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Treballador> treballadors =bd.getTreballadors();
		model.addAttribute("treballadors", treballadors);
		model.addAttribute("treballador", null);
		model.addAttribute("boton","Inserta Libro");
		model.addAttribute("action","/insertar");
		return "consulta";
	}
	
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Treballador treballador=bd.getTreballador(id);
		ArrayList<Treballador> treballadors=bd.getTreballadors();
		model.addAttribute("treballadors", treballadors);
		model.addAttribute("treballador", treballador);
		model.addAttribute("boton","Actualiza libro");
		model.addAttribute("action","/modificar");
		return "consulta";
	}
	
	@PostMapping("/modificar")
	public String modificar2(Treballador treballador, Model model) {
		bd.modifica(treballador);
		
		ArrayList<Treballador> treballadors=bd.getTreballadors();
		model.addAttribute("treballadors", treballadors);
		model.addAttribute("treballador", null);
		model.addAttribute("boton","Inserta Libro");
		model.addAttribute("action","/insertar");
		return "consulta";
	}
}
