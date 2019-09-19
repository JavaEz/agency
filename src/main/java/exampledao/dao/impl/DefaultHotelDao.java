package exampledao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exampledao.conntobd.BaseConn;
import exampledao.dao.HotelDao;
import exampledao.models.Hotel;
import exampledao.someanothermethods.DateTimeConverter;

public class DefaultHotelDao implements HotelDao {

	BaseConn baseconn = new BaseConn();

	// private final static String CREATE_HOTEL = "INSERT INTO hotels (name,
	// address, price, city_name) VALUES(?, ?, ?, ?)";
	private final static String CREATE_HOTEL = "INSERT INTO hotels (`name`, `address`, `price`, `city_id`, `city_name`)"
			+ "VALUES(?, ?, ?, (SELECT city_id FROM cities WHERE city_name = ?), ?)";
	private final static String DELETE_HOTEL = "DELETE FROM hotels WHERE hotel_id = ?";
	private final static String UPDATE_HOTEL = "UPDATE hotels SET  name = ?, address = ?, price = ?,  city_name= ? WHERE hotel_id =?;";
	private final static String SELECT_HOTEL_BY_ID = "SELECT * FROM hotels WHERE hotel_id = ?";
	private final static String SELECT_HOTELS_BY_CITY = "SELECT * FROM hotels WHERE city_name = ?;";
	private final static String SELECT_ALL_HOTELS = "SELECT * FROM hotels";

// (SELECT city_id FROM cities WHERE city_name = ?)
	@Override
	public Hotel getHotelById(int hotelId) {
		Hotel hotel = null;
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_HOTEL_BY_ID);) {
			statement.setInt(1, hotelId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				hotel = new Hotel(rs.getInt("hotel_id"), rs.getString("name"), rs.getString("address"),
						rs.getInt("price"), rs.getString("city_name"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> hotelList = new ArrayList<>();
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_HOTELS);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				hotelList.add(getHotelFromDb(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotelList;
	}

	@Override
	public List<Hotel> getHotelsByCity(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_HOTEL);) {
			statement.setInt(1, hotelId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createHotel(String name, String address, int price, String city) {
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(CREATE_HOTEL);) {
			statement.setString(1, name);
			statement.setString(2, address);
			statement.setInt(3, price);
			statement.setString(4, city);
			statement.setString(5, city);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean updateHotel(int hotelId, String name, String address, int price, String city) {
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_HOTEL);) {

			statement.setString(1, name);
			statement.setString(2, address);
			statement.setInt(3, price);
			statement.setString(4, city);
			statement.setInt(5, hotelId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	private static Hotel getHotelFromDb(ResultSet rs) throws SQLException {
		return new Hotel(rs.getInt("hotel_id"), rs.getString("name"), rs.getString("address"), rs.getInt("price"),
				rs.getString("city_name"));
	}

}
