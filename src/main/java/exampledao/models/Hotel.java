package exampledao.models;

public class Hotel {

	private int hotelId;
	private String name;
	private String address;
	private int price;
	private String city;

	public Hotel(int hotelId, String name, String address, int price, String city) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.address = address;
		this.price = price;
		this.city = city;
	}

	public Hotel() {

	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", address=" + address + ", price=" + price
				+ ", city=" + city + "]";
	}
	
	

}
