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
public class CrazyHotel extends Hotel {

	private double price;

	private String rate;

	private List<CrazyRoom> crazyRooms;
}
