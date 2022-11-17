package com.ssafy.zipsee.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.zipsee.user.model.UserDongDto;
import com.ssafy.zipsee.user.model.UserDto;
import com.ssafy.zipsee.user.model.UserInterestDto;
import com.ssafy.zipsee.user.model.mapper.UserDongMapper;
import com.ssafy.zipsee.user.model.mapper.UserInterestMapper;
import com.ssafy.zipsee.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInterestMapper userInterestMapper;
	@Autowired
	private UserDongMapper userDongMapper;

	public UserServiceImpl(UserMapper userMapper, UserInterestMapper userInterestMapper) {
		super();
		this.userMapper = userMapper;
		this.userInterestMapper = userInterestMapper;
	}

	@Override
	@Transactional
	public boolean registerUser(UserDto userDto) throws Exception {
		if(userMapper.registerUser(userDto) == 1) {
			//관심사 저장
			List<UserInterestDto> interestList = userDto.getInterestList();
			if(interestList != null && !interestList.isEmpty()) {
				userMapper.registerUserInterest(userDto);
			}
			
			//관심 지역 저장
			List<UserDongDto> dongList = userDto.getDongList();
			if(dongList != null && !dongList.isEmpty()) {
				userMapper.registerUserDong(userDto);
			}
			
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		if(userMapper.deleteUser(userId) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserDto getUser(String userId) throws Exception {
		return userMapper.getUser(userId);
	}

	@Override
	@Transactional
	public boolean modifyUser(UserDto userDto) throws Exception {
		if(userMapper.modifyUser(userDto) == 1) {
			//관심사 기존 것 삭제하고
			userInterestMapper.deleteUserInterest(userDto.getUserId());
			//새로 저장하기
			List<UserInterestDto> interestList = userDto.getInterestList();
			if(interestList != null && !interestList.isEmpty()) {
				userMapper.registerUserInterest(userDto);
			}
			
			//관심 지역 기존 것 삭제하고
			userDongMapper.deleteUserDong(userDto.getUserId());
			//새로 저장하기
			List<UserDongDto> dongList = userDto.getDongList();
			if(dongList != null && !dongList.isEmpty()) {
				userMapper.registerUserDong(userDto);
			}
			
			return true;
		}else {
			return false;
		}
	}

	@Override
	public UserDto login(UserDto userDto) throws SQLException {
		return userMapper.login(userDto);
	}

	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		userMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return userMapper.getRefreshToken(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		userMapper.deleteRefreshToken(map);
	}

}
