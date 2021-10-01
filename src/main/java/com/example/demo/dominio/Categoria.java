package com.example.demo.dominio;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;

}
