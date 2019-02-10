package com.beam.challenge.model.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class AvailableHotelSearchRequest {

	private String city;

	private LocalDate fromDate;

	private LocalDate toDate;

	private int numOfAdults;
}
