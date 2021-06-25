package com.sophossolutions.ChallengeCodility.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sophossolutions.ChallengeCodility.config.Config;
import com.sophossolutions.ChallengeCodility.exception.ModelNotFound;
import com.sophossolutions.ChallengeCodility.model.Answer;
import com.sophossolutions.ChallengeCodility.model.Candidate;
import com.sophossolutions.ChallengeCodility.repository.CandidateRepository;
import com.sophossolutions.ChallengeCodility.services.ICandidateService;

@Service
public class CandidateServiceImpl implements ICandidateService {

	@Autowired
	private Config config;
	
	private RestTemplate rest = new RestTemplate();
	
	//Logica de negocio
	//Business Logic
	
	//Llave en redis
	//key in redis
	public static final String key = "Candidate";
	
	private static final String CARPETA_ARCHIVO = System.getProperty("user.home")
			+ File.separator + "ReportesCodility";

	private static final String RUTA_ARCHIVO = CARPETA_ARCHIVO + File.separator;

	
	@Autowired
	private CandidateRepository repositorio;
	
	@Autowired
	private RedisTemplate template;
	
	//carga inicial de la api general
	//initial load of the general api
	@Override
	public void loadGeneral() {
		try {
			String url = config.getUri();
			RestTemplate rest = new RestTemplate();
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.set("Authorization", config.getToken());
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<Answer> response = rest.exchange(url, HttpMethod.GET, entity, Answer.class);
			String datos = response.getBody().getNext();
			List<Candidate> resultados = response.getBody().getResults();
			while(datos != null) {
				ResponseEntity<Answer> response2 = rest.exchange(datos, HttpMethod.GET, entity, Answer.class);
				datos = response2.getBody().getNext();
				for(Candidate colaborador : response2.getBody().getResults())
					if(colaborador.getEmail() != "")
						resultados.add(colaborador);
			}
			System.out.println("Datos encontrados = " + resultados.size());
			for(Candidate resultado : resultados) {
				Candidate ajuste = new Candidate();
				ajuste.setEmail(resultado.getId());
				ajuste.setId(resultado.getEmail().toLowerCase());
				saveInRedis(ajuste);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	//Guardar dato en redis
	//save data in redis
	@Override
	public void saveInRedis(Candidate colaborador) {
		try {
			template.opsForHash().put(key, colaborador.getId(), colaborador);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	//Prueba para los datos guardados
	//Test for saved data
	@Override
	public List<Candidate> findRedisAll() {
		try {
			return template.opsForHash().values(key);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	//Encontrar el id, por medio del correo
	//Find the id, by mail
	@Override
	public String searchEmail(String data) {
		String mensaje = "";
			Candidate nuevo = (Candidate) template.opsForHash().get(key, data);
			
			if(nuevo == null)
				throw new ModelNotFound("Usuario no encontrado");
			else {
				final String uri = config.getUri() + nuevo.getEmail();
				
				org.springframework.http.HttpHeaders headers = 
						new org.springframework.http.HttpHeaders();
				headers.set("Authorization", config.getToken());
				HttpEntity<String> entity = new HttpEntity<String>(headers);
				
				ResponseEntity<Candidate> response = rest.exchange(uri,
						HttpMethod.GET, entity, Candidate.class);
				
				System.out.println(nuevo.getId());
				
				mensaje = loadReport(nuevo.getEmail(), nuevo.getId());
				return mensaje;
			}
	}

	@Override
	public String loadReport(String id, String correo) {
			String mensaje = "";
			File carpeta = new File (CARPETA_ARCHIVO);
			
			if(!carpeta.exists()) {
				carpeta.mkdirs();
			}
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", config.getToken());
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			HttpEntity<String> entity = new HttpEntity<>(headers);
			String path = config.getUri() + id + "/pdf";
			System.out.println(path);
			try {
				ResponseEntity<byte[]> responseEntity = rest.exchange(path,
						HttpMethod.GET, entity, byte[].class);
				System.out.println(responseEntity);
				
				byte[] content = responseEntity.getBody();
				try {
					Files.write(Paths.get(RUTA_ARCHIVO + correo.toLowerCase() + ".pdf"), content,
							StandardOpenOption.CREATE);
					mensaje = "Archivo descargado. En : " + RUTA_ARCHIVO;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}catch(HttpClientErrorException ex) {
				throw new ModelNotFound("PDF aún no se ha generado o no ha sido encontrado");
			}
			return mensaje;
	}

	
}
