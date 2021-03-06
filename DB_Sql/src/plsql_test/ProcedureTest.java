package plsql_test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureTest {

	Connection conn = null;

	// 저장프로시저 호출전 데이터 입력
	public void insert() {
		PreparedStatement pstmt = null;
		connectDB();
		
		try {
			String sql = "insert into member3 values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Alpha");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "AI");
			pstmt.setInt(4, 20);
			pstmt.setString(5, "LA");
			pstmt.setString(6, "go@ai.com");
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				System.out.println("insert success!");
			}
			else {
				System.out.println("insert fail...");
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void select() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		connectDB();
		try {
			String sql = "select * from member3";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("passwd");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				
				System.out.println("아이디: " + id + ", 비밀번호: " + pw + ", 이름: " + name + ", 나이: " + age + 
						", 주소: " + addr + ", 이메일: " + email);
				
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// 저장프로시저 호출 후 데이터 입력
	public void insertMember() {
		
		CallableStatement cs = null;
		connectDB();
		
		try {
			String sql = "{call user_insert(?,?,?,?,?,?)}";
			cs = conn.prepareCall(sql);
			
			cs.setString(1, "Procudure");
			cs.setString(2, "1234");
			cs.setString(3, "홍길동");
			cs.setInt(4, 19);
			cs.setString(5, "강원도");
			cs.setString(6, "hong@aa.com");
			
			int count = cs.executeUpdate();
			
			if(count > 0) {
				System.out.println("insert success!");
			}
			else {
				System.out.println("insert fail...");
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void connectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			conn = DriverManager.getConnection(url, "javalink", "javalink");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("Connection Success");
	}

	public static void main(String[] args) {
		ProcedureTest pt = new ProcedureTest();		
		System.out.println("*** 저장프로시저 호출전 데이터 ***");
		pt.insert();
		pt.select();
		System.out.println("===== 저장프로시저 호출전 데이터 =====");
		pt.insertMember();
		pt.select();
	}

}
