package com.sophosolutions.generalcodilityreport.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Request {

	@NotNull(message = "Nombre de la prueba requerido")
	@Size(min = 4, max = 70, message = "Minimo 4 caracteres y maximo 70 caracteres")
	private String name;
	
	@NotNull(message = "Correo requerido")
	private String email;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

}
