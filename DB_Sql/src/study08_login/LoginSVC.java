package study08_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginSVC {

	Connection conn = null;
	Statement stmt = null;
	User user = null;

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
		}
	}

	public void connect() {

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		try {
			conn = DriverManager.getConnection(url, "javalink", "javalink");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Connection Success!");
	}

	public User login(String id, String passwd) {

		try {

			stmt = conn.createStatement();
			String sql = "SELECT * FROM member WHERE id = '" + id + "' AND " + "passwd = '" + passwd + "'";
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				user = new User();
				user.setId(id);
				user.setPasswd(passwd);
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
