package exampledao.dao;

import java.util.List;

import exampledao.models.Hotel;

public interface HotelDao {

	Hotel getHotelById(int hotelId);

	List<Hotel> getAllHotels();

	List<Hotel> getHotelsByCity(String cityName);

	boolean deleteHotel(int hotelId);

	boolean createHotel(String name, String address, int price, String city);

	boolean updateHotel(int hotelId, String name, String address, int price, String city);

}
