package test4.mvc.myself;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static DBConnect db = new DBConnect();
	Connection conn = null;
	
	private DBConnect() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url, "javalink", "javalink");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("DB 접속 성공");
	}

	public static DBConnect getInstance() {
		return db;
	}

	public Connection getConnection() {
		return conn;
	}

}
