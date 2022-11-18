package com.ssafy.zipsee.house.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.zipsee.house.model.HouseDealDto;

@Mapper
public interface HouseDealMapper {
	List<HouseDealDto> getHouseDealList(String dongCode) throws SQLException;
	HouseDealDto getHouseDeal(int dealId) throws SQLException;
	List<HouseDealDto> getHouseDealList2(Map<String, Object> map) throws SQLException; //필터로 검색
	List<HouseDealDto> getApartRecommandList(String dongCode) throws SQLException; //해당 동코드의 아파트 10개
	List<HouseDealDto> getOneRoomRecommandList(String dongCode) throws SQLException; //해당 동코드의 원룸 10개
}
