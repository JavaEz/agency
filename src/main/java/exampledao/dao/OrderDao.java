package exampledao.dao;

import java.util.List;

import exampledao.models.Order;

public interface OrderDao {
	
	Order getOrderById(int orderId);

	List<Order> getAllOrders();

	List<Order> getOrdersByUserId(int userId);

	boolean deleteOrder(int orderId);

	int createOrder(int userId);
	
	public boolean updateOrder(int orderId, int userId);

}
