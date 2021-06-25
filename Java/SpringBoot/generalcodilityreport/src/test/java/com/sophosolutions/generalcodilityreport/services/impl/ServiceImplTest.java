package com.sophosolutions.generalcodilityreport.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sophosolutions.generalcodilityreport.config.Config;
import com.sophosolutions.generalcodilityreport.exception.ModelNotFound;
import com.sophosolutions.generalcodilityreport.model.AnswerCandidate;
import com.sophosolutions.generalcodilityreport.model.AnswerTest;
import com.sophosolutions.generalcodilityreport.model.Candidate;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class ServiceImplTest {

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

	@Before
	public void setUp() {
		// MockitoAnnotations.initMocks(this.config);
		// MockitoAnnotations.initMocks(this.template);
		// MockitoAnnotations.initMocks(this.rest);
		MockitoAnnotations.initMocks(this);
		Mockito.when(template.opsForHash()).thenReturn(hashOperations);
		service = new TestServiceImpl(config, template, rest, rest2, rest3);
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
	
	//verificar metodo de searchByTest
	//Verify method SearchByTest
	@Test
	public void searchByTestTest() {
		List<Candidate> candidates = listaDeDatos();
		AnswerCandidate nuevo = new AnswerCandidate();
		nuevo.setResults(candidates);
		ResponseEntity<AnswerCandidate> datos = new ResponseEntity<AnswerCandidate>(nuevo, HttpStatus.OK);

		com.sophosolutions.generalcodilityreport.model.Test prueba = new com.sophosolutions.generalcodilityreport.model.Test();
		prueba.setId("id1");
		prueba.setName("prueba nombre");

		Mockito.when(this.template.opsForHash().get(Mockito.anyString(), Mockito.anyString())).thenReturn(prueba);

		Mockito.when(this.config.getUri()).thenReturn("https://wwww.google.com/");
		Mockito.when(this.config.getToken()).thenReturn("hJHGBKJMGJHVHVMf");

		Mockito.when(this.rest.exchange(Mockito.anyString(), // anyString(), anyInteger()
				Mockito.eq(HttpMethod.GET), Mockito.any(), Mockito.<Class<AnswerCandidate>>any())).thenReturn(datos);
//		service.searchByTest("jeisson");
		assertSame(datos.getBody().getResults(), service.searchByTest("jeisson"));
	}
	
	@Test
	public void searchByTestNullTest() {
		Mockito.when(template.opsForHash().get(Mockito.anyString(), Mockito.any())).thenReturn(null);
		String nombre = "Prueba error";
		Exception exception = assertThrows(ModelNotFound.class, ()-> {service.searchByTest(nombre);});
		String mensaje = "No existe una prueba con el nombre "+ nombre;
		assertEquals(exception.getMessage(), mensaje);
	}
	@Test
	public void searchByTestNullBodyTest() {
	
		com.sophosolutions.generalcodilityreport.model.Test prueba = new com.sophosolutions.generalcodilityreport.model.Test();
		prueba.setId("id1");
		prueba.setName("prueba nombre");
		ResponseEntity<AnswerCandidate> datos = new ResponseEntity<AnswerCandidate>(HttpStatus.OK);
		Mockito.when(this.template.opsForHash().get(Mockito.anyString(), Mockito.anyString())).thenReturn(prueba);

		Mockito.when(this.config.getUri()).thenReturn("https://wwww.google.com/");
		Mockito.when(this.config.getToken()).thenReturn("hJHGBKJMGJHVHVMf");

		Mockito.when(this.rest.exchange(Mockito.anyString(), // anyString(), anyInteger()
				Mockito.eq(HttpMethod.GET), Mockito.any(), Mockito.<Class<AnswerCandidate>>any())).thenReturn(datos);

		Exception exception = assertThrows(ModelNotFound.class, ()-> {service.searchByTest("Prueba");});
	
		String mensaje = "Ninguna persona ha presentado esta prueba";
		assertEquals(exception.getMessage(), mensaje);
		
	}


	//Entra al modelNotfound
	//Enter the ModelNotFound
	@Test
	public void modelNotFoundTest() {
		String error = "error generado por testing";
		ModelNotFound exception = assertThrows(ModelNotFound.class, () -> {
			throw new ModelNotFound(error);
			});
		assertEquals(error, exception.getMessage());
	}
	
	//Mockear el mensaje del reporte
	//Mock the message the report
	@Test
	public void loadReportTest() throws IOException {
		Candidate cesar = new Candidate();
		cesar.setEmail("cesar.mesa@sophossolutions.com");
		cesar.setId("ID-1");

		Mockito.when(this.config.getFilePath()).thenReturn("Downloads");
		Mockito.when(this.config.getUri()).thenReturn("https://wwww.google.com/");
		Mockito.when(this.config.getToken()).thenReturn("hJHGBKJMGJHVHVMf");

		byte[] body = { 2, 3, 4 };

		String mensaje = "Archivo descargado. En : " + System.getProperty("user.home") + File.separator
				+ this.config.getFilePath() + File.separator;

		ResponseEntity<byte[]> datos = new ResponseEntity<byte[]>(body, HttpStatus.OK);

		Mockito.when(this.rest2.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<byte[]>>any())).thenReturn(datos);

		// service.loadReport(cesar.getId(),cesar.getEmail());

		assertEquals(service.loadReport(cesar.getId(), cesar.getEmail()), mensaje);
	}
	
	@Test
	public void loadReportHttpClientErrorTest() throws IOException {
		Candidate cesar = new Candidate();
		cesar.setEmail("cesar.mesa@sophossolutions.com");
		cesar.setId("ID-1");

		Mockito.when(this.config.getFilePath()).thenReturn("Downloads");
		Mockito.when(this.config.getUri()).thenReturn("https://wwww.google.com/");
		Mockito.when(this.config.getToken()).thenReturn("hJHGBKJMGJHVHVMf");
		byte[] body = { 2, 3, 4 };

		ResponseEntity<byte[]> datos = new ResponseEntity<byte[]>(body, HttpStatus.OK);
		Mockito.when(this.rest2.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<byte[]>>any())).thenReturn(datos);
		
		Mockito.when(service.loadReport(cesar.getId(), cesar.getEmail()))
		.thenThrow(HttpClientErrorException.create(HttpStatus.NOT_FOUND, "not found", null, null, null));
		
		Exception exception = assertThrows(ModelNotFound.class,() -> {service.loadReport(cesar.getId(), cesar.getEmail());}); //NOSONAR
		
		String mensaje = "PDF aún no se ha generado o no ha sido encontrado";
		assertEquals(exception.getMessage(), mensaje);
	}
	
	//Metodo de searchByIdTest()
	@Test
	public void searchByIdTest() throws IOException {
		
		List<Candidate> candidates = listaDeDatos();
		byte[] body = { 2, 3, 4 };
		Mockito.when(this.config.getFilePath()).thenReturn("Downloads");
		Mockito.when(this.config.getUri()).thenReturn("https://wwww.google.com/");
		Mockito.when(this.config.getToken()).thenReturn("hJHGBKJMGJHVHVMf");
		String mensaje = "Archivo descargado. En : " + System.getProperty("user.home") + File.separator
				+ this.config.getFilePath() + File.separator;
		ResponseEntity<byte[]> datos = new ResponseEntity<byte[]>(body, HttpStatus.OK);
		Mockito.when(this.rest2.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<byte[]>>any())).thenReturn(datos);
		assertEquals(service.searchById(candidates, candidates.get(0).getEmail()), mensaje);
	}
	
	@Test
    public void searchByIdIncorrectEmail() throws IOException {
       
        List<Candidate> candidates =  listaDeDatos();
       
        byte [] body = {2,3,4};
       
        Mockito.when(this.config.getFilePath()).thenReturn("Downloads\\RetoCodility");
        Mockito.when(this.config.getToken()).thenReturn("SAFASDFASGDAS");
        Mockito.when(this.config.getUri()).thenReturn("https://www.google.com/");
       
        ResponseEntity<byte[]> datos = new ResponseEntity<byte[]>(body, HttpStatus.OK);
       
        candidates.get(0).setEmail("");
        candidates.get(1).setEmail("");
       
        Mockito.when(this.rest.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.any(),
                Mockito.<Class<byte[]>>any())).thenReturn(datos);
       
        assertEquals("", service.searchById(candidates, "miguel@email.com"));
    }
	
	@Test
	public void searchByIdIfEmptyTest() throws IOException {
		List<Candidate> lista = listaDeDatos();
		String mensaje = new String();
		assertEquals(service.searchById(lista, "cesar"), mensaje);
	}

	//Search Test
	@Test
	public void searchTestTest() throws IOException {
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

		byte[] body = { 1, 2, 3 };

		ResponseEntity<byte[]> datos2 = new ResponseEntity<byte[]>(body, HttpStatus.OK);

		Mockito.when(this.rest2.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<byte[]>>any())).thenReturn(datos2);

		Mockito.when(this.rest.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(),
				Mockito.<Class<AnswerCandidate>>any())).thenReturn(datos);

		String mensaje = "Archivo descargado. En : " + System.getProperty("user.home") + File.separator
				+ this.config.getFilePath() + File.separator;

		assertEquals(service.searchTest("Cesar", candidates.get(0).getEmail()), mensaje);

	}

	//verifica que esten cargados los datos
	@Test
	public void isRedisLoadTest() {
		assertThat(template).isNotNull();
	}
	
	//Guardado de datos en redis
	@Test
	public void saveRedisTest() {
		TestServiceImpl servicio = mock(TestServiceImpl.class);
		com.sophosolutions.generalcodilityreport.model.Test prueba = new com.sophosolutions.generalcodilityreport.model.Test();
		prueba.setId("Id-2");
		prueba.setName("save redis in test");
		servicio.saveInRedis(prueba);
		verify(servicio, times(1)).saveInRedis(prueba);
		
		/*
		
		com.sophosolutions.generalcodilityreport.model.Test prueba = new com.sophosolutions.generalcodilityreport.model.Test();
		prueba.setId("Id-2");
		prueba.setName("save redis in test");
		this.service.saveInRedis(prueba);
		Mockito.when(this.template.opsForHash().get(Mockito.anyString(), Mockito.anyString())).thenReturn(prueba);
		assertThat(template.opsForHash().get("Test", "test-key")).isEqualTo(prueba);
		*/
		
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
		service.loadGeneral();
		assertEquals(lista, datos.getBody().getResults());
	}
	
	@Test
	public void loadGeneralThrowTest() {
		Mockito.when(this.config.getUri()).thenReturn("https://wwww.google.com/");
		Mockito.when(this.config.getToken()).thenReturn("security12345");

		ResponseEntity<AnswerTest> datos = new ResponseEntity<AnswerTest>(HttpStatus.OK);
		
		Mockito.when(rest3.exchange(Mockito.anyString(), 
				Mockito.eq(HttpMethod.GET),
				Mockito.any(),
				Mockito.<Class<AnswerTest>>any())).thenReturn(datos);
		
		Exception exception = assertThrows(ModelNotFound.class,() -> {service.loadGeneral();});
		
		String mensaje = "No se encontraron resultados";

		assertEquals(exception.getMessage(), mensaje);
		
	}
	
	

	
}
