package com.xcure.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.dto.AnalyticsDto;
import com.xcure.entity.Analytics;
import com.xcure.repository.AnalyticsRepository;
import com.xcure.service.AnalyticsServiceInterface;

@Service
public class AnalyticsServiceImpl implements AnalyticsServiceInterface {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AnalyticsRepository repository;

	@Override
	public Analytics getAnalyticsData(UUID id) {
 		return repository.findById(id).orElseThrow();
	}

	@Override
	public List<Analytics> getAllAnalytics() {
 		return repository.findAll();
	}

	@Override
	public AnalyticsDto genrateAnalyticsReport(AnalyticsDto analyticsDto) {
		Analytics analytics = mapper.map(analyticsDto, Analytics.class);
		repository.save(analytics);
		AnalyticsDto dto = mapper.map(analytics, AnalyticsDto.class);
		return dto ;
	}

	@Override
	public void deleteAnalyticsReport(UUID id) {
		repository.deleteById(id);
	}

	@Override
	public AnalyticsDto updateReport(UUID id, AnalyticsDto analyticsDto) {
		Analytics analytics = mapper.map(analyticsDto, Analytics.class);
		
		analytics.setAmount(analyticsDto.getAmount());
		analytics.setDetails(analyticsDto.getDetails());
		analytics.setEntityId(analyticsDto.getEntityId());
		analytics.setEventTimeStamp(analyticsDto.getEventTimeStamp());
		analytics.setEventType(analyticsDto.getEventType());
		analytics.setId(analyticsDto.getId());
		
		AnalyticsDto dto = mapper.map(analytics, AnalyticsDto.class);
		return dto;
	}

	@Override
	public AnalyticsDto patchAnalytics(UUID id, AnalyticsDto analyticsDto) {
		Analytics analytics = mapper.map(analyticsDto, Analytics.class);

		analytics.setAmount(analyticsDto.getAmount());
		analytics.setDetails(analyticsDto.getDetails());analytics.setAmount(analyticsDto.getAmount());
		analytics.setEventType(analyticsDto.getEventType());
		analytics.setId(analyticsDto.getId());
		
		AnalyticsDto dto = mapper.map(analytics, AnalyticsDto.class);
		return dto;
	}

	@Override
	public Page<Analytics> paginationAnalyticsPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
}
