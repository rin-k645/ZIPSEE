package com.ssafy.zipsee.user.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.zipsee.user.model.UserDealDto;

@Mapper
public interface UserDealMapper {
	public int insertUserHouse(UserDealDto userHouseDto) throws SQLException;
	public List<UserDealDto> getUserHouseList(String userId) throws SQLException;
	public int deleteUserHouse(String userId, int dealId) throws SQLException;
}
