package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.demo.bean.Libro;

public class BaseDatos {
	ArrayList<Libro> libros=new ArrayList<Libro>();
	public BaseDatos() {
		libros.add(new Libro(1,"HARRY POTTER", "JK ROWLING", "SALAMANDRA","26/9/2006","INFANTIL"));
		libros.add(new Libro(2,"EL GRAN LABERINTO", "FERNANDO SABATER", "ARIEL", "26/9/2006", "FICCION"));
		
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(ArrayList<Libro> libros) {
		this.libros=libros;
	}
	public void inserta(Libro libro) {
		libros.add(libro);
	}
	public void borrar(int id) {
		Iterator<Libro> it=libros.iterator();
		while(it.hasNext()) {
			Libro li=it.next();
			if (li.getId()==id) {
				it.remove();
				break;
			}
		}
	}
	public Libro getLibro(int id) {
		Libro libro=null;
		Iterator<Libro> it=libros.iterator();
		while(it.hasNext()) {
			Libro li=it.next();
			if (li.getId()==id) {
				libro=li;
				break;
			}
		}
		return libro;
	}
	
	public void modifica(Libro libro) {
		Iterator<Libro> it=libros.iterator();
		while(it.hasNext()) {
			Libro li=it.next();
			if (li.getId()==libro.getId()) {
				li.setAutor(libro.getAutor());
				li.setEditorial(libro.getEditorial());
				li.setFecha(libro.getFecha());
				li.setTematica(libro.getTematica());
				li.setTitulo(libro.getTitulo());
				break;
			}
		}
	}
}
