package com.alura.hotelalura.model;

public class Guest {

	private Integer id;
	private String name;
	private String lastName;
	private String birthDate;
	private String nationality;
	private String phone;

	public Guest(String name, String lastName, String birthDate, String nationality, String phone) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}