package com.ssafy.zipsee.user.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.zipsee.user.model.UserInterestDto;

@Mapper
public interface UserInterestMapper {
	public int insertUserInterest(UserInterestDto userInterestDto) throws SQLException;
	public UserInterestDto getUserInterest(String userInterestId) throws SQLException;
	public int deleteUserInterest(String userInterestId) throws SQLException;
}
