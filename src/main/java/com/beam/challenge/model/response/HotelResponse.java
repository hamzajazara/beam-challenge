package com.beam.challenge.model.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Setter
@Getter
public class HotelResponse {

	private String hotelName;

	/**
	 * 
	 * @param hotelName
	 */
	public HotelResponse(String hotelName) {
		this.hotelName = hotelName;
	}
}
