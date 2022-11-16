package com.ssaffy.zipsee.user.model.service;

import java.util.Map;

import com.ssaffy.zipsee.user.model.UserDto;

public interface UserService {
	public boolean registerUser(UserDto userDto) throws Exception;
	public UserDto loginUser(Map<String, String> map) throws Exception;
	public void deleteUser(String userId) throws Exception;
	public UserDto getUser(String userId) throws Exception;
	public boolean modifyUser(UserDto user) throws Exception;
}
