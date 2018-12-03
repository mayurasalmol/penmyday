package com.mayur.springbootstarter.topic;

public class Topic {
	private String id;
	private String name;
	private String descritption;

	public Topic() {
		
	}

	public Topic(String id, String name, String descritption) {
		super();
		this.id = id;
		this.name = name;
		this.descritption = descritption;
	}

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

	public String getDescritption() {
		return descritption;
	}

	public void setDescritption(String descritption) {
		this.descritption = descritption;
	}

}
