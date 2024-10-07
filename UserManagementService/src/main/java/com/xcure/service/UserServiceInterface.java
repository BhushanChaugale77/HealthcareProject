package com.xcure.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xcure.dto.UserDto;
import com.xcure.entity.User;

public interface UserServiceInterface {

	
	User findUserById(Long id);
	
	List<User> allUser();
	
	UserDto createUser(UserDto userDto);
	
	void deleteUserById(Long id);
	
	UserDto updateUserById(Long id, UserDto userDto);
	
	UserDto patchUserById(Long id, UserDto userDto);
	
	Page<User> paginationUser(int page, int size);

	
}
