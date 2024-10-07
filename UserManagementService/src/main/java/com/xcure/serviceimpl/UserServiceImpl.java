package com.xcure.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.dto.UserDto;
import com.xcure.entity.User;
import com.xcure.repository.UserRepository;
import com.xcure.service.UserServiceInterface;
@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository repository;

	@Override
	public User findUserById(Long userid) {
 		return repository.findById(userid).orElseThrow();
	}

	@Override
	public List<User> allUser() {
 		return  repository.findAll();
	}

	@Override
	public UserDto createUser(UserDto userDto) {
 		User user = mapper.map(userDto, User.class);
 		repository.save(user);
 		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}

	@Override
	public void deleteUserById(Long userid) {
		repository.deleteById(userid);
	}

	@Override
	public UserDto updateUserById(Long userid, UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		
		user.setUserid(userDto.getUserid());
		user.setUseremail(userDto.getUseremail());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setCreatedAt(userDto.getCreatedAt());
		repository.flush();
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}

	@Override
	public UserDto patchUserById(Long userid, UserDto userDto) {
 
User user = mapper.map(userDto, User.class);
		
		user.setUserid(userDto.getUserid());
		user.setUseremail(userDto.getUseremail());
		user.setPassword(userDto.getPassword());
  		repository.flush();
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;	}

	@Override
	public Page<User> paginationUser(int page, int size) {
 
		Pageable pageable = PageRequest.of(page, size);
		
		return repository.findAll(pageable);
	}
	
	
}
