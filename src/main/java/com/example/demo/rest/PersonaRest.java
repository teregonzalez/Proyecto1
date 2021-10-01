package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonaDAO;
import com.example.demo.dominio.Persona;
import com.example.demo.dominio.Rol;

@RestController
@RequestMapping("personas")
@Service("UserDetailsService")
public class PersonaRest implements UserDetailsService{

	@Autowired
	private PersonaDAO personaDAO;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@PostMapping("/guardar")
	public void guardar(Persona persona) {
		String pwd = persona.getPassword();
		String encriptar = encoder.encode(pwd);
		
		Persona p = new Persona(persona.getNombre(), 
				persona.getApepat(), persona.getApemat(),
				persona.getUsername(), encriptar,
				persona.getRut(), persona.getCargo(), 
				persona.getRoles());
				
		personaDAO.save(p);
	}
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Persona user = personaDAO.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		var roles = new ArrayList<GrantedAuthority>();
		for(Rol rol: user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		return new User(user.getUsername(),user.getPassword(), roles);
		
	}
}
