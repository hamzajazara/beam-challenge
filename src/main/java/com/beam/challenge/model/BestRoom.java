package com.beam.challenge.model;

import java.time.LocalDate;
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
public class BestRoom extends Room {

	private LocalDate fromDate;

	private LocalDate toDate;

	private int adultsCount;

	private List<String> amenities;
}
