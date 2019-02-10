package com.beam.challenge.model.response;

import java.util.ArrayList;
import java.util.List;

import com.beam.challenge.model.CrazyHotel;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Setter
@Getter
public class CrazyHotelResponse extends HotelResponse {

	private String rate;

	private double price;

	private double discount;

	private List<String> amenities;

	public CrazyHotelResponse(String hotelName) {
		super(hotelName);
	}

	/**
	 * 
	 * @param hotelEntity
	 */
	public CrazyHotelResponse(CrazyHotel hotelEntity) {
		this(hotelEntity.getName());
		rate = hotelEntity.getRate();
		price = hotelEntity.getPrice();
		amenities = new ArrayList<>();

		// Retrieve room info
		hotelEntity.getCrazyRooms().forEach(room -> {
			for (String amenity : room.getAmenities()) {
				amenities.add(amenity);

				// check if the room has discount
				if (room.getDiscount() > 0) {
					discount += room.getDiscount();
				}
			}
		});
	}
}
