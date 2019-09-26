  package servlets;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exampledao.dao.UserDao;
import exampledao.dao.impl.DefaultUserDao;
import exampledao.models.UserData;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = DefaultUserDao.getUserDaoInstance();
		UserData user = userDao.getUserByEmail(email);
		 
		

		if (user!= null && user.getPassword().equals(password)) {
			UserData userData = new UserData();
			userData.setRole(1);
			HttpSession session = request.getSession();
			session.setAttribute("UserEmail", email);
			session.setAttribute("loggedInUser",userData);
			response.sendRedirect(getServletContext().getContextPath() + "/myaccount");
		}else {
			request.setAttribute("errMessage", "incorrect email");
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}
	}
	 
	
	

}
