package com.xcure.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.xcure.dto.ConsultationDto;
import com.xcure.entity.Consultation;
import com.xcure.repository.ConsultationRepository;
import com.xcure.service.ConsultationInterfaceService;

@Service
public class ConsultationServiceImpl implements ConsultationInterfaceService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ConsultationRepository repository;

	@Override
	public Consultation findConsultationById(Integer consultationid) {
 		return repository.findById(consultationid).orElseThrow();
	}

	@Override
	public List<Consultation> allConsultation() {
 		return repository.findAll();
	}

	@Override
	public ConsultationDto createConsultation(ConsultationDto consultationDto) {
		Consultation consultation = mapper.map(consultationDto, Consultation.class);
		repository.save(consultation);
		ConsultationDto dto = mapper.map(consultation, ConsultationDto.class);
		return dto;
	}

	@Override
	public void deleteConsultationById(@PathVariable Integer consultationid) {
		repository.deleteById(consultationid);
	}

	@Override
	public ConsultationDto updateConsultationDto(Integer consultationid, ConsultationDto consultationDto) {
		Consultation consultation = mapper.map(consultationDto, Consultation.class);
		
		consultation.setAppointmentid(consultationDto.getAppointmentid());
		consultation.setConsultationid(consultationDto.getConsultationid());
		consultation.setDoctorid(consultationDto.getDoctorid());
		consultation.setPationtid(consultationDto.getPationtid());
		consultation.setStatus(consultationDto.getStatus());
		
		repository.saveAndFlush(consultation);
		
		ConsultationDto dto = mapper.map(consultation, ConsultationDto.class);
		return dto;
	}

	@Override
	public ConsultationDto patchConsultationDto(Integer consultationid, ConsultationDto consultationDto) {
		Consultation consultation = mapper.map(consultationDto, Consultation.class);
		
		consultation.setAppointmentid(consultationDto.getAppointmentid());
		consultation.setStatus(consultationDto.getStatus());

		
		repository.flush();
		
		ConsultationDto dto = mapper.map(consultation, ConsultationDto.class);
		return dto;
	}

	@Override
	public Page<Consultation> paginationConsultation(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);		
		return repository.findAll(pageable);
	}

	
	
	
}
