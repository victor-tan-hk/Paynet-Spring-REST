package com.workshop.rest;

public class Greeting {

	private int id;
	private String content;

	public Greeting(int id, String content) {
		this.id = id;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}