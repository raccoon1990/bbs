package test4.mvc.myself;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class DaoClass implements Dao{

	DBConnect dc = DBConnect.getInstance();
	Connection conn = dc.getConnection();
	PreparedStatement pstmt = null;
	
	@Override
	public void delete(int num) {
		
		
		
		
	}
	
	@Override
	public void insert(Product p) {
		
		String query = "insert into product values(?, ?, ?)";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Product.getNextNo());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3, p.getPrice());
			int a = pstmt.executeUpdate();
			if(a < 1) {
				System.out.println("데이터 저장 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("데이터 저장 성공");
	}
	
	@Override
	public Product select(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Vector<Product> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(int num, Product p) {
		// TODO Auto-generated method stub
		
	}
}
