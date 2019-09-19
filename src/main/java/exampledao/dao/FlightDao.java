package exampledao.dao;

import java.util.List;

import exampledao.models.Flight;

public interface FlightDao {

	Flight getFlightById(int flightId);

	List<Flight> getAllFlights();

	List<Flight> getFlightsByPeriod(String start, String end);

	boolean createFlight(String departure, String fromCity, String toCity, int price);

	boolean updateFlight(int flightId, String departure, String fromCity, String toCity, int price);

	boolean deleteFlight(int flightId);

	boolean orderFlight(Integer orderId, int flightId);

}
