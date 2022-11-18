package com.ssafy.zipsee.house.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.zipsee.house.model.HouseDealDto;
import com.ssafy.zipsee.user.model.UserDto;

public interface HouseDealService {
	List<HouseDealDto> getHouseDealList(String dongCode) throws Exception;
	HouseDealDto getHouseDeal(int dealId) throws Exception;
	List<HouseDealDto> getHouseDealList2(Map<String, Object> map) throws Exception;
	List<HouseDealDto> getApartRecommandList(String dongCode) throws Exception;
	List<HouseDealDto> getOneRoomRecommandList(String dongCode) throws Exception;
	List<HouseDealDto> getPopularDealList() throws Exception;
}
