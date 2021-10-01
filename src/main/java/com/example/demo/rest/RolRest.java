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

import com.example.demo.dao.RolDAO;
import com.example.demo.dominio.Rol;

@RestController
@RequestMapping("roles")
public class RolRest {
	
	@Autowired
	private RolDAO rolDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Rol rol) {
		rolDAO.save(rol);
	}
	
	@GetMapping("/listar")
	public List<Rol> listar(){
		return rolDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		rolDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Rol rol) {
		rolDAO.save(rol);
	}

}
