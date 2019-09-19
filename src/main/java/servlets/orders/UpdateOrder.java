package servlets.orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exampledao.dao.OrderDao;
import exampledao.dao.impl.DefaultOrderDao;

/**
 * Servlet implementation class UpdateOrder
 */
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		int orderId = Integer.parseInt(request.getParameter("orderId"));

		OrderDao orderDao = DefaultOrderDao.getOrderDaoInstance();
		orderDao.updateOrder(orderId, userId);
	}

}
