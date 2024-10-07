package com.xcure.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.dto.DoctorDto;
import com.xcure.entity.Doctor;
import com.xcure.repository.DoctorRepository;
import com.xcure.service.DoctorServiceInterface;

@Service
public class DoctorServiceImpl implements DoctorServiceInterface {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DoctorRepository repository;

	@Override
	public Doctor getdDoctorById(UUID doctorId) {
 		return repository.findById(doctorId).orElseThrow();
	}

	@Override
	public List<Doctor> allDoctors() {
 		return repository.findAll();
	}
	
	@Override
	public List<Doctor> getDoctorsBySpecialty(String specialty) {
 		return repository.findBySpecialty(specialty);
	}

	@Override
	public List<Doctor> getDoctorByClinic(UUID clinicId) {
 		return repository.findByClinic_ClinicId(clinicId);
	}

	@Override
	public DoctorDto addDoctor(DoctorDto doctorDto) {
		Doctor doctor = mapper.map(doctorDto, Doctor.class);
		repository.save(doctor);
		DoctorDto dto = mapper.map(doctor, DoctorDto.class); 
		return dto;
	}

	@Override
	public void deleteDoctorById(UUID doctorId) {
 		repository.deleteById(doctorId);
	}

	@Override
	public DoctorDto updateDoctor(UUID doctorID, DoctorDto doctorDto) {
 		Doctor doctor = mapper.map(doctorDto, Doctor.class);
 		
 		doctor.setDoctorId(doctorDto.getDoctorId());
 		doctor.setEmail(doctorDto.getEmail());
 		doctor.setFirstName(doctorDto.getFirstName());
 		doctor.setLastName(doctorDto.getLastName());
 		doctor.setSpecialty(doctorDto.getSpecialty());
 		
		repository.saveAndFlush(doctor);
		DoctorDto dto = mapper.map(doctor, DoctorDto.class);
		return dto;
	}

	@Override
	public DoctorDto patchDoctor(UUID doctorId, DoctorDto doctorDto) {
		Doctor doctor = mapper.map(doctorDto, Doctor.class);
		
		doctor.setEmail(doctorDto.getEmail());
 		doctor.setFirstName(doctorDto.getFirstName());
 		doctor.setLastName(doctorDto.getLastName());
		
 		repository.saveAndFlush(doctor);
		DoctorDto dto = mapper.map(doctor, DoctorDto.class);
		return dto;
	}

	@Override
	public Page<Doctor> paginationDoctor(int page, int size) {
 		
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}

	
	
	
}
