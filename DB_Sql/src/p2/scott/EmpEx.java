package p2.scott;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// scott db에 있는 emp테이블 데이터를 자바에서 출력
// 조건-스캐너 입력을 받아서 empno - 7902에 해당 레코드(tuple) 출력하기
public class EmpEx {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
        try {
			//Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";			
			
			conn = DriverManager.getConnection(url, "scott", "scott");
					
			System.out.print("번호 입력 >> ");
			int input = scan.nextInt();
			
			String query = "select * from emp where empno=?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, input);
			
			ResultSet rs = pstmt.executeQuery(); // 이미 query를 넣어 준비했음
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				SimpleDateFormat fm = new SimpleDateFormat("yyyy년 MM월 dd일");
				
				
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				double deptno = rs.getDouble("deptno");
				
				System.out.println(empno + "," + ename +","+job+","+mgr+","
							+fm.format(hiredate)+","+sal+","+comm+","+deptno);
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        System.out.println("정상종료");
        try {
			conn.close();
		} catch (SQLException e) {
			
		}

	}

}
