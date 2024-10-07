package com.xcure.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xcure.entity.Clinic;
import com.xcure.service.ClinicServiceInterface;

@RestController
@RequestMapping("api/v1/clinics")
public class ClinicController {

	@Autowired
	private ClinicServiceInterface clinicServiceInterface;
	
	@PostMapping
	public ResponseEntity<Clinic> addClinic(@RequestBody Clinic clinic){
		return new ResponseEntity<Clinic>(clinicServiceInterface.addClinic(clinic),HttpStatus.CREATED);
	}
	
	@GetMapping("/{clinicId}")
	public ResponseEntity<Clinic> getClinicById(@PathVariable UUID clinicId){
		return new ResponseEntity<Clinic>(clinicServiceInterface.getClinicById(clinicId),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{clinicId}")
	public ResponseEntity<Void> deleteClinic(@PathVariable UUID clinicId){
		clinicServiceInterface.deleteClinic(clinicId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("{clinicId}")
	public ResponseEntity<Clinic> updateClinic(@PathVariable UUID clinicId, @RequestBody Clinic clinic){
		return new ResponseEntity<Clinic>(clinicServiceInterface.updateClinic(clinicId, clinic),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@PatchMapping("/{clinicId}")
	public ResponseEntity<Clinic> patchClinic(@PathVariable UUID clinicId, @RequestBody Clinic clinic){
		return new ResponseEntity<Clinic>(clinicServiceInterface.patchClinic(clinicId, clinic),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Clinic>> paginationClinic(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Clinic>>(clinicServiceInterface.paginationClinic(page, size),HttpStatus.OK);
	}
}
