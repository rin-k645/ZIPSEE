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
	List<HouseDealDto> getHouseDealListByHouseType(String dongCode, String houseType) throws SQLException; //필터 검색-집 유형
	List<HouseDealDto> getHouseDealListByDealType(String dongCode, String dealType) throws SQLException; //필터 검색-거래 유형
	
	List<HouseDealDto> getApartRecommandList(String dongCode) throws SQLException; //해당 동코드의 아파트 10개
	List<HouseDealDto> getOneRoomRecommandList(String dongCode) throws SQLException; //해당 동코드의 원룸 10개
	List<HouseDealDto> getPopularDealList() throws SQLException; //실시간 top10
	
	int increaseLike(int dealId) throws SQLException;
	int decreaseLike(int dealId) throws SQLException;
}
