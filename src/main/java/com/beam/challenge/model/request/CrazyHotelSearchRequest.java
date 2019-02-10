package com.beam.challenge.model.request;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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
public class CrazyHotelSearchRequest {

	@NotEmpty(message = "City can't be empty")
	private String city;

	@NotNull(message = "From Date can't be null")
	private LocalDateTime fromDate;

	@NotNull(message = "To Date can't be null")
	private LocalDateTime toDate;

	@PositiveOrZero(message = "Adults Count should be zero or positive number")
	private int adultsCount;

	public CrazyHotelSearchRequest(AvailableHotelSearchRequest hotelSearchRequest) {
		city = hotelSearchRequest.getCity();
		fromDate = LocalDateTime.from(hotelSearchRequest.getFromDate().atStartOfDay().atZone(ZoneId.systemDefault()));
		toDate = LocalDateTime.from(hotelSearchRequest.getToDate().atStartOfDay().atZone(ZoneId.systemDefault()));
		adultsCount = hotelSearchRequest.getNumOfAdults();
	}
}
