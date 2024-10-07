package com.xcure.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.dto.NotificationDto;
import com.xcure.entity.Notification;
import com.xcure.repository.NotificationRepository;
import com.xcure.service.NotificationServiceInterface;

@Service
public class NotificationServiceImpl implements NotificationServiceInterface {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private NotificationRepository repository; 

	@Override
	public Notification findNotiicationById(UUID notificationId) {
 		return repository.findById(notificationId).orElseThrow();
	}

	@Override
	public List<Notification> allNotification() {
 		return repository.findAll();
	}

	@Override
	public NotificationDto createNotification(NotificationDto notificationDto) {
 		Notification notification = mapper.map(notificationDto, Notification.class);
 		repository.save(notification);
 		NotificationDto dto = mapper.map(notification, NotificationDto.class);
 		return dto;
	}

	@Override
	public void deleteNotificationById(UUID notificationId) {
		repository.deleteById(notificationId);
		
	}

	@Override
	public NotificationDto updateNotiicationById(UUID notificationId, NotificationDto notificationDto) {
		Notification notification = mapper.map(notificationDto, Notification.class);
		
		notification.setCreatedAt(notificationDto.getCreatedAt());
		notification.setMessage(notificationDto.getMessage());
		notification.setNotificationId(notificationDto.getNotificationId());
		notification.setSentAt(notificationDto.getSentAt());
		notification.setStatus(notificationDto.getStatus());
		notification.setUserId(notificationDto.getUserId());
		
		repository.saveAndFlush(notification);
		NotificationDto dto = mapper.map(notification, NotificationDto.class);
		return dto;
	}

	@Override
	public NotificationDto patchNotificationById(UUID notificationId, NotificationDto notificationDto) {
		Notification notification = mapper.map(notificationDto, Notification.class);
		
		notification.setCreatedAt(notificationDto.getCreatedAt());
		notification.setMessage(notificationDto.getMessage());
		notification.setSentAt(notificationDto.getSentAt());
		notification.setStatus(notificationDto.getStatus());
 
		repository.saveAndFlush(notification);
		NotificationDto dto = mapper.map(notification, NotificationDto.class);
		return dto;
	}

	@Override
	public Page<Notification> paginationNotification(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	
}
