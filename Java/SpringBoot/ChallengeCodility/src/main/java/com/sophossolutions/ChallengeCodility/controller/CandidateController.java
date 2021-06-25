package com.sophossolutions.ChallengeCodility.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophossolutions.ChallengeCodility.model.Candidate;
import com.sophossolutions.ChallengeCodility.services.impl.CandidateServiceImpl;

@RestController
@RequestMapping("/sophos/coe/candidates")
public class CandidateController {

	@Autowired
	private CandidateServiceImpl servicio;
	
	
	//Carga inicial de los datos al ejecutar
	//Initial load of data when execute
	@PostConstruct
	public void loadGeneral() {
		servicio.loadGeneral();
	}
	
	//Listado de datos (prueba de carga)
	//List of data (load test)
	@GetMapping("test")
	public List<Candidate> listar(){
		return servicio.findRedisAll();
	}
	
	@PostMapping
	public ResponseEntity<String> findByEmail(@RequestBody Candidate data) {
		return new ResponseEntity<String>(servicio.searchEmail(data.getEmail().toLowerCase()), HttpStatus.OK);
	}
	
}
