package mms.member.svc;

import java.sql.Connection;
import java.util.ArrayList;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberListService {
	
	Connection conn = null;
	
	public ArrayList<Member> getMemberList() {
		
		ArrayList<Member> members = new ArrayList<Member>();
		
		conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO(conn);
		
		members = dao.selectMemberList();		
		
		return members;
	}

}
