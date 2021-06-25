package com.example.RestClient.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestClient.models.CollaboratorRp2;
import com.example.RestClient.models.CollaboratorRq;
import com.example.RestClient.repository.CollaboratorDao;
import com.example.RestClient.serviceImpl.CollaboratorServiceImpl;


@RestController
@RequestMapping("/collaborator")
public class ConsumoController {
	
	@Autowired
	private CollaboratorServiceImpl servicio;
	
	@Autowired
	private CollaboratorDao collaboratorDao;
	
	//Anotacion para iniciar cuando corra el servidor  @PostConstruct
	@PostConstruct
	public List<CollaboratorRp2> findAll()
	{
		return servicio.findAll();
	}
	
	@PostMapping
	public CollaboratorRp2 findById(@RequestBody CollaboratorRq data)
	{
		collaboratorDao.save(servicio.findById("KPZ4SC-4VE"));
		collaboratorDao.findAll();
		return servicio.findById("KPZ4SC-4VE");
	}
	
	@GetMapping("/list")
	public List<CollaboratorRp2> listar() {
		return collaboratorDao.findAll();
	}
}
