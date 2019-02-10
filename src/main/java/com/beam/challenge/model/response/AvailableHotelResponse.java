package com.beam.challenge.model.response;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Setter
@Getter
public class AvailableHotelResponse extends HotelResponse implements Comparable<AvailableHotelResponse> {
	
	private String providerName;
	
	private double fare;
	
	private List<String> amenities;
	
	private int rate;

	public AvailableHotelResponse(String hotelName) {
		super(hotelName);
	}

	public <T extends HotelResponse> AvailableHotelResponse(T hotelsResponse) {
		this(hotelsResponse.getHotelName());
		
		if (hotelsResponse instanceof BestHotelResponse) {
			BestHotelResponse bestHotelsResponse = (BestHotelResponse) hotelsResponse;
			providerName = "Best Hotels";
			fare = bestHotelsResponse.getFare();
			rate = bestHotelsResponse.getRate();
			if (bestHotelsResponse.getAmenities() != null) {
				amenities = Arrays.asList(bestHotelsResponse.getAmenities().split("\\s*,\\s*"));
			}
			
		} else if (hotelsResponse instanceof CrazyHotelResponse) {
			CrazyHotelResponse crazyHotelsResponse = (CrazyHotelResponse) hotelsResponse;
			providerName = "Crazy Hotels";
			fare = crazyHotelsResponse.getPrice();
			rate = crazyHotelsResponse.getRate().length();
			amenities = crazyHotelsResponse.getAmenities();
		}
	}

	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(AvailableHotelResponse target) {
		return target.getRate() - this.rate;
	}
}
