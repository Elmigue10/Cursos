package com.sophosolutions.generalcodilityreport.model;

import java.io.Serializable;

public class Candidate implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
