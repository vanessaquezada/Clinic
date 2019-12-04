package com.proyecto.personal.repositorios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.personal.entidades.Doctor;

@Repository
public interface IDoctorRepository extends CrudRepository<Doctor, Integer>{

}
