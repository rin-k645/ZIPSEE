package com.ssafy.zipsee.house.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseDealDto {
	private int dealId;
	private int houseId;
	private int area;
	private int floor;
	private String dealType;
	private int price;
	
	private HouseInfoDto houseInfo;
	
//	public HouseDealDto() {
//		super();
//	}
//
//	public HouseDealDto(int dealId, int houseId, int area, int floor, String dealType, int price,
//			HouseInfoDto houseInfo) {
//		super();
//		this.dealId = dealId;
//		this.houseId = houseId;
//		this.area = area;
//		this.floor = floor;
//		this.dealType = dealType;
//		this.price = price;
//		this.houseInfo = houseInfo;
//	}
//
//	public int getDealId() {
//		return dealId;
//	}
//
//	public void setDealId(int dealId) {
//		this.dealId = dealId;
//	}
//
//	public int getHouseId() {
//		return houseId;
//	}
//
//	public void setHouseId(int houseId) {
//		this.houseId = houseId;
//	}
//
//	public int getArea() {
//		return area;
//	}
//
//	public void setArea(int area) {
//		this.area = area;
//	}
//
//	public int getFloor() {
//		return floor;
//	}
//
//	public void setFloor(int floor) {
//		this.floor = floor;
//	}
//
//	public String getDealType() {
//		return dealType;
//	}
//
//	public void setDealType(String dealType) {
//		this.dealType = dealType;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public HouseInfoDto getHouseInfo() {
//		return houseInfo;
//	}
//
//	public void setHouseInfo(HouseInfoDto houseInfo) {
//		this.houseInfo = houseInfo;
//	}
//
//	@Override
//	public String toString() {
//		return "HouseDealDto [dealId=" + dealId + ", houseId=" + houseId + ", area=" + area + ", floor=" + floor
//				+ ", dealType=" + dealType + ", price=" + price + ", houseInfo=" + houseInfo + "]";
//	}

}
