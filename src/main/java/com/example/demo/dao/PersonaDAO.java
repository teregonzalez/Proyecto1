package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dominio.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer>{
	Persona findByUsername(String username);

}
