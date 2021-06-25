package com.sophosolutions.generalcodilityreport.services.impl;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.Silent.class)

public class TestServiceImplTest {

	@Mock
	private RestTemplate restTemplate;
	
////	@Mock
////	private Config config;

////	@InjectMocks
////	private  TestServiceImpl servicio;

	@Test
	public void loadReportTest() {
		ResponseEntity<Byte[]> answer = new ResponseEntity<>(HttpStatus.OK);
		
		Mockito.when(restTemplate.exchange(
				Mockito.anyString(), 
				Mockito.any(HttpMethod.class),
				Mockito.any(),
				Mockito.<Class<Byte[]>>any()))
			.thenReturn(answer);
		assertSame( HttpStatus.OK, answer.getStatusCode());

	}
}