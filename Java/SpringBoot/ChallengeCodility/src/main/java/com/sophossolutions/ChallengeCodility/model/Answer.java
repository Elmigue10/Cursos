package com.sophossolutions.ChallengeCodility.model;

import java.util.List;

public class Answer {
	private int count;
	private String next;
	private String previous;
	private List<Candidate> results;
	
	public Answer() {
		
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<Candidate> getResults() {
		return results;
	}

	public void setResults(List<Candidate> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Answer [count=" + count + ", next=" + next + ", previous=" + previous + ", results=" + results + "]";
	}
	
	
}
