package exampledao.conntobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConn {
	
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travelAgency";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Rembrant99";
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(MYSQL_JDBC_DRIVER_NAME);
			connection = DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME + PARAMS, USERNAME, PASSWORD);
			System.out.println("Connection is ready");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Connection False");
		}
		return connection;
	}

}
