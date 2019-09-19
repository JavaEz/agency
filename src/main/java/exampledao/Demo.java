package exampledao;

import java.util.List;

import exampledao.dao.FlightDao;
import exampledao.dao.HotelDao;
import exampledao.dao.OrderDao;
import exampledao.dao.TourDao;
import exampledao.dao.UserDao;
import exampledao.dao.impl.DefaultFlightDao;
import exampledao.dao.impl.DefaultHotelDao;
import exampledao.dao.impl.DefaultOrderDao;
import exampledao.dao.impl.DefaultTourDao;
import exampledao.dao.impl.DefaultUserDao;
import exampledao.models.Tour;
import exampledao.models.UserData;

public class Demo {
	public static void main(String[] args) {

		UserDao userDao =  DefaultUserDao.getUserDaoInstance();
		//UserData userData = userDao.getUserById(2);
		//List<UserData> userData2 = userDao.getAllUsers();
		// userDao.createUser("Seriy2", "pisya", "toha@lds.net", "1990-03-02", 0);
		// userDao.createUser("Tomas", "Gigila", "mirkos@lds.net", "12/12/1929", 2);
		//userDao.updateUser(8, "toma2", "ppx", "tmgh", "08/12/2000", 0);
		 userDao.deleteUser(8);

		//System.out.println(userData2);
		//TourDao tourDao = new DefaultTourDao();

		// List<Tour> listTours = tourDao.getAllTours();
		//tourDao.createTour("Tour4", "spanish-italy", "12/12/1929", "08/12/2000", 452);
		//tourDao.updateTour(3, "Tour3updated", "spanish-italy", "11/11/1111", "12/12/1212", 454);
		// tourDao.deleteTour(2);
		// tourDao.orderTour(0, 1);

		// Tour tour = tourDao.getTourById(1);
		// System.out.println(listTours);
//
		//HotelDao hotelDao = new DefaultHotelDao();
		//hotelDao.updateHotel(5, "d", "AD", 33, "kiev");
		//hotelDao.createHotel("Hote1", "pushi", 43, "kiev");
		//OrderDao orderDao = new DefaultOrderDao();
		//orderDao.createOrder(5);
		//orderDao.deleteOrder(1);
		//orderDao.updateOrder(2, 3);

//		FlightDao flightDao = new DefaultFlightDao();
//		flightDao.createFlight("12/12/1990", "lviv", "kiev", 35);
	}
}
