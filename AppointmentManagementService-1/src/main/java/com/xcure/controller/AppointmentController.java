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

import com.xcure.dto.AppointmentDto;
import com.xcure.entity.Appointment;
import com.xcure.service.AppointmentServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AppointmentServiceInterface serviceInterface;
	
	@GetMapping("/{id}")
	public ResponseEntity<Appointment> findAppointment(@PathVariable Integer appointmentid){
		return new ResponseEntity<Appointment>(serviceInterface.findAppointmentById(appointmentid),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Appointment>> allAppointment(){
		return new ResponseEntity<List<Appointment>>( serviceInterface.allAppointment(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<AppointmentDto> createAppointment(@Valid @RequestBody AppointmentDto appointmentDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AppointmentDto>(serviceInterface.createAppointment(appointmentDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAppointmentById(@PathVariable Integer appointmentid){
		serviceInterface.deleteAppointmentById(appointmentid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AppointmentDto> updateAppointmentById(@Valid @PathVariable Integer appointmentid, @RequestBody AppointmentDto appointmentDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AppointmentDto>(serviceInterface.updateAppointmentById(appointmentid, appointmentDto),HttpStatus.UPGRADE_REQUIRED);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<AppointmentDto> patchAppointmentById(@Valid @PathVariable Integer appoinmentid,@RequestBody AppointmentDto appointmentDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AppointmentDto>(serviceInterface.patchAppointmentById(appoinmentid, appointmentDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Appointment>> paginationAppointment(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Appointment>>(serviceInterface.paginationAppointment(page, size),HttpStatus.OK);
	}
}
