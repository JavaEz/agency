package exampledao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import exampledao.conntobd.BaseConn;
import exampledao.dao.OrderDao;
import exampledao.models.Flight;
import exampledao.models.Order;

public class DefaultOrderDao implements OrderDao {

	BaseConn baseconn = new BaseConn();

	private final static String CREATE_ORDER = "INSERT INTO orders (user_id) VALUES (?);";
	private final static String SELECT_LAST_ORDER_ID = " SELECT LAST_INSERT_ID() AS last_order_id;";
	private final static String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";
	private final static String SELECT_ORDER_BY_USER_ID = "SELECT o.order_id, u.user_id, email AS user_email, t.tour_id, t.name AS tour_name, t.price AS tour_price "
			+ "f.flight_id, f.price AS flight_price, h.hotel_id, oh.price AS hotel_price "
			+ "FROM orders o INNER JOIN users u ON o.user_id = u.user_id LEFT JOIN orders_tours ot ON o.order_id = ot.order_id "
			+ "LEFT JOIN tours t ON t.tour_id = ot.tour_id LEFT JOIN orders_flights of ON o.order_id = of.order_id "
			+ "LEFT JOIN flights f ON f.flight_id = of.flight_id LEFT JOIN orders_hotels oh ON o.order_id = oh.order_id ";

	private final static String SELECT_ALL_ORDERS = null;
	private final static String SELECT_ORDER_BY_ID = "SELECT o.order_id, u.user_id, u.email AS user_email, t.tour_id, t.`name` AS tour_name, t.price AS tour_price, "
			+ "f.flight_id, f.price AS flight_price, h.hotel_id, oh.price AS hotel_price "
			+ "FROM orders o INNER JOIN users u ON o.user_id = u.user_id LEFT JOIN orders_tours ot ON o.order_id = ot.order_id "
			+ "LEFT JOIN tours t ON t.tour_id = ot.tour_id LEFT JOIN orders_flights ofl ON o.order_id = ofl.order_id "
			+ "LEFT JOIN flights f ON f.flight_id = ofl.flight_id LEFT JOIN orders_hotels oh ON o.order_id = oh.order_id "
			+ "LEFT JOIN hotels h ON h.hotel_id = oh.hotel_id WHERE o.order_id = ? GROUP BY o.order_id";

	private final static String UPDATE_ORDER = "UPDATE orders SET  user_id = ? WHERE order_id =?;";

	private static DefaultOrderDao instance;

	private DefaultOrderDao() {
	}

	public static synchronized DefaultOrderDao getOrderDaoInstance() {
		if (instance == null) {
			instance = new DefaultOrderDao();
		}
		return instance;
	}

	@Override
	public Order getOrderById(int orderId) {
		Order order = null;
		try (Connection conn = baseconn.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ORDER_BY_ID);) {
			statement.setInt(1, orderId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				order = getOrderFromDb(rs);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
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
		int tourPrice = rs.getInt("tour_price");
		int flightId = rs.getInt("flight_id");
		int flightPrice = rs.getInt("flight_price");
		int hotelId = rs.getInt("hotel_id");
		int hotelPrice = rs.getInt("hotel_price");

		return new Order(new Order.OrderBuilder(userId, orderId, userEmail).setTourId(tourId).setTourName(tourName)
				.setTourPrice(tourPrice).setFlightId(flightId).setFlightPrice(flightPrice).setHotelId(hotelId)
				.setHotelPrice(hotelPrice));
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
