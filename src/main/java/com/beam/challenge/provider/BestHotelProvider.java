package com.beam.challenge.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.beam.challenge.model.request.BestHotelSearchRequest;
import com.beam.challenge.model.response.BestHotelSearchResponse;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@FeignClient(name = "best-hotel-provider", url = "/external-link/best-hotel")
public interface BestHotelProvider {

	/**
	 * 
	 * @param hotelRequest
	 * @return
	 */
	@PostMapping("/search")
	BestHotelSearchResponse searchHotels(BestHotelSearchRequest hotelRequest);
}
