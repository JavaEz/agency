package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exampledao.dao.TourDao;
import exampledao.dao.impl.DefaultTourDao;
import exampledao.models.Tour;


public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TourDao tourDao = DefaultTourDao.getTourDaoInstance();
		List<Tour> tours = tourDao.getAllTours(); 
		
		request.setAttribute( "tours", tours);
		request.getRequestDispatcher("jsp/myaccount.jsp").forward(request, response);
	}

}
