package com.xcure.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xcure.dto.ConsultationDto;
import com.xcure.entity.Consultation;

public interface ConsultationInterfaceService {

	
	Consultation findConsultationById(Integer consultationid);
	
	List<Consultation> allConsultation();
	
	ConsultationDto createConsultation(ConsultationDto consultationDto);
	
	void deleteConsultationById(Integer consultationid);
	
	ConsultationDto updateConsultationDto(Integer consultationid, ConsultationDto consultationDto);
	
	ConsultationDto patchConsultationDto(Integer consultationid, ConsultationDto consultationDto);
	
	Page<Consultation> paginationConsultation(int page, int size);
	
}
