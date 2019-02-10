package com.beam.challenge.service;

import java.util.List;

import com.beam.challenge.model.request.AvailableHotelSearchRequest;
import com.beam.challenge.model.response.AvailableHotelResponse;
import com.beam.challenge.model.response.AvailableHotelSeachResponse;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface AvailableHotelService {

	/**
	 * 
	 * @param hotelSearchRequest
	 * @return
	 */
	AvailableHotelSeachResponse searchHotels(AvailableHotelSearchRequest hotelSearchRequest);

	/**
	 * 
	 * @param hotelSearchRequest
	 * @return
	 */
	List<AvailableHotelResponse> searchCrazyHotels(AvailableHotelSearchRequest hotelSearchRequest);

	/**
	 * 
	 * @param hotelSearchRequest
	 * @return
	 */
	List<AvailableHotelResponse> searchBestHotels(AvailableHotelSearchRequest hotelSearchRequest);
}
