package servlets.adminpanel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exampledao.dao.TourDao;
import exampledao.dao.impl.DefaultTourDao;

/**
 * Servlet implementation class UpdateTour
 */
public class UpdateTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TourDao tourDao = DefaultTourDao.getTourDaoInstance();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int tourId = Integer.parseInt(request.getParameter("tourId"));
		String name = request.getParameter("name");
		String description = request.getParameter("desc");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int price = Integer.parseInt(request.getParameter("price"));

	
		tourDao.updateTour(tourId, name, description, start, end, price);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tourId = Integer.parseInt(request.getParameter("tourId"));
		boolean delete = "true".equals(request.getParameter("del"));
		if (delete) {
			tourDao.deleteTour(tourId);
		}
	}

	
	
}
