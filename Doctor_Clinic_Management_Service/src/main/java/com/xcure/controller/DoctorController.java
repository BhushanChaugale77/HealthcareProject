package com.xcure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

import com.xcure.dto.DoctorDto;
import com.xcure.entity.Doctor;
import com.xcure.service.DoctorServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DoctorServiceInterface serviceInterface;
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable UUID doctorID){
		return new ResponseEntity<Doctor>(serviceInterface.getdDoctorById(doctorID),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Doctor>> allDoctors(){
		return new ResponseEntity<List<Doctor>>(serviceInterface.allDoctors(),HttpStatus.FOUND);
	}
	@GetMapping("/specialty/{specialty}")
	public ResponseEntity<List<Doctor>> getDoctorsBySpecialty(@PathVariable String specialty){
		return new ResponseEntity<List<Doctor>>(serviceInterface.getDoctorsBySpecialty(specialty),HttpStatus.OK);
	}
	
	@GetMapping("/clinic/{clinicId}")
	public ResponseEntity<List<Doctor>> getDoctorsByClinic(@PathVariable UUID clinicId){
		return new ResponseEntity<List<Doctor>>(serviceInterface.getDoctorByClinic(clinicId),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<DoctorDto> addDoctor(@Valid @RequestBody DoctorDto doctorDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);				
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<DoctorDto>(serviceInterface.addDoctor(doctorDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoctorById(@PathVariable UUID doctorID){
		serviceInterface.deleteDoctorById(doctorID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DoctorDto> updateDoctor(@Valid @PathVariable UUID doctorID, @RequestBody DoctorDto doctorDto, BindingResult bindingResult ){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);				
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<DoctorDto>(serviceInterface.updateDoctor(doctorID, doctorDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<DoctorDto> patchDoctor(@Valid @PathVariable UUID doctorID, @RequestBody DoctorDto doctorDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);				
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<DoctorDto>(serviceInterface.patchDoctor(doctorID, doctorDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Doctor>> paginationDoctor(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Doctor>>(serviceInterface.paginationDoctor(page, size),HttpStatus.OK);
	}
}
