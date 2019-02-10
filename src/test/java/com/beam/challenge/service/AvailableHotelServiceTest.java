package com.beam.challenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import com.beam.challenge.model.request.AvailableHotelSearchRequest;
import com.beam.challenge.model.response.AvailableHotelSeachResponse;
import com.beam.challenge.model.response.BestHotelResponse;
import com.beam.challenge.model.response.BestHotelSearchResponse;
import com.beam.challenge.model.response.CrazyHotelResponse;
import com.beam.challenge.model.response.CrazyHotelSearchResponse;
import com.beam.challenge.provider.BestHotelProvider;
import com.beam.challenge.provider.CrazyHotelProvider;
import com.beam.challenge.service.impl.AvailableHotelServiceImpl;

@RunWith(SpringRunner.class)
public class AvailableHotelServiceTest {

	@InjectMocks
	private AvailableHotelServiceImpl bestHotelService;

	@Spy
	private BestHotelProvider bestHotelProvider;

	@Spy
	private CrazyHotelProvider crazyHotelProvider;

	@Test
	public void searchBestHotels() {
		// Arrange
		AvailableHotelSearchRequest searchRequest = new AvailableHotelSearchRequest();
		searchRequest.setFromDate(LocalDate.now().minusDays(1));
		searchRequest.setToDate(LocalDate.now().plusDays(6));
		searchRequest.setNumOfAdults(3);

		// For random generate of stars
		String rate = "*****";

		BestHotelSearchResponse bestHotelSearchResponse = new BestHotelSearchResponse();
		CrazyHotelSearchResponse crazyHotelSearchResponse = new CrazyHotelSearchResponse();

		// Best Hotels
		for (int i = 1; i <= 5; i++) {
			BestHotelResponse bestHotelResponse = new BestHotelResponse("Best Hotel #" + i);
			bestHotelResponse.setFare(i * 100);
			bestHotelResponse.setRate(i);
			bestHotelSearchResponse.getBestHotelResponses().add(bestHotelResponse);
		}

		// Crazy Hotels
		for (int i = 1; i <= 5; i++) {
			CrazyHotelResponse crazyHotelResponse = new CrazyHotelResponse("Crazy Hotel #" + i);
			crazyHotelResponse.setPrice(i * 90);
			crazyHotelResponse.setRate(rate.substring(0, i));
			crazyHotelSearchResponse.getCrazyHotelResponses().add(crazyHotelResponse);
		}

		when(bestHotelProvider.searchHotels(ArgumentMatchers.any())).thenReturn(bestHotelSearchResponse);
		when(crazyHotelProvider.searchHotels(ArgumentMatchers.any())).thenReturn(crazyHotelSearchResponse);

		// Act
		AvailableHotelSeachResponse excpectedAvailableHotels = bestHotelService.searchHotels(searchRequest);

		// Assert
		assertNotNull(excpectedAvailableHotels.getAvailableHotelResponses());
		assertEquals("Best Hotel #5", excpectedAvailableHotels.getAvailableHotelResponses().get(0).getHotelName());
		assertEquals(5, excpectedAvailableHotels.getAvailableHotelResponses().get(0).getRate());
	}

	@Test
	public void searchBestHotels_emptyResult() {
		// Arrange
		AvailableHotelSearchRequest searchRequest = new AvailableHotelSearchRequest();
		searchRequest.setFromDate(LocalDate.now().minusDays(1));
		searchRequest.setToDate(LocalDate.now().plusDays(6));
		searchRequest.setNumOfAdults(3);

		when(bestHotelProvider.searchHotels(ArgumentMatchers.any())).thenReturn(null);
		when(crazyHotelProvider.searchHotels(ArgumentMatchers.any())).thenReturn(null);

		// Act
		AvailableHotelSeachResponse excpectedAvailableHotels = bestHotelService.searchHotels(searchRequest);

		// Assert
		assertEquals(0, excpectedAvailableHotels.getAvailableHotelResponses().size());
	}

	@Test
	public void searchBestHotels_oneProviderIsDown() {
		// Arrange
		AvailableHotelSearchRequest searchRequest = new AvailableHotelSearchRequest();
		searchRequest.setFromDate(LocalDate.now().minusDays(1));
		searchRequest.setToDate(LocalDate.now().plusDays(6));
		searchRequest.setNumOfAdults(3);

		// Best Hotels
		BestHotelSearchResponse bestHotelSearchResponse = new BestHotelSearchResponse();
		for (int i = 1; i <= 5; i++) {
			BestHotelResponse bestHotelResponse = new BestHotelResponse("Best Hotel #" + i);
			bestHotelResponse.setFare(i * 100);
			bestHotelResponse.setRate(i);
			bestHotelSearchResponse.getBestHotelResponses().add(bestHotelResponse);
		}

		when(bestHotelProvider.searchHotels(ArgumentMatchers.any())).thenReturn(bestHotelSearchResponse);
		when(crazyHotelProvider.searchHotels(ArgumentMatchers.any())).thenReturn(null);

		// Act
		AvailableHotelSeachResponse excpectedAvailableHotels = bestHotelService.searchHotels(searchRequest);

		// Assert
		assertEquals(5, excpectedAvailableHotels.getAvailableHotelResponses().size());
		assertEquals("Best Hotel #5", excpectedAvailableHotels.getAvailableHotelResponses().get(0).getHotelName());
		assertEquals(5, excpectedAvailableHotels.getAvailableHotelResponses().get(0).getRate());
	}
}
