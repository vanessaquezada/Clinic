package com.proyecto.personal.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.personal.entidades.Consulta;

@Repository
public interface IConsultaRepository extends CrudRepository<Consulta, Integer>{

}
