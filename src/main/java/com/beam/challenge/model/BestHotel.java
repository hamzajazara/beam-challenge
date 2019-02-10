package com.beam.challenge.model;

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
public class BestHotel extends Hotel {

	private double fare;

	private int rate;

	private List<BestRoom> bestRooms;
}
