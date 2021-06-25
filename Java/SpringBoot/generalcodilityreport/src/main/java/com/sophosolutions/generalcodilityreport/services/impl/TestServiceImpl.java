package com.sophosolutions.generalcodilityreport.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sophosolutions.generalcodilityreport.config.Config;
import com.sophosolutions.generalcodilityreport.exception.ModelNotFound;
import com.sophosolutions.generalcodilityreport.model.AnswerCandidate;
import com.sophosolutions.generalcodilityreport.model.AnswerTest;
import com.sophosolutions.generalcodilityreport.model.Candidate;
import com.sophosolutions.generalcodilityreport.model.Test;
import com.sophosolutions.generalcodilityreport.services.ITestService;

@Service
public class TestServiceImpl implements ITestService {

	private  Config config;
	private RedisTemplate<String, Object> template;

	private RestTemplate rest;
	private RestTemplate rest2;
	private RestTemplate rest3;
	
	public TestServiceImpl(Config config, RedisTemplate<String, Object> template, RestTemplate rest, RestTemplate rest2, RestTemplate rest3) {
		this.config = config;
		this.template = template;
		this.rest = rest;
		this.rest2 = rest2;
		this.rest3 = rest3;
	}
	
	public static final String KEY = "Test";
	private String autorizacion =  "Authorization";
	
	
	//Busqueda de las pruebas y guardar en redis
	//Search of tests and save in redis
	@Override
	public void loadGeneral() {
		String url = config.getUri() + "tests/";
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.set(autorizacion, config.getToken());
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<AnswerTest> response = rest3.exchange(url, HttpMethod.GET, entity, AnswerTest.class);
		List<Test> resultados;
		if(!Objects.isNull(response.getBody())) {
			resultados = response.getBody().getResults(); //NOSONAR
		}else {
			throw new ModelNotFound("No se encontraron resultados");
		}
		
		for (Test test : resultados) {
			Test ajuste = new Test();
			ajuste.setId(test.getName().toLowerCase());
			ajuste.setName(test.getId());
			saveInRedis(ajuste);
		}
	}

	//Guardar test en redis
	//Save test in redis
	@Override
	public void saveInRedis(Test test) {
		template.opsForHash().put(KEY, test.getId(), test);	
	}
	
	//Busqueda en metodos
	//Search in methods
	@Override
	public String searchTest(String test, String email) throws IOException {
		List<Candidate> datos = searchByTest(test);
		String dato;
			dato = searchById(datos, email);
		if (dato.equals(""))
			throw new ModelNotFound("No existe un usuario con el correo " + email);
		return dato;
	}

	
	//Busqueda de la prueba por el nombre de la prueba
	//Search of test by name of test
	@Override
	public List<Candidate> searchByTest(String test) {
			Test prueba = (Test) template.opsForHash().get(KEY, test);
			if(prueba == null)
				throw new ModelNotFound("No existe una prueba con el nombre " + test);
			String uri = config.getUri()+"tests/" + prueba.getName() + "/sessions";
			org.springframework.http.HttpHeaders headers = 
					new org.springframework.http.HttpHeaders();
			headers.set(autorizacion, config.getToken());
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<AnswerCandidate> response = rest.exchange(uri,
					HttpMethod.GET, entity, AnswerCandidate.class);
			List<Candidate> datos;
			if(!Objects.isNull(response.getBody())) {
				datos = response.getBody().getResults(); //NOSONAR
			}else {
				throw new ModelNotFound("Ninguna persona ha presentado esta prueba");
			}
			return datos;
	}

	// Obtención del id de los candidatos de la prueba
	// Get by id of test's candidates
	@Override
	public String searchById(List<Candidate> candidates, String email) throws IOException {
		String mensaje = "";
		for (Candidate candidate : candidates) {
			if (!candidate.getEmail().isEmpty() && candidate.getEmail().equals(email)) {
				mensaje = loadReport(candidate.getId(), candidate.getEmail());
				//Dato encontrado 
			}
		}
		return mensaje;
	}

	//Busqueda del reporte por el id y guardar en la carpeta 
	//Search of report by id and save in the folder
	@Override
	public String loadReport(String id, String correo) throws IOException {
		String mensaje = "";
		String carpetaArchivo = System.getProperty("user.home")
				+ File.separator + config.getFilePath();

		String rutaArchivo = carpetaArchivo + File.separator;
		
		File carpeta = new File (carpetaArchivo);
		
		if(!carpeta.exists()) {
			carpeta.mkdirs();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set(autorizacion, config.getToken());
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		String path = config.getUri()+"sessions/" + id + "/pdf";
		//Imprimir ruta path 
		try {
			ResponseEntity<byte[]> responseEntity = rest2.exchange(path,
					HttpMethod.GET, entity, byte[].class);	
			byte[] content = responseEntity.getBody();
			
				Files.write(Paths.get(rutaArchivo + correo.toLowerCase() + "-" + id + ".pdf"), content,
						StandardOpenOption.CREATE);
				mensaje = "Archivo descargado. En : " + rutaArchivo;
			
		}catch(HttpClientErrorException ex) {
			throw new ModelNotFound("PDF aún no se ha generado o no ha sido encontrado");
		}
		return mensaje;
	}
}
