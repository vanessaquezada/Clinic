package com.proyecto.personal.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.proyecto.personal.entidades.Doctor;
import com.proyecto.personal.entidades.Especialidad;
import com.proyecto.personal.repositorios.IDoctorRepository;
import com.proyecto.personal.service.DoctorService;

@Controller
@RequestMapping("doctor")
public class DoctorController {
	
	@GetMapping("index")
	public String Index() {
		return "Views/Doctor/doctor";
	}
	
	//Repositorio para el manejo de datos
	@Autowired
	DoctorService daoDoctor;
	
	//Metodo para listar y mostrarlo en JSON, o un tabla
	@GetMapping(value="all",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin
	public List<Doctor> Listar() {
		return (List<Doctor>) daoDoctor.Lista();
	}
	
	@GetMapping(value = "especialidad", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin
	public List<Especialidad> Lis(){
		return (List<Especialidad>) daoDoctor.ListEspecialidad();
	}
	
	//Metodo para guardar
	@GetMapping(value="save",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HashMap<String, String> Guardar(@RequestParam String nombre, @RequestParam String direccion, @RequestParam Integer especialidad) {
		
		//Creando Objeto de la entidad Doctor
		Doctor d=new Doctor();
			 
		HashMap<String, String> jsonReturn=new HashMap<>();
		//Obteniendo datos
		d.setNombre(nombre);
		d.setDireccion(direccion);
		d.setEspecialidad(daoDoctor.especialidad(especialidad));
			 
		//Manejando Excepcion de Errores
		try {
			//Guardando Registro
			daoDoctor.saveOrUpdate(d);
			jsonReturn.put("estado", "OK");
			jsonReturn.put("mensaje", "Registro guardado");
				 
			return jsonReturn;
		}catch(Exception e) {
			jsonReturn.put("estado", "ERROR");
			jsonReturn.put("mensaje", "Registro no guardado"+e.getMessage());
			return jsonReturn;
		}
			 
		}
	
	@GetMapping(value="modificar/{id_doctor}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Doctor getMethodName(@PathVariable Integer id_doctor) {
	    return daoDoctor.doctor(id_doctor);
	}
	
	//Metodo para modificar
	@GetMapping(value="update/{id_doctor}")
	@ResponseBody
	public HashMap<String, String> Actualizar(@RequestParam Integer id, @RequestParam String nombre, @RequestParam String direccion, @RequestParam Integer especialidad) {
		//Creando Objeto de la entidad Doctor
		Doctor d=new Doctor();
				 
		HashMap<String, String> jsonReturn=new HashMap<>();
		//asignado datos al objeto de doctor
		d.setId(id);
		d.setNombre(nombre);
		d.setDireccion(direccion);
		d.setEspecialidad(daoDoctor.especialidad(especialidad));
				 
		//Manejando Excepcion de Errores
		try {
			daoDoctor.saveOrUpdate(d);//Guardando Modficacion
			jsonReturn.put("estado", "OK");
			jsonReturn.put("mensaje", "Registro actualizado");			 
			return jsonReturn;
					 
		}catch(Exception e) {
			jsonReturn.put("estado", "ERROR");
			jsonReturn.put("mensaje", "Registro no actualizado"+e.getMessage());
			return jsonReturn;
		}
				 
	}
		 
	//Metodo para eliminar
	@GetMapping(value="delete/{id_doctor}")
	@ResponseBody
	public HashMap<String,String> Eliminar (@PathVariable Integer id_doctor) {
			 
		HashMap<String, String> jsonReturn=new HashMap<>();
		        
		try {
			//Buscando registro
		    Doctor doctor=daoDoctor.doctor(id_doctor);
		    //Eliminando registro
		    daoDoctor.Eliminar(doctor);
			jsonReturn.put("estado", "OK");
			jsonReturn.put("mensaje", "Registro eliminado");
			return jsonReturn;
		        	
		}catch(Exception e) {
			jsonReturn.put("estado", "ERROR");
			jsonReturn.put("mensaje", "Registro no guardado"+e.getMessage());
			return jsonReturn;
			}
		}
}
