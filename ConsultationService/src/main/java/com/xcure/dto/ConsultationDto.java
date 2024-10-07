package com.xcure.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class ConsultationDto {

	@NonNull
	private Integer consultationid;
	@NonNull
	private Integer appointmentid;
	@NonNull
	private Integer doctorid;
	@NonNull
	private Integer pationtid;
	@NonNull
	@NotBlank
	@NotEmpty
	private String status;

	public ConsultationDto() {
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
		return "ConsultationDto [consultationid=" + consultationid + ", appointmentid=" + appointmentid + ", doctorid="
				+ doctorid + ", pationtid=" + pationtid + ", status=" + status + "]";
	}
	
	
	
}
