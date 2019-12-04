package com.proyecto.personal.controladores;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.proyecto.personal.entidades.Paciente;
import com.proyecto.personal.repositorios.IPacienteRepository;

@Controller
@RequestMapping("pacientes")
public class PacienteController {
	// Repositorio para el manejo de datos
	@Autowired
	IPacienteRepository rpaciente;

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Paciente> getAll() {
		return (List<Paciente>) rpaciente.findAll();
	}
	
	 @GetMapping(value="save")
	 @ResponseBody
	    public HashMap<String, String> save(@RequestParam String nombre,@RequestParam String direccion) {
		 Paciente p=new Paciente();//creando objeto de doctor
		 
		 HashMap<String, String> jsonReturn=new HashMap<>();
		 //asignado datos al objeto de doctor
		 //es.setEspecialidad(especialidad);
		
		 
		 //manejando cualquier excepcion de error
		 try {
			 rpaciente.save(p);//guardando registro de doctor
			 jsonReturn.put("estado", "OK");
			 jsonReturn.put("mensaje", "Registro guardado");
			 
			 return jsonReturn;
		 }catch(Exception e) {
			 jsonReturn.put("estado", "ERROR");
			 jsonReturn.put("mensaje", "Registro no guardado"+e.getMessage());
			 return jsonReturn;
		 }
		 
	    }
	 //Eliminar
	 @GetMapping(value="delete/{id}")
	 @ResponseBody
	    public HashMap<String,String> delete (@PathVariable Integer id) {
		 
	        HashMap<String, String> jsonReturn=new HashMap<>();
	        
	        try {
	        	//buscando registro
	        	Paciente p=rpaciente.findById(id).get();
	        	//eliminando registro
	        	rpaciente.delete(p);
				 jsonReturn.put("estado", "OK");
				 jsonReturn.put("mensaje", "Registro eliminado");
				 return jsonReturn;
	        	
	        }catch(Exception e) {
				 jsonReturn.put("estado", "ERROR");
				 jsonReturn.put("mensaje", "Registro no guardado"+e.getMessage());
				 return jsonReturn;
			 }
	    }
	//actualizar
	 @GetMapping(value="update/{id}")
	 @ResponseBody
	    public HashMap<String, String> update(@RequestParam Integer id, @RequestParam String nombre, @RequestParam String direccion) {
		 Paciente p=new Paciente();//creando objeto de especialidad
		 
		 HashMap<String, String> jsonReturn=new HashMap<>();
		 //asignado datos al objeto de doctor
		 p.setId(id);
		 p.setNombre(nombre);
		 p.setDireccion(direccion);
		 
		 //manejando cualquier excepcion de error
		 try {
			 rpaciente.save(p);//guardando registro de doctor
			 jsonReturn.put("estado", "OK");
			 jsonReturn.put("mensaje", "Registro actualizado");			 
			 return jsonReturn;
			 
		 }catch(Exception e) {
			 jsonReturn.put("estado", "ERROR");
			 jsonReturn.put("mensaje", "Registro no actualizado"+e.getMessage());
			 return jsonReturn;
		 }
		 
	    }

}
