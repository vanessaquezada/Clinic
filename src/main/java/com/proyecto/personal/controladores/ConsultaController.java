package com.proyecto.personal.controladores;


import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.personal.entidades.Consulta;
import com.proyecto.personal.service.ConsultaService;

@Controller
@RequestMapping("consultas")
public class ConsultaController {

	// Repositorio para el manejo de datos
	@Autowired
	ConsultaService consultaService;

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Consulta> getAllConsulta() {
		return (List<Consulta>) consultaService.getAll();
	}

	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String> save(@RequestParam Date fecha, @RequestParam String sintomas,
			@RequestParam String diagnostico, @RequestParam Integer idDoctor,@RequestParam Integer idPaciente) {
		Consulta consulta = new Consulta();// creando objeto de consulta
 
		HashMap<String, String> jsonReturn = new HashMap<>();
		// asignado datos al objeto de doctor
		consulta.setFecha(fecha);
		consulta.setSintomas(sintomas);
		consulta.setDiagnostico(diagnostico);
		consulta.setDoctor(consultaService.getDoctor(idDoctor));
		consulta.setPaciente(consultaService.getPaciente(idPaciente));
		// manejando cualquier excepcion de error
		try {
			consultaService.saveOrUpdate(consulta);// guardando registro de doctor
			jsonReturn.put("estado", "OK");
			jsonReturn.put("mensaje", "Registro guardado");

			return jsonReturn;
		} catch (Exception e) {
			jsonReturn.put("estado", "ERROR");
			jsonReturn.put("mensaje", "Registro no guardado" + e.getMessage());
			return jsonReturn;
		}

	}

	// Eliminar
	@GetMapping(value = "delete/{id}")
	@ResponseBody
	public HashMap<String, String> delete(@PathVariable Integer id) {

		HashMap<String, String> jsonReturn = new HashMap<>();

		try {
			// buscando registro
			Consulta consulta = consultaService.getConsulta(id);
			// eliminando registro
			consultaService.delete(consulta);
			jsonReturn.put("estado", "OK");
			jsonReturn.put("mensaje", "Registro eliminado");
			return jsonReturn;

		} catch (Exception e) {
			jsonReturn.put("estado", "ERROR");
			jsonReturn.put("mensaje", "Registro no guardado" + e.getMessage());
			return jsonReturn;
		}
	}

	// actualizar
	@GetMapping(value = "update/{id}")
	@ResponseBody
	public HashMap<String, String> update(@RequestParam Integer id, @RequestParam Date fecha,
			@RequestParam String sintomas, @RequestParam String diagnostico, @RequestParam Integer idDoctor, @RequestParam Integer idPaciente) {
		Consulta consulta = new Consulta();// creando objeto de consulta
		HashMap<String, String> jsonReturn = new HashMap<>();

		// asignado datos al objeto de doctor
		consulta.setId(id);
		consulta.setFecha(fecha);
		consulta.setSintomas(sintomas);
		consulta.setDoctor(consultaService.getDoctor(idDoctor));
		consulta.setPaciente(consultaService.getPaciente(idPaciente));

		// manejando cualquier excepcion de error
		try {
			consultaService.saveOrUpdate(consulta);// guardando registro de doctor
			jsonReturn.put("estado", "OK");
			jsonReturn.put("mensaje", "Registro actualizado");
			return jsonReturn;

		} catch (Exception e) {
			jsonReturn.put("estado", "ERROR");
			jsonReturn.put("mensaje", "Registro no actualizado" + e.getMessage());
			return jsonReturn;
		}

	}

}
