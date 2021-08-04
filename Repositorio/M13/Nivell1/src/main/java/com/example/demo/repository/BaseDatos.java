package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.demo.bean.TipusTreball.TipusTreballEnum;
import com.example.demo.bean.Treballador;

public class BaseDatos {
	ArrayList<Treballador> treballadors=new ArrayList<Treballador>();
	public BaseDatos(){

				treballadors.add(new Treballador(1, "Miguel", "Aprenent"));
				treballadors.add(new Treballador(2, "Jaume Sagués", "Operari"));
				treballadors.add(new Treballador(3, "Ovidi", "Directiu"));	
			
				
	}
	public ArrayList<Treballador> getTreballadors() {
		return treballadors;
	}
	public void setTreballadors(ArrayList<Treballador> treballadors) {
		this.treballadors=treballadors;
	}
	public void inserta(Treballador treballador) {
		treballadors.add(treballador);
	}
	public void borrar(int id) {
		Iterator<Treballador> it=treballadors.iterator();
		while(it.hasNext()) {
			Treballador li=it.next();
			if (li.getId()==id) {
				it.remove();
				break;
			}
		}
	}
	public Treballador getTreballador(int id) {
		Treballador libro=null;
		Iterator<Treballador> it=treballadors.iterator();
		while(it.hasNext()) {
			Treballador li=it.next();
			if (li.getId()==id) {
				libro=li;
				break;
			}
		}
		return libro;
	}
	
	public void modifica(Treballador treballador) {
		Iterator<Treballador> it=treballadors.iterator();
		while(it.hasNext()) {
			Treballador li=it.next();
			if (li.getId()==treballador.getId()) {
				li.setNom(treballador.getNom());
				li.setTreball(treballador.getTreball());
				break;
			}
		}
	}
	
}
