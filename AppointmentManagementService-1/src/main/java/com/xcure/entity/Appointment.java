package com.xcure.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  appointmentid;
	
	private Integer doctorid;
	
	private Integer patientid;
	
	private Date date;
	
	private Time time;
	
	private String stetus;

	public Appointment() {
		super();
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

	public Integer getPatientid() {
		return patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getStetus() {
		return stetus;
	}

	public void setStetus(String stetus) {
		this.stetus = stetus;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", doctorid=" + doctorid + ", patientid=" + patientid
				+ ", date=" + date + ", time=" + time + ", stetus=" + stetus + "]";
	}
	
	
}
