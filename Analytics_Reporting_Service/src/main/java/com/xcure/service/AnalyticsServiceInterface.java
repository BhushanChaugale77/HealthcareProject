package com.xcure.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.xcure.dto.AnalyticsDto;
import com.xcure.entity.Analytics;

public interface AnalyticsServiceInterface {

	
	Analytics getAnalyticsData(UUID id);
	
	List<Analytics> getAllAnalytics();
	
	AnalyticsDto genrateAnalyticsReport(AnalyticsDto analyticsDto);
	
	void deleteAnalyticsReport(UUID id);
	
	AnalyticsDto updateReport(UUID id, AnalyticsDto analyticsDto);
	
	AnalyticsDto patchAnalytics(UUID id, AnalyticsDto analyticsDto);
	
	Page<Analytics> paginationAnalyticsPage(int page, int size); 
	
}
