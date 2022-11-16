package com.ssafy.zipsee.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.zipsee.house.model.HouseDealDto;
import com.ssafy.zipsee.house.model.service.HouseDealService;

@RestController
@RequestMapping("/deal")
public class HouseRestController {
	private HouseDealService houseDealService;

	@Autowired
	public HouseRestController(HouseDealService houseDealService) {
		super();
		this.houseDealService = houseDealService;
	}

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
	
	@GetMapping("/{dealid}")
	public ResponseEntity<?> viewHouseDeal(@PathVariable("dealid") String dealId) {
		return null;
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
