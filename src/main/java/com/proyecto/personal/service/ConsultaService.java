package com.proyecto.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.personal.entidades.Consulta;
import com.proyecto.personal.entidades.Doctor;
import com.proyecto.personal.entidades.Paciente;
import com.proyecto.personal.repositorios.IConsultaRepository;
import com.proyecto.personal.repositorios.IDoctorRepository;
import com.proyecto.personal.repositorios.IPacienteRepository;

@Service
public class ConsultaService {
	@Autowired 
	IConsultaRepository rconsulta;
	@Autowired
	IDoctorRepository rdoctor;
	@Autowired
	IPacienteRepository rpaciente;
	
	
	public List<Consulta> getAll(){
		return (List<Consulta>) rconsulta.findAll();
	}
	public Boolean saveOrUpdate(Consulta entity) {
		try {
			rconsulta.save(entity);
			return true;
					
		}catch(Exception e) {
			return false;
		}
	}
	public Boolean delete(Consulta entity) {
		try {
			rconsulta.delete(entity);
			return true;
					
		}catch(Exception e) {
			return false;
		}

	}
	public Consulta getConsulta(Integer id) {
		return rconsulta.findById(id).get();
	}
	public Doctor getDoctor(Integer id) {
		return rdoctor.findById(id).get();
	}
	public Paciente getPaciente(Integer id) {
		return rpaciente.findById(id).get();
	}
	
}
