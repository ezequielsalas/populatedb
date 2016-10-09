package com.testdb.model;

public class Data {

	private long id;
	private String key;
	private String description;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Data(long id, String key, String description) {
		this.id = id;
		this.key = key;
		this.description = description;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ id = "+id+", key = "+key+", description = "+description+"]";
	}
	
	
}
