package com.ssafy.zipsee.user.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.zipsee.user.model.UserDongDto;

@Mapper
public interface UserDongMapper {
	public int insertUserDong(UserDongDto userDongDto) throws SQLException;
	public UserDongDto getUserDong(String userDongId) throws SQLException;
	public int deleteUserDong(String userId) throws SQLException;
}
