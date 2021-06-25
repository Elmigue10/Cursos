package com.sophosolutions.generalcodilityreport.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophosolutions.generalcodilityreport.model.Request;
import com.sophosolutions.generalcodilityreport.services.impl.TestServiceImpl;


@RestController
@Validated
@RequestMapping("/sophos/coe/candidates/v2")
public class TestController {

	private TestServiceImpl servicio;
	
	public TestController(TestServiceImpl servicio) {
		this.servicio = servicio;
	}
	
	//Construcción del servicio 
	//Service construction
	
	@PostConstruct
	public void loadGeneral() {
		servicio.loadGeneral();
	}
	
	//Busqueda por email de la persona y nombre de la prueba
	//Search by email and name of test 
	@PostMapping
	public String findByNameAndEmail(@RequestBody @Valid Request data) throws IOException {
		return servicio.searchTest(data.getName().toLowerCase(), data.getEmail());
	}
	
	
}
