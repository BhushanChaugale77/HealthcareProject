package com.xcure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.xcure.dto.ConsultationDto;
import com.xcure.entity.Consultation;
import com.xcure.service.ConsultationInterfaceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ConsultationInterfaceService interfaceService;
	
	@GetMapping("/{consultationid}")
	public ResponseEntity<Consultation> findConsultationById(@PathVariable Integer consultationid){
		return new ResponseEntity<Consultation>(interfaceService.findConsultationById(consultationid),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Consultation>> allConsultation(){
		return new ResponseEntity<List<Consultation>>(interfaceService.allConsultation(), HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<ConsultationDto> createConsultation(@Valid @RequestBody ConsultationDto consultationDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ConsultationDto>(interfaceService.createConsultation(consultationDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{consultationid}")
	public ResponseEntity<Void> deleteConsultationById(@PathVariable Integer consultationid){
		interfaceService.deleteConsultationById(consultationid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{consultationid}")
	public ResponseEntity<ConsultationDto> updateConsultationEntity(@Valid @PathVariable Integer consultationid,@RequestBody ConsultationDto consultationDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ConsultationDto>(interfaceService.updateConsultationDto(consultationid, consultationDto),HttpStatus.UPGRADE_REQUIRED);
	}
	@PatchMapping("/{consultationid}")
	public ResponseEntity<ConsultationDto> patchEntity(@Valid @PathVariable Integer consultationid,@RequestBody ConsultationDto consultationDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ConsultationDto>(interfaceService.patchConsultationDto(consultationid, consultationDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Consultation>> paginationConsultation(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Consultation>>(interfaceService.paginationConsultation(page, size),HttpStatus.OK);
	}
}
