package com.xcure.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.xcure.dto.NotificationDto;
import com.xcure.entity.Notification;

public interface NotificationServiceInterface {

	
	Notification findNotiicationById(UUID notificationId);
	
	List<Notification> allNotification();
	
	NotificationDto createNotification(NotificationDto notificationDto);
	
	void deleteNotificationById(UUID notificationId);
	
	NotificationDto updateNotiicationById(UUID notificationId, NotificationDto notificationDto);
	
	NotificationDto patchNotificationById(UUID notificationId, NotificationDto notificationDto);
	
	Page<Notification> paginationNotification(int page, int size);
}
