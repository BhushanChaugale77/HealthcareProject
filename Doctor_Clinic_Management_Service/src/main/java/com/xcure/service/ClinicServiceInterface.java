package com.xcure.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.xcure.entity.Clinic;

public interface ClinicServiceInterface {

	
	Clinic addClinic(Clinic clinic);
	
	Clinic updateClinic(UUID clinicId, Clinic clinic);
	
	void deleteClinic(UUID clinicId);
	
	Clinic getClinicById(UUID clinicId);
	
	Clinic patchClinic(UUID clinicId, Clinic clinic);
	
	Page<Clinic> paginationClinic(int page, int size);
}
