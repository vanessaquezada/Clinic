$(document).ready(inicio);

function inicio() {
	ListaDatos();
}

function ListaDatos() {
		$
				.ajax({
					url : "/consulta/lista",
					method : "Get",
					success : function(response) {

						$("#datos").html("");

						response.forEach(i=>{

							$("#datos")
									.append(""
										+ "<tr>"
										+ "<td>" + i.id_consulta + "</td>"
										+ "<td>" + i.fecha + "</td>"
										+ "<td>" + i.sintomas + "</td>"
										+ "<td>" + i.diagnostico + "</td>"
										+ "<td>" + i.doctor.nombre + "</td>"
										+ "<td>" + i.paciente.nombre + "</td>"
										+ "<td>" + "<button type='button' class='btn btn-warning'>Editar</button>"
										+ "</td>"
										+ "<td>"
										+ "<button type='button' class='btn btn-danger'>Eliminar</button>"
										+ "</td>"
										+ "</tr>"
										);
						});
					},
					error : function(response) {
						alert("ERROR " + response);
					}
				});
	}