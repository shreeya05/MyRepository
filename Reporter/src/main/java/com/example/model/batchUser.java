package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class batchUser {

	@Id
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer percentage;
	
	public batchUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public batchUser(Integer id, String firstName, String middleName, String lastName, Integer percentage) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.percentage = percentage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		final StringBuffer sb=new StringBuffer("batchUser{");
				sb.append("id=").append(id);
				sb.append(",firstName='").append(firstName).append('\'');
				sb.append(",middleName='").append(middleName).append('\'');
				sb.append(",lastName='").append(lastName).append('\'');
				sb.append(",percentage='").append(percentage).append('\'');
				sb.append('}');
				return sb.toString();
	}
	
	
	
	
}
