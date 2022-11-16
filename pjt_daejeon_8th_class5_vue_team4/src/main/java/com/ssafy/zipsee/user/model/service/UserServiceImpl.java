package com.ssafy.zipsee.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.zipsee.user.model.UserDto;
import com.ssafy.zipsee.user.model.mapper.UserMapper;

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
	public boolean deleteUser(String userId) throws Exception {
		if(userMapper.deleteUser(userId) == 1) 
			return true;
		return false;
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
