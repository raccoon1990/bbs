package mms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

//Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
public class MemberDAO {

	Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {

		String sql = "insert into mms_member(id,name,addr,nation,email,age) values(member_id_seq.nextval,?,?,?,?,?)";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());

			count = pstmt.executeUpdate();

			return count;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		JdbcUtil.close(con);

		return count;
	}

	public ArrayList<Member> selectMemberList() {

		ArrayList<Member> members = new ArrayList<Member>();

		String sql = "select * from mms_member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Member member = new Member();

				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				member.setNation(rs.getString("nation"));
				member.setEmail(rs.getString("email"));
				member.setAge(rs.getInt("age"));

				members.add(member);
			}

			return members;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return members;
		}
		
		

	}

	public Member selectOldMember(String name) {

		Member oldMember = null;

		String sql = "select * from mms_member where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				oldMember = new Member();
				
				oldMember.setId(rs.getInt("id"));
				oldMember.setName(rs.getString("name"));
				oldMember.setAddr(rs.getString("addr"));
				oldMember.setNation(rs.getString("nation"));
				oldMember.setEmail(rs.getString("email"));
				oldMember.setAge(rs.getInt("age"));
			}

			return oldMember;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return oldMember;
		}		
	}

	public int updateMember(Member updateMember) {

		String sql = "update mms_member set nation=?,addr=?,email=?,age=? where name = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getNation());
			pstmt.setString(2, updateMember.getAddr());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5, updateMember.getName());
			
			count = pstmt.executeUpdate();
			
			return count;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return count;
		}
	}

	public int deleteMember(String name) {

		String sql = "delete from mms_member where name=?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			count = pstmt.executeUpdate();
			return count;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return count;
		}
	}

}
