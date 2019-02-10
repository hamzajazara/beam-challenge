package com.beam.challenge.model.response;

import java.util.ArrayList;
import java.util.List;

import com.beam.challenge.model.BestHotel;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Setter
@Getter
public class BestHotelResponse extends HotelResponse {

	private int rate;
	
	private double fare;
	
	private String amenities;

	public BestHotelResponse(String hotelName) {
		super(hotelName);
	}

	/**
	 * 
	 * @param hotelEntity
	 */
	public BestHotelResponse(BestHotel hotelEntity) {
		this(hotelEntity.getName());
		rate = hotelEntity.getRate();
		fare = hotelEntity.getFare() != 0 ? Math.round(hotelEntity.getFare() * 100) / 100 : 0;
		List<String> amenitiesResult = new ArrayList<>();

		// Retrieve room info
		hotelEntity.getBestRooms().forEach(room -> {
			room.getAmenities().forEach(amenity -> {
				amenitiesResult.add(amenity);
			});
		});
		amenities = String.join(", ", amenitiesResult);
	}
}
