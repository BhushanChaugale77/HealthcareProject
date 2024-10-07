package com.xcure.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.xcure.dto.DoctorDto;
import com.xcure.entity.Doctor;

public interface DoctorServiceInterface {

	
	Doctor getdDoctorById(UUID doctorId);
	
	List<Doctor> allDoctors();

	DoctorDto addDoctor(DoctorDto doctorDto);
	
	List<Doctor> getDoctorsBySpecialty(String specialty);
	
	List<Doctor> getDoctorByClinic(UUID clinicId);
	
	void deleteDoctorById(UUID doctorId);
	
	DoctorDto updateDoctor(UUID doctorID, DoctorDto doctorDto);
	
	DoctorDto patchDoctor(UUID doctorId, DoctorDto doctorDto);
	
	Page<Doctor> paginationDoctor(int page, int size);
}
