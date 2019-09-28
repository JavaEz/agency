package exampledao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import exampledao.conntobd.BaseConn;
import exampledao.dao.FlightDao;
import exampledao.models.Flight;
import exampledao.models.Hotel;
import exampledao.someanothermethods.DateTimeConverter;

public class DefaultFlightDao implements FlightDao {

	BaseConn baseconn = new BaseConn();

	private final static String CREATE_FLIGHT = "INSERT INTO flights (`departure`, `from_city_id`, `from_city_name`, `to_city_id`, `to_city_name`, `price`) "
			+ "VALUES(?, (SELECT city_id FROM cities WHERE city_name = ?) , ?, (SELECT city_id FROM cities WHERE city_name = ?), ?, ?)";
	private final static String DELETE_FLIGHT = "DELETE FROM flights WHERE flight_id = ? LIMIT 1";
	private final static String UPDATE_FLIGHT = "SET `departure`= ?, `from_city_id`= (SELECT city_id FROM cities WHERE city_name = ?), `from_city_name`= ?, `to_city_id`= (SELECT city_id FROM cities WHERE city_name = ?), `to_city_name`= ?, `price`= ? WHERE `flight_id`=?;";
	private final static String SELECT_FLIGHT_BY_ID = "SELECT * FROM flights WHERE flight_id = ?";
	private final static String SELECT_ALL_FLIGHTS = "SELECT * FROM flights";
	private final static String SELECT_FLIGHT_BY_PERIOD = "SELECT * FROM flights WHERE departure >= ? AND departure <= ?";
	private final static String ORDER_FLIGHT = "INSERT INTO orders_flights (order_id, flight_id) VALUES(?, ?);";
	private final static String DELETE_ORDERED_FLIGHT = "DELETE FROM orders_flights WHERE order_id =?";

	@Override
	public Flight getFlightById(int flightId) {
		Flight flight = null;
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_FLIGHT_BY_ID);) {
			statement.setInt(1, flightId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				flight = new Flight(rs.getInt("flight_id"), rs.getString("to_city_name"),
						rs.getString("from_city_name"), rs.getDate("departure"), rs.getInt("price"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flight;
	}

	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getFlightsByPeriod(String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createFlight(String departure, String fromCity, String toCity, int price) {
		java.sql.Date sqlDeparturetDate = DateTimeConverter.toSqlDate(departure);
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(CREATE_FLIGHT);) {
			statement.setDate(1, sqlDeparturetDate);
			statement.setString(2, fromCity);
			statement.setString(3, fromCity);
			statement.setString(4, toCity);
			statement.setString(5, toCity);
			statement.setInt(6, price);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateFlight(int flightId, String departure, String fromCity, String toCity, int price) {
		java.sql.Date sqlDeparturetDate = DateTimeConverter.toSqlDate(departure);
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(CREATE_FLIGHT);) {
			statement.setDate(1, sqlDeparturetDate);
			statement.setString(2, fromCity);
			statement.setString(3, fromCity);
			statement.setString(4, toCity);
			statement.setString(5, toCity);
			statement.setInt(6, price);
			statement.setInt(7, flightId);
			

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteFlight(int flightId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean orderFlight(Integer orderId, int flightId) {
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(ORDER_FLIGHT);) {
			statement.setInt(1, orderId);
			statement.setInt(2, flightId);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	private static Flight getFlightFromDb(ResultSet rs) throws SQLException {
		return new Flight(rs.getInt("flight_id"), rs.getString("from_city_name"), rs.getString("to_city_name"),
				rs.getDate("departure"), rs.getInt("price"));

	}
}
