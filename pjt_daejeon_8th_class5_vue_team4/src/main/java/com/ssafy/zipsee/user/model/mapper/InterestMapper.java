package com.ssafy.zipsee.user.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.zipsee.user.model.InterestDto;

@Mapper
public interface InterestMapper {
	public InterestDto getInterest(String interestId) throws SQLException;
}
