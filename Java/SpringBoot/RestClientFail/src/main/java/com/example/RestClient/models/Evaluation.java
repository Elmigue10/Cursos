package com.example.RestClient.models;

import java.io.Serializable;
import java.util.List;

public class Evaluation implements Serializable{

	private String result;
	private String max_result;
	private List<Tasks> tasks;
	
	public Evaluation()
	{
		
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMax_result() {
		return max_result;
	}
	public void setMax_result(String max_result) {
		this.max_result = max_result;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Evaluation [result=" + result + ", max_result=" + max_result + ", tasks=" + tasks + "]";
	}
	
	
	
}
