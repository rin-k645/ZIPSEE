package com.ssafy.zipsee.user.model.service;

import java.util.Map;

import com.ssafy.zipsee.user.model.UserDto;

public interface UserService {
	public boolean registerUser(UserDto userDto) throws Exception;
	public boolean deleteUser(String userId) throws Exception;
	public UserDto getUser(String userId) throws Exception;
	public boolean modifyUser(UserDto user) throws Exception;
}
