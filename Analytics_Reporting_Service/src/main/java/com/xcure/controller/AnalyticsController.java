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

import com.xcure.dto.AnalyticsDto;
import com.xcure.entity.Analytics;
import com.xcure.service.AnalyticsServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AnalyticsServiceInterface serviceInterface;
	
	@GetMapping("/{id}")
	public ResponseEntity<Analytics> getAnalyticsDataById(@PathVariable UUID id){
		return new ResponseEntity<Analytics>(serviceInterface.getAnalyticsData(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Analytics>> getAllAnalytics(){
		return new ResponseEntity<List<Analytics>>(serviceInterface.getAllAnalytics(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<AnalyticsDto> genrateAnalytisReport(@Valid @RequestBody AnalyticsDto analyticsDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> hashMap = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				hashMap.put(field, defaultMessage);
			});
			return new ResponseEntity(hashMap,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AnalyticsDto>(serviceInterface.genrateAnalyticsReport(analyticsDto),HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAnalyticsReport(@PathVariable UUID id){
		serviceInterface.deleteAnalyticsReport(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AnalyticsDto> updateAnalyticsReport(@Valid @PathVariable UUID id,@RequestBody AnalyticsDto analyticsDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> hashMap = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				hashMap.put(field, defaultMessage);
			});
			return new ResponseEntity(hashMap,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AnalyticsDto>(serviceInterface.updateReport(id, analyticsDto),HttpStatus.UPGRADE_REQUIRED);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<AnalyticsDto> patchAnalyticsReportById(@Valid @PathVariable UUID id,@RequestBody AnalyticsDto analyticsDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> hashMap = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				hashMap.put(field, defaultMessage);
			});
			return new ResponseEntity(hashMap,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AnalyticsDto>(serviceInterface.patchAnalytics(id, analyticsDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Analytics>> paginationAnalyticsReport(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Analytics>>(serviceInterface.paginationAnalyticsPage(page, size),HttpStatus.OK);
	}
}
