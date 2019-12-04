package com.proyecto.personal.entidades;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fecha;
	private String sintomas;
	private String diagnostico;

	@ManyToOne(fetch = FetchType.EAGER)
	private Doctor doctor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Paciente paciente;

	//Constructores
	public Consulta() {
		
	}

	public Consulta(Integer id, Date fecha, String sintomas, String diagnostico, Doctor doctor, Paciente paciente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.doctor = doctor;
		this.paciente = paciente;
	}
	//Get and Set

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
