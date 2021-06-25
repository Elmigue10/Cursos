package com.example.RestClient.models;

import java.io.Serializable;

public class Tasks implements Serializable{
	private String task_name;
	private String result;
	private String max_result;
	private String prg_lang;
	private String name;
	
	public Tasks() {
		
	}
	
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
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
	public String getPrg_lang() {
		return prg_lang;
	}
	public void setPrg_lang(String prg_lang) {
		this.prg_lang = prg_lang;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Tasks [task_name=" + task_name + ", result=" + result + ", max_result=" + max_result + ", prg_lang="
				+ prg_lang + ", name=" + name + "]";
	}
	
	
	
}
