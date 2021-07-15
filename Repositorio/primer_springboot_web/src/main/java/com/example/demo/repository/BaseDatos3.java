package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Libro;

public interface BaseDatos3 extends JpaRepository<Libro, Integer> {
	

}
