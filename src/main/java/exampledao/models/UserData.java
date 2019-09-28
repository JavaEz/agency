package exampledao.models;

import java.util.Date;
import java.util.List;

public class UserData {
	private int userId;
	private String username;
	private String password;
	private String email;
	private Date birthday;
	private int role;
	private List<Order> orders;

	public UserData(int id, String username, String password, String email, Date birthday, int role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.role = role;
	}
	
	public UserData(int id, String username, String password, String email, Date birthday, int role, List<Order> orders) {
		super();
		this.userId = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.role = role;
		this.orders = orders;
	}

	public UserData() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", username=" + username + ", email=" + email + ", birthday=" + birthday
				+ ", role=" + role + "]";
	}

	

}
