package com.example.model;

import com.opencsv.bean.CsvBindByName;

public class User {

	@CsvBindByName
	private String name;
	@CsvBindByName
	private String email;
	@CsvBindByName
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	


}
