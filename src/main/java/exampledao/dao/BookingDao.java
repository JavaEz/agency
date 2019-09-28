package exampledao.dao;

import java.util.List;

import exampledao.models.Booking;

public interface BookingDao {
	
	Booking getBookingById(int bookingId);

	List<Booking> getAllBookings();

	List<Booking> getBookingByOrderId(int orderId);

	boolean deleteBooking(int bookingId);

	boolean updateBooking(int bookingId, int orderId, int hotelId, String checkin, String checkout, int price,
			int nights);

	boolean createBooking(int orderId, int hotelId, String checkin, String checkout, int price, int nights);

}
