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

import com.example.demo.dao.CategoriaDAO;
import com.example.demo.dominio.Categoria;

@RestController
@RequestMapping("categorias")
public class CategoriaRest {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Categoria categoria) {
		categoriaDAO.save(categoria);
	}
	
	@GetMapping("/listar")
	public List<Categoria> listar(){
		return categoriaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		categoriaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Categoria categoria) {
		categoriaDAO.save(categoria);
	}

}
