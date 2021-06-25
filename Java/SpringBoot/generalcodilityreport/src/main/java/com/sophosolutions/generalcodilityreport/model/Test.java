package com.sophosolutions.generalcodilityreport.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@RedisHash("Test")
public class Test implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@Indexed
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
