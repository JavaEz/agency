package exampledao.dao;

import java.util.List;

import exampledao.models.Tour;

public interface TourDao {

	Tour getTourById(int tourId);

	List<Tour> getAllTours();

	List<Tour> getToursByPeriod(String start, String end);

	boolean createTour(String name, String description, String start, String end, int price);

	boolean updateTour(int tourId, String name, String description, String start, String end, int price);

	boolean deleteTour(int tourId);
	
	boolean orderTour(int orderId, int tourId);
}
