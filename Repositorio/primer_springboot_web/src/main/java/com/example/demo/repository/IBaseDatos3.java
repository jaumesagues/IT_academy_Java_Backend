package com.example.demo.repository;

import java.util.ArrayList;

import com.example.demo.bean.Libro;

public interface IBaseDatos3 {
	public void inserta(Libro libro);
	public void borrar(int id);
	public void modifica(Libro libro);
	public Libro getLibro(int id);
	public ArrayList<Libro> getLibros();
	public boolean compruebaUsuario(String usuario, String password);
}
