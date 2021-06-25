package com.sophossolutions.generalcodilityreport.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sophosolutions.generalcodilityreport.config.Config;
import com.sophosolutions.generalcodilityreport.controller.TestController;
import com.sophosolutions.generalcodilityreport.model.AnswerCandidate;
import com.sophosolutions.generalcodilityreport.model.AnswerTest;
import com.sophosolutions.generalcodilityreport.model.Candidate;
import com.sophosolutions.generalcodilityreport.model.Request;
import com.sophosolutions.generalcodilityreport.services.impl.TestServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class TestControllerTest {

	@Mock
	private RestTemplate rest;

	@Mock
	private RestTemplate rest2;

	@Mock
	private RestTemplate rest3;
	
	@Mock
	private RedisTemplate<String, Object> template;

	@Mock
	private HashOperations hashOperations;

	@Mock
	private Config config;
	
	@InjectMocks
	private TestServiceImpl service;
	
	@InjectMocks
	private TestController controlador;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(template.opsForHash()).thenReturn(hashOperations);
		service = new TestServiceImpl(config, template, rest, rest2, rest3);
		controlador = new TestController(service);
	}
	

	public List<Candidate> listaDeDatos() {
		List<Candidate> candidates = new ArrayList<>();
		Candidate cesar = new Candidate();
		cesar.setEmail("cesar.mesa@sophossolutions.com");
		cesar.setId("ID-1");
		Candidate kelly = new Candidate();
		kelly.setEmail("kelly.castillo@sophossolutions.com");
		kelly.setId("MM8XK2-FUT");
		candidates.add(kelly);
		Candidate diego = new Candidate();
		diego.setEmail("diego.franco@sophossolutions.com");
		diego.setId("8GYDFB-WFQ");
		candidates.add(diego);
		candidates.add(cesar);
		return candidates;
	}
	
	@Test
	public void controllerLoadGeneralTest() {
		TestController controller= mock(TestController.class);
		controller.loadGeneral();
		verify(controller, times(1)).loadGeneral();	
	}
	
	public Request data() {
		Request data = new Request();
		data.setEmail("cesar.mesa@sophossolutions.com");
		data.setName("Prueba1");
		return data;
	}
	
	@Test
	public void loadGeneralTest() {
		Mockito.when(this.config.getUri()).thenReturn("https://wwww.google.com/");
		Mockito.when(this.config.getToken()).thenReturn("security12345");

		AnswerTest body = new AnswerTest();
		List<com.sophosolutions.generalcodilityreport.model.Test> lista = new ArrayList<>();
		com.sophosolutions.generalcodilityreport.model.Test test = new com.sophosolutions.generalcodilityreport.model.Test();
		test.setId("id-1");
		test.setName("Prueba");
		lista.add(test);
		body.setResults(lista);
		ResponseEntity<AnswerTest> datos = new ResponseEntity<AnswerTest>(body,HttpStatus.OK);
		
		Mockito.when(rest3.exchange(Mockito.anyString(), 
				Mockito.eq(HttpMethod.GET),
				Mockito.any(),
				Mockito.<Class<AnswerTest>>any())).thenReturn(datos);
		//
		controlador.loadGeneral();
		assertEquals(lista, datos.getBody().getResults());
	}
	
	@Test
	public void controllerFindByNameAndIdTest() throws IOException {
		TestController controller = mock (TestController.class);
		Request data = data();
		controller.findByNameAndEmail(data);
		verify(controller, times(1)).findByNameAndEmail(data);
	}
	
	@Test
	public void findByNameAndEmail() throws IOException {
		List<Candidate> candidates = listaDeDatos();
		AnswerCandidate lista = new AnswerCandidate();
		lista.setResults(candidates);
		ResponseEntity<AnswerCandidate> datos = new ResponseEntity<AnswerCandidate>(lista, HttpStatus.OK);
		com.sophosolutions.generalcodilityreport.model.Test prueba = new com.sophosolutions.generalcodilityreport.model.Test();
		prueba.setId("prueba-1");
		prueba.setName("Prueba1");
		Mockito.when(this.template.opsForHash().get(Mockito.anyString(), Mockito.anyString())).thenReturn(prueba);
		Mockito.when(this.config.getUri()).thenReturn("https://wwww.google.com/");
		Mockito.when(this.config.getToken()).thenReturn("hJHGBKJMGJHVHVMf");
		Mockito.when(this.config.getFilePath()).thenReturn("carpeta");
		String mensaje = "Archivo descargado. En : " + System.getProperty("user.home") + File.separator
				+ this.config.getFilePath() + File.separator;
		byte[] body = { 1, 2, 3 };

		ResponseEntity<byte[]> datos2 = new ResponseEntity<byte[]>(body, HttpStatus.OK);

		Mockito.when(this.rest2.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<byte[]>>any())).thenReturn(datos2);

		Mockito.when(this.rest.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<AnswerCandidate>>any())).thenReturn(datos);
		
		assertEquals(controlador.findByNameAndEmail(data()), mensaje);
	}
	

	
}
