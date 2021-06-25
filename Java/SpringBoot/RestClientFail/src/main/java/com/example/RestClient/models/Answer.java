package com.example.RestClient.models;

import java.util.List;

public class Answer {

	private int count;
	private String next;
	private String previous;
	private List<CollaboratorRp> results;
	
	public int getCount() {
		return count;
	}
	
	public String getNext() {
		return next;
	}
	
	public String getPrevious() {
		return previous;
	}
	
	public List<CollaboratorRp> getresults(){
		return results;
	}
	
}
