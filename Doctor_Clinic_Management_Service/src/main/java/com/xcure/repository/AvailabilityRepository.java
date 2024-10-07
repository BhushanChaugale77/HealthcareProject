package com.xcure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, UUID> {
	
    List<Availability> findByDoctor_DoctorId(UUID doctorId);


}
