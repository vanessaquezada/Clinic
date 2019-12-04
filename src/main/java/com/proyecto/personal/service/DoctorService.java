package com.proyecto.personal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.personal.entidades.Doctor;
import com.proyecto.personal.entidades.Especialidad;
import com.proyecto.personal.repositorios.IDoctorRepository;
import com.proyecto.personal.repositorios.IEspecialidadRepository;


@Service
public class DoctorService {

	@Autowired
	IDoctorRepository rDoctor;
	
	@Autowired
	IEspecialidadRepository rEspecialiad;
	
	public List<Doctor> Lista(){
		return (List<Doctor>)rDoctor.findAll();
	}
	
	public List<Especialidad> ListEspecialidad() {
		return (List<Especialidad>)rEspecialiad.findAll();
	}
	
	public Boolean saveOrUpdate(Doctor doctor) {
		try {
			rDoctor.save(doctor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean Eliminar(Doctor doctor) {
		try {
			rDoctor.delete(doctor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Especialidad especialidad(Integer id_especialidad) {
		return rEspecialiad.findById(id_especialidad).get();
	}
	
	public Doctor doctor(Integer id_doctor) {
		return rDoctor.findById(id_doctor).get();
	}
}

