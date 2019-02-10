package com.beam.challenge.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Setter
@Getter
public class CrazyRoom extends Room {

	private LocalDateTime fromDate;

	private LocalDateTime toDate;

	private int adultsCount;

	private double discount;

	private String[] amenities;
}
