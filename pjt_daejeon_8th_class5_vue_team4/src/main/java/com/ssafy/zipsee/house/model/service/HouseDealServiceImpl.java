package com.ssafy.zipsee.house.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.zipsee.house.model.DongDto;
import com.ssafy.zipsee.house.model.HouseDealDto;
import com.ssafy.zipsee.house.model.HouseInfoDto;
import com.ssafy.zipsee.house.model.mapper.DongMapper;
import com.ssafy.zipsee.house.model.mapper.HouseDealMapper;
import com.ssafy.zipsee.house.model.mapper.HouseInfoMapper;
import com.ssafy.zipsee.user.model.UserDealDto;
import com.ssafy.zipsee.user.model.mapper.UserDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	@Autowired
	private HouseDealMapper houseDealMapper;
	@Autowired
	private UserDealMapper userHouseMapper;
	@Autowired
	private HouseInfoMapper houseInfoMapper;

	public HouseDealServiceImpl(HouseDealMapper houseDealMapper, UserDealMapper userHouseMapper,
			HouseInfoMapper houseInfoMapper) {
		super();
		this.houseDealMapper = houseDealMapper;
		this.userHouseMapper = userHouseMapper;
		this.houseInfoMapper = houseInfoMapper;
	}

	@Override
	public List<HouseDealDto> getHouseDealList(String dongCode) throws Exception {
		List<HouseDealDto> dealList = houseDealMapper.getHouseDealList(dongCode);
		for(HouseDealDto houseDeal : dealList) {
			HouseInfoDto houseInfo = houseInfoMapper.getHouseInfo(houseDeal.getHouseId());
			houseDeal.setHouseInfo(houseInfo);
		}
		
		return dealList;
	}

	@Override
	public HouseDealDto getHouseDeal(int dealId) throws Exception {
		HouseDealDto houseDeal = houseDealMapper.getHouseDeal(dealId);
		HouseInfoDto houseInfo = houseInfoMapper.getHouseInfo(houseDeal.getHouseId());
		houseDeal.setHouseInfo(houseInfo);
		
		return houseDeal;
	}

	@Override
	public List<HouseDealDto> getHouseDealListByFilter(Map<String, Object> map) throws Exception {
		List<HouseDealDto> result = new ArrayList<>();
		
		//맵
		String dongCode = (String) map.get("dongCode");
		
		//주택유형 <String, List<String>
		List<String> houseTypeList = (List<String>) map.get("houseTypeList");
		
		if(houseTypeList != null) {
			for(String houseType : houseTypeList) {
				List<HouseDealDto> houseDealList = houseDealMapper.getHouseDealListByHouseType(dongCode, houseType);
				result.addAll(houseDealList);
			}
		}
		
		//거래유형 <String, List<String>
		List<String> dealTypeList = (List<String>) map.get("dealTypeList");
		
		if(dealTypeList != null) {
			for(String dealType : dealTypeList) {
				List<HouseDealDto> houseDealList = houseDealMapper.getHouseDealListByDealType(dongCode, dealType);
				result.addAll(houseDealList);
			}
		}
		
		System.out.println(result);
		
		//최소가격, 최대가격
		
		
		return result;
	}

	@Override
	public List<HouseDealDto> getApartRecommandList(String dongCode) throws Exception {
		List<HouseDealDto> dealList = houseDealMapper.getApartRecommandList(dongCode);
		for(HouseDealDto houseDeal : dealList) {
			HouseInfoDto houseInfo = houseInfoMapper.getHouseInfo(houseDeal.getHouseId());
			houseDeal.setHouseInfo(houseInfo);
		}
		
		return dealList;
	}

	@Override
	public List<HouseDealDto> getOneRoomRecommandList(String dongCode) throws Exception {
		List<HouseDealDto> dealList = houseDealMapper.getOneRoomRecommandList(dongCode);
		for(HouseDealDto houseDeal : dealList) {
			HouseInfoDto houseInfo = houseInfoMapper.getHouseInfo(houseDeal.getHouseId());
			houseDeal.setHouseInfo(houseInfo);
		}
		
		return dealList;
	}

	@Override
	public List<HouseDealDto> getPopularDealList() throws Exception {
		List<HouseDealDto> dealList = houseDealMapper.getPopularDealList();
		for(HouseDealDto houseDeal : dealList) {
			HouseInfoDto houseInfo = houseInfoMapper.getHouseInfo(houseDeal.getHouseId());
			houseDeal.setHouseInfo(houseInfo);
		}
		
		return dealList;
	}

	@Override
	@Transactional
	public boolean likeHouse(UserDealDto userHouseDto) throws Exception {
		if(userHouseMapper.insertUserHouse(userHouseDto) == 1) {
			houseDealMapper.increaseLike(userHouseDto.getDealId());
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean unlikeHouse(String userId, int dealId) throws Exception {
		if(userHouseMapper.deleteUserDeal(userId, dealId) == 1) {
			houseDealMapper.decreaseLike(dealId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public HouseInfoDto getHouseInfo(int houseId) throws Exception {
		return houseInfoMapper.getHouseInfo(houseId);
	}

}
