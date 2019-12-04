package com.proyecto.personal.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.personal.entidades.Paciente;

@Repository
public interface IPacienteRepository extends CrudRepository<Paciente, Integer> {

}
