package com.example.demo.repository;

import java.util.ArrayList;

import com.example.demo.bean.Treballador;

public interface IBaseDatos3 {
	public void inserta(Treballador treballador);
	public void borrar(int id);
	public void modifica(Treballador treballador);
	public Treballador getTreballador(int id);
	public ArrayList<Treballador> getTreballadors();
}
