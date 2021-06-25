package com.example.RestClient.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Collaborator")
public class CollaboratorRp implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	/*
	private String first_name;
	private String last_name;
	private String email;
	*/
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/*
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	*/
}
