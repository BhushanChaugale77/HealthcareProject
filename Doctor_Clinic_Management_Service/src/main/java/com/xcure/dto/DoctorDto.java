package com.xcure.dto;

import java.util.UUID;

public class DoctorDto {

	private UUID doctorId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String specialty;

	public UUID getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(UUID doctorId) {
		this.doctorId = doctorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

}
