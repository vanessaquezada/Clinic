$(document).ready(inicio);

function inicio() {
	ListaDatos();
}

function ListaDatos() {
		$
				.ajax({
					url : "/especialidad/lista",
					method : "Get",
					success : function(response) {

						$("#datos").html("");

						response.forEach(i=>{

							$("#datos")
									.append(""
										+ "<tr>"
										+ "<td>" + i.id_especialidad + "</td>"
										+ "<td>" + i.especialidad + "</td>"
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