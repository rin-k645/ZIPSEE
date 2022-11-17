package com.ssafy.zipsee.house.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.zipsee.house.model.HouseDealDto;
import com.ssafy.zipsee.house.model.service.HouseDealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/deal")
@Api("매물 정보 컨트롤러  API")
public class HouseRestController {
	private HouseDealService houseDealService;

	@Autowired
	public HouseRestController(HouseDealService houseDealService) {
		super();
		this.houseDealService = houseDealService;
	}

	@ApiOperation(value = "매물 검색", notes = "동코드 조건에 맞는 매물을 검색해 반환한다", response = List.class)
	@GetMapping
	public ResponseEntity<?> list(@RequestParam String dongCode) {
		try {
			List<HouseDealDto> list = houseDealService.getHouseDealList(dongCode);
			if (list != null && !list.isEmpty()) {
				System.out.println(list);
				return new ResponseEntity<List<HouseDealDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
//	@ApiOperation(value = "매물 검색", notes = "필터 조건(동코드, 집유형, 거래타입, 면적)에 맞는 매물을 검색해 반환한다", response = List.class)
//	@GetMapping
//	public ResponseEntity<?> list2(@RequestParam Map<String, Object> map) {
//		try {
//			List<HouseDealDto> list = houseDealService.getHouseDealList2(map);
//			if (list != null && !list.isEmpty()) {
//				System.out.println(list);
//				return new ResponseEntity<List<HouseDealDto>>(list, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			}
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	
	@ApiOperation(value = "매물 보기", notes = "매물 id에 해당하는 매물을 반환한다", response = List.class)
	@GetMapping("/{dealid}")
	public ResponseEntity<?> viewHouseDeal(@PathVariable("dealid") int dealId) throws Exception {
		return new ResponseEntity<HouseDealDto>(houseDealService.getHouseDeal(dealId), HttpStatus.OK);
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
