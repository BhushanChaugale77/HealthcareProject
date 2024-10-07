package com.xcure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consultation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer consultationid;
	
	private Integer appointmentid;
	
	private Integer doctorid;
	
	private Integer pationtid;
	
	private String status;

	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getConsultationid() {
		return consultationid;
	}

	public void setConsultationid(Integer consultationid) {
		this.consultationid = consultationid;
	}

	public Integer getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public Integer getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Integer doctorid) {
		this.doctorid = doctorid;
	}

	public Integer getPationtid() {
		return pationtid;
	}

	public void setPationtid(Integer pationtid) {
		this.pationtid = pationtid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Consultation [consultationid=" + consultationid + ", appointmentid=" + appointmentid + ", doctorid="
				+ doctorid + ", pationtid=" + pationtid + ", status=" + status + "]";
	}
	
	
	
}
