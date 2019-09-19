package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exampledao.dao.UserDao;
import exampledao.dao.impl.DefaultUserDao;
import exampledao.models.UserData;

public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private DefaultUserDao userDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));

		UserDao test =  DefaultUserDao.getUserDaoInstance();
		UserData data = test.getUserById(id);
		response.getWriter().println(data);
	}

}
