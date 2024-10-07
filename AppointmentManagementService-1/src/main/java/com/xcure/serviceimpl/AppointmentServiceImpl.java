package com.xcure.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.dto.AppointmentDto;
import com.xcure.entity.Appointment;
import com.xcure.repository.AppointmentRepository;
import com.xcure.service.AppointmentServiceInterface;

@Service
public class AppointmentServiceImpl implements AppointmentServiceInterface {
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AppointmentRepository repository;

	@Override
	public Appointment findAppointmentById(Integer appointmentid) {
 		return repository.findById(appointmentid).orElseThrow();
	}

	@Override
	public List<Appointment> allAppointment() {
 		return repository.findAll();
	}

	@Override
	public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
		Appointment appointment = mapper.map(appointmentDto, Appointment.class);
		repository.save(appointment);
		AppointmentDto dto = mapper.map(appointment, AppointmentDto.class);
		
		return dto;
	}

	@Override
	public void deleteAppointmentById(Integer appointmentid) {
		repository.deleteById(appointmentid);
	}

	@Override
	public AppointmentDto updateAppointmentById(Integer appointmentid, AppointmentDto appointmentDto) {
		Appointment appointment = mapper.map(appointmentDto, Appointment.class);
		
		appointment.setAppointmentid(appointmentDto.getAppointmentid());
		appointment.setDoctorid(appointmentDto.getDoctorid());
		appointment.setPatientid(appointmentDto.getPatientid());
		appointment.setDate(appointmentDto.getDate());
		appointment.setTime(appointmentDto.getTime());
		appointment.setStetus(appointmentDto.getStetus());
		
		repository.saveAndFlush(appointment);
		AppointmentDto dto = mapper.map(appointment, AppointmentDto.class);
		return dto;
	}

	@Override
	public AppointmentDto patchAppointmentById(Integer appointmentid, AppointmentDto appointmentDto) {
		Appointment appointment = mapper.map(appointmentDto, Appointment.class);

		appointment.setAppointmentid(appointmentDto.getAppointmentid());
		appointment.setDate(appointmentDto.getDate());
		appointment.setTime(appointmentDto.getTime());
		appointment.setStetus(appointmentDto.getStetus());
		
		repository.flush();
		AppointmentDto dto = mapper.map(appointment, AppointmentDto.class);
		return dto;
	}

	@Override
	public Page<Appointment> paginationAppointment(int page, int size) {
 
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	
	
}
