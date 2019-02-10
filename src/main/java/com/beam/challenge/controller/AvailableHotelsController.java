package com.beam.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beam.challenge.model.request.AvailableHotelSearchRequest;
import com.beam.challenge.model.response.AvailableHotelSeachResponse;
import com.beam.challenge.service.AvailableHotelService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController
@RequestMapping("hotel/available")
public class AvailableHotelsController {

	@Autowired
	private AvailableHotelService availableHotelsService;

	/**
	 * 
	 * @param hotelSearchRequest
	 * @return
	 */
	@PostMapping("/search")
	public ResponseEntity<AvailableHotelSeachResponse> searchAvailableHotels(
			@Valid @RequestBody AvailableHotelSearchRequest hotelSearchRequest) {
		return new ResponseEntity<>(availableHotelsService.searchHotels(hotelSearchRequest), HttpStatus.OK);
	}
}
