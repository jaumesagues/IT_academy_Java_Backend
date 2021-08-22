package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.*;

@Repository
public interface QuadresDAO extends JpaRepository<Quadre,Long>{
	
	List<Quadre> findByBotiga(long Botigues_id);
	long deleteByBotiga(long Botigues_id);
}
