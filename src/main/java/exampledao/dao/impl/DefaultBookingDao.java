package exampledao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import exampledao.conntobd.BaseConn;
import exampledao.dao.BookingDao;
import exampledao.models.Booking;
import exampledao.models.Flight;

public class DefaultBookingDao implements BookingDao {

	BaseConn baseconn = new BaseConn();

	private final static String CREATE_BOOKING = "INSERT INTO orders_hotels (order_id, hotel_id, checkin, checkout, price, nights) VALUES(?, ?, ?, ?, ?, ?)";
	private final static String UPDATE_BOOKING = "UPDATE `travelAgency`.`orders_hotels` SET `order_id`= ?, `hotel_id`= ?, `checkin`= ?, `checkout`= ?, `price`= ?, `nights`= ? WHERE `booking_id`= ?;";
	private final static String DELETE_BOOKING = "DELETE FROM orders_hotels WHERE booking_id = ?";
	private final static String SELECT_BOOKING_BY_ID = "SELECT * FROM orders_hotels WHERE booking_id = ?";
	private final static String SELECT_BOOKING_BY_ORDER_ID = "SELECT * FROM orders_hotels WHERE order_id = ?";
	private final static String SELECT_ALL_BOOKINGS = "SELECT * FROM orders_hotels";

	@Override
	public Booking getBookingById(int bookingId) {
		Booking booking = null;
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_BOOKING_BY_ID);) {
			statement.setInt(1, bookingId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				booking = new Booking(rs.getInt("booking_id"), rs.getInt("order_id"), rs.getInt("hotel_id"),
						rs.getDate("checkin"), rs.getDate("checkout"), rs.getInt("price"), rs.getInt("nights"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return booking;
	}

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBooking(int bookingId, int orderId, int hotelId, String checkin, String checkout, int price,
			int nights) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createBooking(int orderId, int hotelId, String checkin, String checkout, int price, int nights) {
		// TODO Auto-generated method stub
		return false;
	}

	private static Booking getBookingFromDb(ResultSet rs) throws SQLException {
		return new Booking(rs.getInt("booking_id"), rs.getInt("order_id"), rs.getInt("hotel_id"), rs.getDate("checkin"),
				rs.getDate("checkout"), rs.getInt("price"), rs.getInt("nights"));
	}
}
