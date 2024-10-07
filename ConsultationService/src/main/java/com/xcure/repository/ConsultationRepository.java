package com.xcure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

}
