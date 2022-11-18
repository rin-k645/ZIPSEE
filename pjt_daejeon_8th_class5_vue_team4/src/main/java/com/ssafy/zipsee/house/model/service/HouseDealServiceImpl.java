package com.ssafy.zipsee.house.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.zipsee.house.model.HouseDealDto;
import com.ssafy.zipsee.house.model.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	@Autowired
	private HouseDealMapper houseDealMapper;

	@Autowired
	public HouseDealServiceImpl(HouseDealMapper houseDealMapper) {
		super();
		this.houseDealMapper = houseDealMapper;
	}
	
	@Override
	public List<HouseDealDto> getHouseDealList(String dongCode) throws Exception {
		return houseDealMapper.getHouseDealList(dongCode);
	}

	@Override
	public HouseDealDto getHouseDeal(int dealId) throws Exception {
		return houseDealMapper.getHouseDeal(dealId);
	}

	@Override
	public List<HouseDealDto> getHouseDealList2(Map<String, Object> map) throws Exception {
		return houseDealMapper.getHouseDealList2(map);
	}

	@Override
	public List<HouseDealDto> getApartRecommandList(String dongCode) throws Exception {
		return houseDealMapper.getApartRecommandList(dongCode);
	}

	@Override
	public List<HouseDealDto> getOneRoomRecommandList(String dongCode) throws Exception {
		return houseDealMapper.getOneRoomRecommandList(dongCode);
	}

	@Override
	public List<HouseDealDto> getPopularDealList() throws Exception {
		return houseDealMapper.getPopularDealList();
	}

}
