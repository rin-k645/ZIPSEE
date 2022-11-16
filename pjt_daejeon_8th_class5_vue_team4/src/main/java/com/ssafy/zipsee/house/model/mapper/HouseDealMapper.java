package com.ssafy.zipsee.house.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.zipsee.house.model.HouseDealDto;

@Mapper
public interface HouseDealMapper {
	List<HouseDealDto> getHouseDealList(String dongCode) throws SQLException;
	HouseDealDto getHouseDeal(int dealId) throws SQLException;
}
