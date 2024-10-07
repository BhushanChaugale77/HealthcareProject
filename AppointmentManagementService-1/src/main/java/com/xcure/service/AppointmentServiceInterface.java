package com.xcure.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xcure.dto.AppointmentDto;
import com.xcure.entity.Appointment;

public interface AppointmentServiceInterface {

	
	Appointment findAppointmentById(Integer appointmentid);
	
	List<Appointment> allAppointment();
	
	AppointmentDto createAppointment(AppointmentDto appointmentDto);
	
	void deleteAppointmentById(Integer appointmentid);
	
	AppointmentDto updateAppointmentById(Integer appointmentid, AppointmentDto appointmentDto);
	
	AppointmentDto patchAppointmentById(Integer appointmentid, AppointmentDto appointmentDto);
	
	Page<Appointment> paginationAppointment(int page, int size);
	
}
