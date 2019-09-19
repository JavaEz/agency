package exampledao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import exampledao.conntobd.BaseConn;
import exampledao.dao.OrderDao;
import exampledao.models.Order;

public class DefaultOrderDao implements OrderDao {

	BaseConn baseconn = new BaseConn();

	private final static String CREATE_ORDER = "INSERT INTO orders (user_id) VALUES (?);";
	private final static String SELECT_LAST_ORDER_ID = " SELECT LAST_INSERT_ID() AS last_order_id;";
	private final static String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";
	private final static String SELECT_ORDER_BY_USER_ID = null;
	private final static String SELECT_ALL_ORDERS = null;
	private final static String SELECT_ORDER_BY_ID = null;
	private final static String UPDATE_ORDER = "UPDATE orders SET  user_id = ? WHERE order_id =?;";
	
	private static DefaultOrderDao instance;
	
	private DefaultOrderDao() {
}

public static synchronized DefaultOrderDao getOrderDaoInstance() {
	if(instance == null) {
		instance = new DefaultOrderDao();
	}
	return instance;
}

	@Override
	public Order getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_ORDER);) {
			statement.setInt(1, orderId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int createOrder(int userId) {

		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(CREATE_ORDER);) {
			statement.setInt(1, userId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	private static Order getOrderFromDb(ResultSet rs) throws SQLException {
		int userId = rs.getInt("user_id");
		String userEmail = rs.getString("user_email");
		int orderId = rs.getInt("order_id");
		int tourId = rs.getInt("tour_id");
		String tourName = rs.getString("tour_name");
		;
		int tourPrice = rs.getInt("tour_price");
		int flightId = rs.getInt("flight_id");
		int flightPrice = rs.getInt("flight_price");
		int hotelId = rs.getInt("hotel_id");
		int hotelPrice = rs.getInt("hotel_price");

		return new Order(new Order.OrderBuilder(userId, orderId, userEmail).setTourId(tourId)
				.setTourName(tourName).setTourPrice(tourPrice).setFlightId(flightId).setFlightPrice(flightPrice)
				.setHotelId(hotelId).setHotelPrice(hotelPrice));
	}

	@Override
	public boolean updateOrder(int orderId, int userId) {
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_ORDER);) {

			statement.setInt(1, userId);
			statement.setInt(2, orderId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
