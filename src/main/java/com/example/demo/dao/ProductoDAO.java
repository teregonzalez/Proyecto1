package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dominio.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Integer>{

}
