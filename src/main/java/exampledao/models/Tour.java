package exampledao.models;

import java.util.Date;

public class Tour {
	private int tourId;
	private String name;
	private String description;
	private Date start;
	private Date end;
	private int price;

	public Tour(int tourId, String name, String description, Date start, Date end, int price) {
		super();
		this.tourId = tourId;
		this.name = name;
		this.description = description;
		this.start = start;
		this.end = end;
		this.price = price;
	}
	
	public Tour() {
		
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Tour [tourId=" + tourId + ", name=" + name + ", description=" + description + ", start=" + start
				+ ", end=" + end + ", price=" + price + "]";
	}

}
