package com.xcure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, UUID>{

    Clinic findByClinicName(String clinicName);

}
