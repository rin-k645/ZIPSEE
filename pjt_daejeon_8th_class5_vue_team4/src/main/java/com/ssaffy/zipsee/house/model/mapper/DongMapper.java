package com.ssaffy.zipsee.house.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssaffy.zipsee.house.model.DongDto;

@Mapper
public interface DongMapper {
	public DongDto getDong(String dongCode) throws SQLException;
}
