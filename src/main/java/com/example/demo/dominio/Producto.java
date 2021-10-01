package com.example.demo.dominio;

import javax.persistence.*;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private double precio;
	
	@Column
	private String codigoProducto;
	
	//Se declara la relación de muchos productos a una categoria
	@ManyToOne
	@JoinColumn(name= "id_categorias")
	private Categoria categoria;
	

}
