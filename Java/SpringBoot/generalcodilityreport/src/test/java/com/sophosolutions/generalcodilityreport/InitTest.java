package com.sophosolutions.generalcodilityreport;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sophosolutions.generalcodilityreport.controller.TestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitTest {

	@Autowired
	private TestController controller;
	
	@Test
	public void contextLoad() {
		assertThat(controller).isNotNull();
	}
	
}
