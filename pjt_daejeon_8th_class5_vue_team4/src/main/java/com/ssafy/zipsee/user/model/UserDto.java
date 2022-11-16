package com.ssafy.zipsee.user.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class UserDto {
	private String userId;
	private String password;
	private String nickName;
	private String name;
	private String email;
	private String phone;
	private String sex;
	private String registerDate;
	
	private List<UserInterestDto> interestList;
	private List<UserDongDto> dongList;
	private List<UserHouseDto> likeList;
	
	public UserDto() {
		super();
	}

	public UserDto(String userId, String password, String nickName, String name, String email, String phone, String sex,
			String registerDate, List<UserInterestDto> interestList, List<UserDongDto> dongList,
			List<UserHouseDto> likeList) {
		super();
		this.userId = userId;
		this.password = password;
		this.nickName = nickName;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.registerDate = registerDate;
		this.interestList = interestList;
		this.dongList = dongList;
		this.likeList = likeList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public List<UserInterestDto> getInterestList() {
		return interestList;
	}

	public void setInterestList(List<UserInterestDto> interestList) {
		this.interestList = interestList;
	}

	public List<UserDongDto> getDongList() {
		return dongList;
	}

	public void setDongList(List<UserDongDto> dongList) {
		this.dongList = dongList;
	}

	public List<UserHouseDto> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<UserHouseDto> likeList) {
		this.likeList = likeList;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", password=" + password + ", nickName=" + nickName + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", sex=" + sex + ", registerDate=" + registerDate
				+ ", interestList=" + interestList + ", dongList=" + dongList + ", likeList=" + likeList + "]";
	}
	
}
