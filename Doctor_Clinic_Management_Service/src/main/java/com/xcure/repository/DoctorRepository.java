package com.xcure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

	 List<Doctor> findBySpecialty(String specialty);
	 List<Doctor> findByClinic_ClinicId(UUID clinicId);
}
