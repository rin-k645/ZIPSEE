package com.ssafy.zipsee.user.model;

import com.ssafy.zipsee.house.model.HouseDealDto;

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
public class UserHouseDto {
	private int houseId;
	private String userId;
	private int dealId;
	
	HouseDealDto houseDeal;

	public UserHouseDto() {
		super();
	}

	public UserHouseDto(int houseId, String userId, int dealId, HouseDealDto houseDeal) {
		super();
		this.houseId = houseId;
		this.userId = userId;
		this.dealId = dealId;
		this.houseDeal = houseDeal;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public HouseDealDto getHouseDeal() {
		return houseDeal;
	}

	public void setHouseDeal(HouseDealDto houseDeal) {
		this.houseDeal = houseDeal;
	}

	@Override
	public String toString() {
		return "UserHouseDto [houseId=" + houseId + ", userId=" + userId + ", dealId=" + dealId + ", houseDeal="
				+ houseDeal + "]";
	}
	
}
