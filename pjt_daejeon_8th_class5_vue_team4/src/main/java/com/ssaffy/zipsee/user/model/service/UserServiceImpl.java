package com.ssaffy.zipsee.user.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssaffy.zipsee.user.model.UserDto;
import com.ssaffy.zipsee.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public boolean registerUser(UserDto userDto) throws Exception {
		if(userMapper.registerUser(userDto) == 1) 
			return true;
		return false;
	}
	
	@Override
	public UserDto loginUser(Map<String, String> map) throws Exception {
		return userMapper.loginUser(map);
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		userMapper.deleteUser(userId);
	}

	@Override
	public UserDto getUser(String userId) throws Exception {
		return userMapper.getUser(userId);
	}

	@Override
	public boolean modifyUser(UserDto userDto) throws Exception {
		if(userMapper.modifyUser(userDto) == 1)
			return true;
		return false;
	}
}
