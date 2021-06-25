package com.sophossolutions.ChallengeCodility.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Candidate")
public class Candidate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String email;
	@Id
	private String id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Candidate [email=" + email + ", id=" + id + "]";
	}
	
	

}
