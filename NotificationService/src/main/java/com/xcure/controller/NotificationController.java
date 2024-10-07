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

import com.xcure.dto.NotificationDto;
import com.xcure.entity.Notification;
import com.xcure.service.NotificationServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private NotificationServiceInterface serviceInterface;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<Notification> findNotificationById(@PathVariable UUID notificationId){
		return new ResponseEntity<Notification>(serviceInterface.findNotiicationById(notificationId),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Notification>> allNotification(){
		return new ResponseEntity<List<Notification>>(serviceInterface.allNotification(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<NotificationDto> createNotiication(@Valid @RequestBody NotificationDto notificationDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NotificationDto>(serviceInterface.createNotification(notificationDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNotificationById(@PathVariable UUID notificationId){
		serviceInterface.deleteNotificationById(notificationId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NotificationDto> updateNotificationById(@Valid @PathVariable UUID notificationId, @RequestBody NotificationDto notificationDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<NotificationDto>(serviceInterface.updateNotiicationById(notificationId, notificationDto),HttpStatus.UPGRADE_REQUIRED);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<NotificationDto> patchNotificationById(@Valid @PathVariable UUID notificationId, @RequestBody NotificationDto notificationDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NotificationDto>(serviceInterface.patchNotificationById(notificationId, notificationDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Notification>> paginationNotification(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Notification>>(serviceInterface.paginationNotification(page, size),HttpStatus.OK);
	}
}
