package com.ssafy.zipsee.user.model;

import com.ssafy.zipsee.house.model.DongDto;

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
public class UserDongDto {
	private int userDongId;
	private String userId;
	private String dongCode;
	
	private DongDto dong;

	public UserDongDto() {
		super();
	}

	public UserDongDto(int userDongId, String userId, String dongCode, DongDto dong) {
		super();
		this.userDongId = userDongId;
		this.userId = userId;
		this.dongCode = dongCode;
		this.dong = dong;
	}

	public int getUserDongId() {
		return userDongId;
	}

	public void setUserDongId(int userDongId) {
		this.userDongId = userDongId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public DongDto getDong() {
		return dong;
	}

	public void setDong(DongDto dong) {
		this.dong = dong;
	}

	@Override
	public String toString() {
		return "UserDongDto [userDongId=" + userDongId + ", userId=" + userId + ", dongCode=" + dongCode + ", dong="
				+ dong + "]";
	}
	
}
