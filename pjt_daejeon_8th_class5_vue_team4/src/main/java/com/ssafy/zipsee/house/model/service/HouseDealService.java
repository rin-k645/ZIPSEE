package com.ssafy.zipsee.house.model.service;

import java.util.List;

import com.ssafy.zipsee.house.model.HouseDealDto;

public interface HouseDealService {
	List<HouseDealDto> getHouseDealList(String dongCode) throws Exception;
	HouseDealDto getHouseDeal(int dealId) throws Exception;
}
