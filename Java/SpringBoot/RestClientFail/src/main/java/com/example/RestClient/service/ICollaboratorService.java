package com.example.RestClient.service;

import java.util.List;

import com.example.RestClient.models.CollaboratorRp2;

public interface ICollaboratorService {

	public abstract List<CollaboratorRp2> findAll();
	
	public abstract CollaboratorRp2 findById(String id);
	
}
