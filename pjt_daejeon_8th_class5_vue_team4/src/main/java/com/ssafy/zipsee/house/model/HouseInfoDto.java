package com.ssafy.zipsee.house.model;

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
public class HouseInfoDto {
	private int houseId;
	private String houseName;
	private String houseType;
	private String dongCode;
	private String dongName;
	private int BuildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	
	DongDto dong;
	List<HouseDealDto> dealList;
	public HouseInfoDto() {
		super();
	}

	public HouseInfoDto(int houseId, String houseName, String houseType, String dongCode, String dongName,
			int buildYear, String jibun, String lat, String lng, String img, DongDto dong,
			List<HouseDealDto> dealList) {
		super();
		this.houseId = houseId;
		this.houseName = houseName;
		this.houseType = houseType;
		this.dongCode = dongCode;
		this.dongName = dongName;
		BuildYear = buildYear;
		this.jibun = jibun;
		this.lat = lat;
		this.lng = lng;
		this.img = img;
		this.dong = dong;
		this.dealList = dealList;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public int getBuildYear() {
		return BuildYear;
	}

	public void setBuildYear(int buildYear) {
		BuildYear = buildYear;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public DongDto getDong() {
		return dong;
	}

	public void setDong(DongDto dong) {
		this.dong = dong;
	}

	public List<HouseDealDto> getDealList() {
		return dealList;
	}

	public void setDealList(List<HouseDealDto> dealList) {
		this.dealList = dealList;
	}

	@Override
	public String toString() {
		return "HouseInfo [houseId=" + houseId + ", houseName=" + houseName + ", houseType=" + houseType + ", dongCode="
				+ dongCode + ", dongName=" + dongName + ", BuildYear=" + BuildYear + ", jibun=" + jibun + ", lat=" + lat
				+ ", lng=" + lng + ", img=" + img + ", dong=" + dong + ", dealList=" + dealList + "]";
	}
	
}
