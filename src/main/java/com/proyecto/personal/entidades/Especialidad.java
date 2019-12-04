package com.proyecto.personal.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String especialidad;
	
	//Constructores
	public Especialidad() {
		
	}

	public Especialidad(Integer id, String especialidad) {
		super();
		this.id = id;
		this.especialidad = especialidad;
	}

	//Metodos get and set
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}
