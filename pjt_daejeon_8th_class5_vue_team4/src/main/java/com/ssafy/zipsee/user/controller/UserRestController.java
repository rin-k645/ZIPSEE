package com.ssafy.zipsee.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.zipsee.user.model.UserDto;
import com.ssafy.zipsee.user.model.service.UserService;


@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public String register(@RequestBody UserDto userDto) throws Exception {
		if(userService.registerUser(userDto))
			return "회원 가입 성공";
		return "회원 가입 실패";
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> view(@PathVariable("userid") String userId) {
		return null;
	}
	
	@PutMapping
	public String modify(@RequestBody UserDto userDto) throws Exception {
		if(userService.modifyUser(userDto))
			return "회원 정보 수정 성공";
		return "회원 정보 수정 실패";
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) {
		return null;
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
