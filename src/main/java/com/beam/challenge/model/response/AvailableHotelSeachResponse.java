package com.beam.challenge.model.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@AllArgsConstructor
@Setter
@Getter
public class AvailableHotelSeachResponse {

	private List<AvailableHotelResponse> availableHotelResponses;

	public AvailableHotelSeachResponse() {
		this.availableHotelResponses = new ArrayList<>();
	}
}
