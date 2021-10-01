package com.example.demo.dominio;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
	public Rol() {
		
	}
	
	public Rol(int id) {
		this.id = id;
	}
	
	public Rol(String nombre) {
		this.nombre = nombre;
	}
}
