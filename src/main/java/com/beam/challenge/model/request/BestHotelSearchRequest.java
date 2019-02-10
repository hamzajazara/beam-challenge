package com.beam.challenge.model.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class BestHotelSearchRequest {

	private String city;

	private LocalDate fromDate;

	private LocalDate toDate;

	private int numOfAdults;

	public BestHotelSearchRequest(AvailableHotelSearchRequest hotelSearchRequest) {
		city = hotelSearchRequest.getCity();
		fromDate = hotelSearchRequest.getFromDate();
		toDate = hotelSearchRequest.getToDate();
		numOfAdults = hotelSearchRequest.getNumOfAdults();
	}
}
