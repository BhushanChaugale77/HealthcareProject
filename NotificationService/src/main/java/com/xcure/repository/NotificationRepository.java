package com.xcure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

}
