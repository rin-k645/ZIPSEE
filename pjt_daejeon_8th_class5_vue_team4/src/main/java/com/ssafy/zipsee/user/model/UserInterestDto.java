package com.ssafy.zipsee.user.model;

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
public class UserInterestDto {
	private int userInterestId;
	private String userId;
	private int interestId;
	
	InterestDto interest;

	public UserInterestDto() {
		super();
	}

	public UserInterestDto(int userInterestId, String userId, int interestId, InterestDto interest) {
		super();
		this.userInterestId = userInterestId;
		this.userId = userId;
		this.interestId = interestId;
		this.interest = interest;
	}

	public int getUserInterestId() {
		return userInterestId;
	}

	public void setUserInterestId(int userInterestId) {
		this.userInterestId = userInterestId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getInterestId() {
		return interestId;
	}

	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}

	public InterestDto getInterest() {
		return interest;
	}

	public void setInterest(InterestDto interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "UserInterestDto [userInterestId=" + userInterestId + ", userId=" + userId + ", interestId=" + interestId
				+ ", interest=" + interest + "]";
	}
	
}
