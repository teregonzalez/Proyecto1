package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductoDAO;
import com.example.demo.dominio.Producto;

@RestController
@RequestMapping("productos")
public class ProductoRest {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Producto producto) {
		productoDAO.save(producto);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(Producto producto) {
		productoDAO.delete(producto);
	}
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoDAO.findAll();
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Producto producto) {
		productoDAO.save(producto);
	}
	
	//ServiceImplementation
	public Producto buscar(Producto producto) {
		listar();
		return productoDAO.findById(producto.getId()).orElse(null);
	}

}
