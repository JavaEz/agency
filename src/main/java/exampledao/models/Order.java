package exampledao.models;

public class Order {

	private int userId;
	private int orderId;
	private String userEmail;
	private int tourId;
	private String tourName;
	private int tourPrice;
	private int flightId;
	private int flightPrice;
	private int hotelId;
	private int hotelPrice;

	public Order(OrderBuilder builder) {
		this.userId = builder.userId;
		this.orderId = builder.orderId;
		this.userEmail = builder.userEmail;
		this.tourId = builder.tourId;
		this.tourName = builder.tourName;
		this.tourPrice = builder.tourPrice;
		this.flightId = builder.flightId;
		this.flightPrice = builder.flightPrice;
		this.hotelId = builder.hotelId;
		this.hotelPrice = builder.hotelPrice;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public int getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(int tourPrice) {
		this.tourPrice = tourPrice;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(int flightPrice) {
		this.flightPrice = flightPrice;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", orderId=" + orderId + ", userEmail=" + userEmail + ", tourId=" + tourId
				+ ", tourName=" + tourName + ", tourPrice=" + tourPrice + ", flightId=" + flightId + ", flightPrice="
				+ flightPrice + ", hotelId=" + hotelId + ", hotelPrice=" + hotelPrice + "]";
	}

	public static class OrderBuilder {

		private int userId;
		private int orderId;
		private String userEmail;
		private int tourId;
		private String tourName;
		private int tourPrice;
		private int flightId;
		private int flightPrice;
		private int hotelId;
		private int hotelPrice;

		public OrderBuilder(int userId, int orderId, String userEmail) {
			this.userId = userId;
			this.orderId = orderId;
			this.userEmail = userEmail;
		}

		public OrderBuilder setHotelPrice(int hotelPrice) {
			this.hotelPrice = hotelPrice;
			return this;
		}

		public OrderBuilder setHotelId(int hotelId) {
			this.hotelId = hotelId;
			return this;
		}

		public OrderBuilder setFlightPrice(int flightPrice) {
			this.flightPrice = flightPrice;
			return this;
		}

		public OrderBuilder setFlightId(int flightId) {
			this.flightId = flightId;
			return this;
		}

		public OrderBuilder setTourPrice(int tourPrice) {
			this.tourPrice = tourPrice;
			return this;
		}

		public OrderBuilder setTourName(String tourName) {
			this.tourName = tourName;
			return this;
		}

		public OrderBuilder setTourId(int tourId) {
			this.tourId = tourId;
			return this;
		}

	}
}
