package exampledao.models;

import java.util.Date;

public class Flight {

	private int flightId;
	private String fromCity;
	private String toCity;
	private Date departure;
	private int price;

	public Flight(int flightId, String fromCity, String toCity, Date departure, int price) {
		this.flightId = flightId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departure = departure;
		this.price = price;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", fromCity=" + fromCity + ", toCity=" + toCity + ", departure="
				+ departure + ", price=" + price + "]";
	}

}
