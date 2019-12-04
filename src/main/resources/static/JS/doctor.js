let doctor = {
 			id : 0
 		};

 		function setId_doctorDoctor(id_doctor) {
 			doctor.id_doctor = id_doctor;
 		}

$(document).ready(inicio);

function inicio() {
	Especialidad();
	ListaDatos();
	SelectEspecialidad();
	$("#btnGuardar").click(Guardar);
	$("#btnEliminar").click(function() {
		Eliminar(doctor.id_doctor);
	});
}

/*Metodo Para Listar Los Datos De La Tabla Doctores*/
function ListaDatos() {
		$
				.ajax({
					url : "/doctor/all",
					method : "Get",
					success : function(response) {

						$("#datos").html("");

						response.forEach(i=>{

							$("#datos")
									.append(""
										+ "<tr>"
										+ "<td>" + i.id_doctor + "</td>"
										+ "<td>" + i.nombre + "</td>"
										+ "<td>" + i.direccion + "</td>"
										+ "<td>" + i.especialidad.especialidad + "</td>"
										+ "<td>" + "<button onclick='Cargar(" + i.id_doctor + ");' type='button' class='btn btn-warning' data-toggle='modal' data-target='#Editar'>Editar</button>" + "</td>"
										+ "<td>"
										+ "<button onclick='setId_doctorDoctor("+ i.id_doctor +");' type='button' class='btn btn-danger' id='Eliminar' data-toggle='modal' data-target='#eliminar'>Eliminar</button>" + "</td>"
										+ "</tr>"
										);
						});
					},
					error : function(response) {
						alert("ERROR " + response);
					}
				});
	}

/*Metodo Para Guardar Un Nuevo Registro De Doctor*/
function Guardar() {
		$.ajax({
			url : "/doctor/save",
			method : "Get",
			data : {
				id_doctor : null,
				nombre:$("#nombre").val(),
				direccion:$("#direccion").val(),
				especialidad:$("#especialidad").val(),
			},
			success : function(response) {
				alert("REGISTRO GUARDADO EXITOSAMENTE.");
				ListaDatos();
			},
			error : function(response) {
				alert("ERROR " + response);
			}

		});
	}

/*Metodo Para Cargar Las Especialidades En El Select*/
function SelectEspecialidad() {
	$.ajax({
		url: "/doctor/especialidad",
		method: "Get",
		success: function (response) {

			response.forEach(item=> {
				$("#especialidad").append(""
						+ '<option value=' + item.id_especialidad + '>' + item.especialidad +
					'</option>');
			});

		},
		error: function (response) {
			alert("ERROR " + response);
		}
	});
}

/*Metodo Para Cargar Los Datos En Los Inputs*/
function Cargar(id_doctor) {
		$.ajax({
			url : "/doctor/update/" + id_doctor,
			method : "Get",
			success : function(response) {

			$("#id_doctor").val(response.id_doctor);
            $("#nombre2").val(response.nombre);
            $("#direccion2").text(response.direccion);
            $("#direccion2").val(response.direccion);
            $("#especialidad2").val(response.especialidad.id_especialidad)
			},
			error : function(response) {
				alert("ERROR " + response);
			}
		});
	}

/*Metodo Para Cargar Las Especialidades En El Select De Modificar*/
function Especialidad() {
	$.ajax({
		url: "/doctor/especialidad",
		method: "Get",
		success: function (response) {
			
			response.forEach(item=> {
				
				$("#especialidad2").append(""
						+ '<option value=' + item.id_especialidad + '>' + item.especialidad + '</option>');
			});

		},
		error: function (response) {
			//Mensaje de error
			alert("ERROR " + response);
		}
	});
}

/*Metodo Para Eliminar*/
function Eliminar(id_doctor) {
	$.ajax({
		url: "/doctor/delete/" + id_doctor,
		method: "Get",
		success: function(response) {
			alert("REGISTRO ELIMINADO EXITOSAMENTE");
			ListaDatos();
		},
		error: function(response) {
			alert("error al eliminar" + response)
		},
	});
}