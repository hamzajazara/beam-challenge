package com.beam.challenge.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.beam.challenge.model.request.CrazyHotelSearchRequest;
import com.beam.challenge.model.response.CrazyHotelSearchResponse;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@FeignClient(name = "crazy-hotel-provider", url = "/external-link/crazy-hotel")
public interface CrazyHotelProvider {

	/**
	 * 
	 * @param hotelRequest
	 * @return
	 */
	@PostMapping("/search")
	CrazyHotelSearchResponse searchHotels(CrazyHotelSearchRequest hotelRequest);
}
