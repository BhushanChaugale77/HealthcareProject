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

import com.xcure.dto.UserDto;
import com.xcure.entity.User;
import com.xcure.service.UserServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserCotroller {
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserServiceInterface serviceInterface;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Long userid){
		
		return new ResponseEntity<User>(serviceInterface.findUserById(userid),HttpStatus.FOUND);
 	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> allUser(){
		return new ResponseEntity<List<User>>(serviceInterface.allUser(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<UserDto>(serviceInterface.createUser(userDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long userid){
		serviceInterface.deleteUserById(userid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUserById(@Valid @PathVariable Long userid, @RequestBody UserDto userDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(serviceInterface.updateUserById(userid, userDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<UserDto> patchUserById(@Valid @PathVariable Long userid, @RequestBody UserDto userDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(serviceInterface.patchUserById(userid, userDto),HttpStatus.UPGRADE_REQUIRED);
	} 
	
	@GetMapping
	public ResponseEntity<Page<User>> paginationUser(@RequestParam int page, @RequestParam int size){

		return new ResponseEntity<Page<User>>(serviceInterface.paginationUser(page, size),HttpStatus.OK);
	}
	
}
