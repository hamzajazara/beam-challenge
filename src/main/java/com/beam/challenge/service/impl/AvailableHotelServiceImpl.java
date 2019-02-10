package com.beam.challenge.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beam.challenge.model.request.AvailableHotelSearchRequest;
import com.beam.challenge.model.request.BestHotelSearchRequest;
import com.beam.challenge.model.request.CrazyHotelSearchRequest;
import com.beam.challenge.model.response.AvailableHotelResponse;
import com.beam.challenge.model.response.AvailableHotelSeachResponse;
import com.beam.challenge.model.response.BestHotelResponse;
import com.beam.challenge.model.response.BestHotelSearchResponse;
import com.beam.challenge.model.response.CrazyHotelResponse;
import com.beam.challenge.model.response.CrazyHotelSearchResponse;
import com.beam.challenge.provider.BestHotelProvider;
import com.beam.challenge.provider.CrazyHotelProvider;
import com.beam.challenge.service.AvailableHotelService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class AvailableHotelServiceImpl implements AvailableHotelService {

	@Autowired
	private BestHotelProvider bestHotelProvider;

	@Autowired
	private CrazyHotelProvider crazyHotelProvider;

	/*
	 * Search available hotel service
	 * 
	 * @see com.beam.challenge.service.AvailableHotelService#searchHotels(com.beam.
	 * challenge.model.request.AvailableHotelSearchRequest)
	 */
	@Override
	public AvailableHotelSeachResponse searchHotels(AvailableHotelSearchRequest hotelSearchRequest) {
		List<AvailableHotelResponse> availableHotelsSearchResponses = new ArrayList<>();

		// Best available hotels
		availableHotelsSearchResponses.addAll(searchBestHotels(hotelSearchRequest));

		// Crazy available hotels
		availableHotelsSearchResponses.addAll(searchCrazyHotels(hotelSearchRequest));

		Collections.sort(availableHotelsSearchResponses);
		return new AvailableHotelSeachResponse(availableHotelsSearchResponses);
	}

	/*
	 * @see
	 * com.beam.challenge.service.AvailableHotelService#searchCrazyHotels(com.beam.
	 * challenge.model.request.AvailableHotelSearchRequest)
	 */
	@Override
	public List<AvailableHotelResponse> searchCrazyHotels(AvailableHotelSearchRequest hotelSearchRequest) {
		List<AvailableHotelResponse> availableCrazyHotels = new ArrayList<>();
		CrazyHotelSearchRequest crazyHotelRequest = new CrazyHotelSearchRequest(hotelSearchRequest);
		CrazyHotelSearchResponse crazyHotels = crazyHotelProvider.searchHotels(crazyHotelRequest);

		if (crazyHotels == null) {
			return availableCrazyHotels;
		}
		for (CrazyHotelResponse crazyHotel : crazyHotels.getCrazyHotelResponses()) {
			availableCrazyHotels.add(new AvailableHotelResponse(crazyHotel));
		}

		return availableCrazyHotels;
	}

	/*
	 * @see
	 * com.beam.challenge.service.AvailableHotelService#searchBestHotels(com.beam.
	 * challenge.model.request.AvailableHotelSearchRequest)
	 */
	@Override
	public List<AvailableHotelResponse> searchBestHotels(AvailableHotelSearchRequest hotelSearchRequest) {
		List<AvailableHotelResponse> availableBestHotels = new ArrayList<>();
		BestHotelSearchRequest bestHotelRequest = new BestHotelSearchRequest(hotelSearchRequest);
		BestHotelSearchResponse bestHotels = bestHotelProvider.searchHotels(bestHotelRequest);

		if (bestHotels == null) {
			return availableBestHotels;
		}

		for (BestHotelResponse bestHotel : bestHotels.getBestHotelResponses()) {
			availableBestHotels.add(new AvailableHotelResponse(bestHotel));
		}
		return availableBestHotels;
	}
}
