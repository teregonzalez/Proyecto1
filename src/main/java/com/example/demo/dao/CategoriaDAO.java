package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dominio.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

}
