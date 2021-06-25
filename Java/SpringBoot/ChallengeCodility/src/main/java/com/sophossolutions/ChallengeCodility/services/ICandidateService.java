package com.sophossolutions.ChallengeCodility.services;

import java.util.List;

import com.sophossolutions.ChallengeCodility.model.Candidate;

public interface ICandidateService {
	
	//Metodos definidos para la implementación
	//Defined methods for implementation 
	
	public abstract void loadGeneral();
	
	public abstract void saveInRedis(Candidate colaborador);
	
	public abstract List<Candidate> findRedisAll();
	
	public abstract String searchEmail(String data);
	
	public abstract String loadReport(String id, String correo);
}
