package com.xcure.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.entity.Clinic;
import com.xcure.repository.ClinicRepository;
import com.xcure.service.ClinicServiceInterface;

@Service
public class ClinicServiceImpl implements ClinicServiceInterface {

	@Autowired
	private ClinicRepository clinicRepository;

	@Override
	public Clinic addClinic(Clinic clinic) {
 		return clinicRepository.save(clinic);
	}

	@Override
	public Clinic updateClinic(UUID clinicId, Clinic clinic) {
 		Clinic clinic2 = new Clinic();
 		
 		clinic2.setAddress(clinic.getAddress());
 		clinic2.setCity(clinic.getCity());
 		clinic2.setClinicId(clinic.getClinicId());
 		clinic2.setClinicName(clinic.getClinicName());
 		clinic2.setDoctors(clinic.getDoctors());
 		clinic2.setState(clinic.getState());
 		clinic2.setZipCode(clinic.getZipCode());
		
 		clinicRepository.saveAndFlush(clinic2);
		return clinic2;
	}

	@Override
	public void deleteClinic(UUID clinicId) {
		clinicRepository.deleteById(clinicId);
	}

	@Override
	public Clinic getClinicById(UUID clinicId) {
 		return clinicRepository.findById(clinicId).orElseThrow();
	}

	@Override
	public Clinic patchClinic(UUID clinicId, Clinic clinic) {
 		Clinic clinic2 = new Clinic();

 		clinic2.setAddress(clinic.getAddress());
 		clinic2.setCity(clinic.getCity());
 		clinic2.setDoctors(clinic.getDoctors());

 		clinicRepository.flush();
		return clinic2;
	}

	@Override
	public Page<Clinic> paginationClinic(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return clinicRepository.findAll(pageable);
	}
	
}
