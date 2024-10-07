package com.xcure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Analytics;

public interface AnalyticsRepository extends JpaRepository<Analytics, UUID> {

}
