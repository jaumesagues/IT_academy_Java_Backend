package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Libro;

@Service
public class BaseDatos3Service implements IBaseDatos3 {

	@Autowired
	BaseDatos3 bd;
	
	@Override
	public void inserta(Libro libro) {
		bd.save(libro);
	}

	@Override
	public void borrar(int id) {
		bd.deleteById(id);
	}

	@Override
	public void modifica(Libro libro) {
		bd.save(libro);
	}

	@Override
	public Libro getLibro(int id) {
		Optional<Libro> l=bd.findById(id);
		return l.get();
	}

	@Override
	public ArrayList<Libro> getLibros() {
		ArrayList<Libro> libros=null;
		try {
			libros=(ArrayList<Libro>)bd.findAll();
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return libros;
	}

	@Override
	public boolean compruebaUsuario(String usuario, String password) {
		boolean check=false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conex="jdbc:mysql://localhost:3306/biblioteca";
			Connection conexion=DriverManager.getConnection(conex,"root","abc123");
			Statement s=conexion.createStatement();
			String sql="SELECT count(*) FROM USUARIO WHERE nombre='"+usuario+"' "
					+"and password='"+password+"'";
			s.execute(sql);
			ResultSet rs=s.getResultSet();
			rs.next();
			if (rs.getInt(1)>0) check=true;
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		
		return check;
	}

}
