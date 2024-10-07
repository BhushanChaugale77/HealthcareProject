package com.xcure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
