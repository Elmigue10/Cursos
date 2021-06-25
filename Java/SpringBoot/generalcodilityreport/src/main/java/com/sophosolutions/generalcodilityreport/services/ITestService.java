package com.sophosolutions.generalcodilityreport.services;

import java.io.IOException;
import java.util.List;

import com.sophosolutions.generalcodilityreport.model.Candidate;
import com.sophosolutions.generalcodilityreport.model.Test;

public interface ITestService {

	//Metodos indicados para el servicio
	//Methods indicated for the service
	public abstract void loadGeneral();
	
	public abstract void saveInRedis(Test test);
	
	public abstract String searchTest(String test, String email) throws IOException;
	
	public abstract List<Candidate> searchByTest(String test);
	
	public abstract String searchById(List<Candidate> candidates, String email) throws IOException;
	
	public abstract String loadReport(String id, String correo) throws IOException;
}
