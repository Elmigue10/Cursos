package com.example.RestClient.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.RestClient.config.Config;
import com.example.RestClient.models.Answer;
import com.example.RestClient.models.CollaboratorRp;
import com.example.RestClient.models.CollaboratorRp2;
import com.example.RestClient.service.ICollaboratorService;

@Repository
public class CollaboratorServiceImpl implements ICollaboratorService {
	
	@Autowired
	private Config config;
	
	@Override
	public List<CollaboratorRp2> findAll() {
		String url = config.getUri();
		RestTemplate rest = new RestTemplate();
		org.springframework.http.HttpHeaders headers = 
				new org.springframework.http.HttpHeaders();
		
		headers.set("Authorization", config.getToken());
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Answer> response = rest.exchange(url, HttpMethod.GET, 
				entity, Answer.class);
		String datos = response.getBody().getNext();
		List<CollaboratorRp> resultados = response.getBody().getresults();
		List<CollaboratorRp2> busqueda = new ArrayList<CollaboratorRp2>();
		while(datos != null) {
			ResponseEntity<Answer> response2 = rest.exchange(datos, HttpMethod.GET, 
					entity, Answer.class);
			datos = response2.getBody().getNext();
			for(CollaboratorRp colaborador : response2.getBody().getresults())
				resultados.add(colaborador);
		}
		System.out.println("Tamaño " + resultados.size());
		int conteo = 1;
		for(CollaboratorRp resultado : resultados)
		{
			busqueda.add(findById(resultado.getId()));
			/* Conteo de datos*/   
			System.out.print(conteo +  " : ");
			System.out.println(findById(resultado.getId()));
			conteo++;
		}
		//SE DEBE GUARDAR LOS DATOS
		return  busqueda;
	}


	@Override
	public CollaboratorRp2 findById(String id) {
		String url = config.getUri() + id;
		RestTemplate rest = new RestTemplate();
		org.springframework.http.HttpHeaders headers = 
				new org.springframework.http.HttpHeaders();
		headers.set("Authorization", config.getToken());
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<CollaboratorRp2> response = rest.exchange(url, HttpMethod.GET, 
				entity, CollaboratorRp2.class);
		//System.out.println(response.getBody());
		return response.getBody();
	}
	
}
