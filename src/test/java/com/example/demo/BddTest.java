package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.example.demo.dao.PersonaDAO;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BddTest {

	@Autowired
	private PersonaDAO perso;

	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void test() {
		
	}
	
	/*
	@Test
	public void testCrearRoles(){
		Rol admin = new Rol("ROLE_ADMIN");
		Rol user = new Rol("ROLE_USER");
		Rol guess = new Rol("ROLE_GUESS");
		
		entityManager.persist(admin);
		entityManager.persist(user);
		entityManager.persist(guess);
	}*/
	
	public String encriptarClave(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	/*
	@Test
	public void testCrearUsuarioConRol() {
		Rol admin = entityManager.find(Rol.class, 1);
		String pwd = "123456";
		Persona p = new Persona("Administrador", "", "", "admin", encriptarClave(pwd),
				"11111111-1", "Administrador");
		p.agregarRol(admin);
		perso.save(p);
	}
	*/
	/*
	@Test
	public void testCrearUsuarioConDosRoles() {
		Rol admin = entityManager.find(Rol.class, 1);
		Rol user = entityManager.find(Rol.class, 2);
		String pwd = "123456";
		Persona p = new Persona("Juanito", "Perez", "Lopez", "jperez", encriptarClave(pwd),
				"11145896-1", "Administrador de Servicios");
		p.agregarRol(admin);
		p.agregarRol(user);
		perso.save(p);
	}
	*/
	/*
	@Test
	public void asignarRolAUsuarioExistente() {
		Persona p = perso.findById(1).get();
		Rol user = entityManager.find(Rol.class, 2);
		p.agregarRol(user);
	}
	*/

}
